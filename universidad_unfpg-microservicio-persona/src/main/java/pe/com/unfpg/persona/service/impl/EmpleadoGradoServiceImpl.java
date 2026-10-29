
package pe.com.unfpg.persona.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.persona.client.CatalogoFeignClient;
import pe.com.unfpg.persona.entity.EmpleadoGradoEntity;
import pe.com.unfpg.persona.entity.EmpleadoGradoId;
import pe.com.unfpg.persona.repository.EmpleadoGradoRepository;
import pe.com.unfpg.persona.service.EmpleadoGradoService;


@Service
public class EmpleadoGradoServiceImpl implements EmpleadoGradoService {
 
    private final EmpleadoGradoRepository repositorio;
    private final CatalogoFeignClient catalogoFeignClient;
 
    public EmpleadoGradoServiceImpl(EmpleadoGradoRepository repositorio, CatalogoFeignClient catalogoFeignClient) {
        this.repositorio = repositorio;
        this.catalogoFeignClient = catalogoFeignClient;   // NEW
    }
 
    @Override
    public List<EmpleadoGradoEntity> findAll() {
        List<EmpleadoGradoEntity> empleadoGrados = repositorio.findAll();
        for (EmpleadoGradoEntity empleadoGrado : empleadoGrados) {
            empleadoGrado.setGradoinstruccion(catalogoFeignClient.getGradoInstruccion(empleadoGrado.getCodgrai()));
        }
        return empleadoGrados;
    }
 
    @Override
    public List<EmpleadoGradoEntity> findAllCustom() {
        List<EmpleadoGradoEntity> empleadoGrados = repositorio.findAllCustom();
        for (EmpleadoGradoEntity empleadoGrado : empleadoGrados) {
            empleadoGrado.setGradoinstruccion(catalogoFeignClient.getGradoInstruccion(empleadoGrado.getCodgrai()));
        }
        return empleadoGrados;
    }
 
    @Override
    public List<EmpleadoGradoEntity> findByEmpleado(Long codemp) {
        List<EmpleadoGradoEntity> empleadoGrados = repositorio.findByEmpleado(codemp);
        for (EmpleadoGradoEntity empleadoGrado : empleadoGrados) {
            empleadoGrado.setGradoinstruccion(catalogoFeignClient.getGradoInstruccion(empleadoGrado.getCodgrai()));
        }
        return empleadoGrados;
    }
 
    @Override
    public EmpleadoGradoEntity findById(EmpleadoGradoId id) {
        EmpleadoGradoEntity empleadoGrado = repositorio.findById(id).orElse(null);
        if (empleadoGrado != null) {
            empleadoGrado.setGradoinstruccion(catalogoFeignClient.getGradoInstruccion(empleadoGrado.getCodgrai()));
        }
        return empleadoGrado;
    }
 
    @Override
    public EmpleadoGradoEntity add(EmpleadoGradoEntity obj) {
        return repositorio.save(obj);
    }
 
    @Override
    public EmpleadoGradoEntity update(EmpleadoGradoEntity obj, EmpleadoGradoId id) {
        EmpleadoGradoEntity objeg = repositorio.findById(id).orElse(null);
        if (objeg != null) {
            BeanUtils.copyProperties(obj, objeg, "id", "empleado", "codgrai", "gradoinstruccion");
            return repositorio.save(objeg);
        }
        return null;
    }
}