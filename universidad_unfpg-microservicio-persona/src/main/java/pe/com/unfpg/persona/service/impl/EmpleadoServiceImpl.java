package pe.com.unfpg.persona.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.persona.client.CatalogoFeignClient;
import pe.com.unfpg.persona.entity.EmpleadoEntity;
import pe.com.unfpg.persona.repository.EmpleadoRepository;
import pe.com.unfpg.persona.service.EmpleadoService;


@Service
public class EmpleadoServiceImpl implements EmpleadoService {
 
    private final EmpleadoRepository repositorio;
    private final CatalogoFeignClient catalogoFeignClient;
 
    EmpleadoServiceImpl(EmpleadoRepository repositorio, CatalogoFeignClient catalogoFeignClient) {
        this.repositorio = repositorio;
        this.catalogoFeignClient = catalogoFeignClient;   // NEW
    }
 
    @Override
    public List<EmpleadoEntity> findAll() {
        List<EmpleadoEntity> empleados = repositorio.findAll();
        for (EmpleadoEntity empleado : empleados) {
            empleado.setDistrito(catalogoFeignClient.getDistrito(empleado.getCoddis()));
            empleado.setEstadocivil(catalogoFeignClient.getEstadoCivil(empleado.getCodestc()));
            empleado.setSexo(catalogoFeignClient.getSexo(empleado.getCodsex()));
            empleado.setTipodocumento(catalogoFeignClient.getTipoDocumento(empleado.getCodtipd()));
            empleado.setCargo(catalogoFeignClient.getCargo(empleado.getCodcar()));
            empleado.setAreaempleo(catalogoFeignClient.getAreaEmpleo(empleado.getCodare()));
        }
        return empleados;
    }
 
    @Override
    public List<EmpleadoEntity> findAllCustom() {
        List<EmpleadoEntity> empleados = repositorio.findAllCustom();
        for (EmpleadoEntity empleado : empleados) {
            empleado.setDistrito(catalogoFeignClient.getDistrito(empleado.getCoddis()));
            empleado.setEstadocivil(catalogoFeignClient.getEstadoCivil(empleado.getCodestc()));
            empleado.setSexo(catalogoFeignClient.getSexo(empleado.getCodsex()));
            empleado.setTipodocumento(catalogoFeignClient.getTipoDocumento(empleado.getCodtipd()));
            empleado.setCargo(catalogoFeignClient.getCargo(empleado.getCodcar()));
            empleado.setAreaempleo(catalogoFeignClient.getAreaEmpleo(empleado.getCodare()));
        }
        return empleados;
    }
 
    @Override
    public EmpleadoEntity findById(Long id) {
        EmpleadoEntity empleado = repositorio.findById(id).get();
        empleado.setDistrito(catalogoFeignClient.getDistrito(empleado.getCoddis()));
        empleado.setEstadocivil(catalogoFeignClient.getEstadoCivil(empleado.getCodestc()));
        empleado.setSexo(catalogoFeignClient.getSexo(empleado.getCodsex()));
        empleado.setTipodocumento(catalogoFeignClient.getTipoDocumento(empleado.getCodtipd()));
        empleado.setCargo(catalogoFeignClient.getCargo(empleado.getCodcar()));
        empleado.setAreaempleo(catalogoFeignClient.getAreaEmpleo(empleado.getCodare()));
        return empleado;
    }
 
    @Override
    public EmpleadoEntity add(EmpleadoEntity obj) {
        obj.setEstado(true);
        return repositorio.save(obj);
    }
 
    @Override
    public EmpleadoEntity update(EmpleadoEntity obj, Long id) {
        EmpleadoEntity objemp = repositorio.findById(id).get();
        BeanUtils.copyProperties(obj, objemp);
        return repositorio.save(objemp);
    }
 
    @Override
    public EmpleadoEntity delete(Long id) {
        EmpleadoEntity objemp = repositorio.findById(id).get();
        objemp.setEstado(false);
        return repositorio.save(objemp);
    }
 
    @Override
    public EmpleadoEntity enable(Long id) {
        EmpleadoEntity objemp = repositorio.findById(id).get();
        objemp.setEstado(true);
        return repositorio.save(objemp);
    }
}
