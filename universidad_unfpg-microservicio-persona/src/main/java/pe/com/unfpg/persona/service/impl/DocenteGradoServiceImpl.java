package pe.com.unfpg.persona.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.persona.client.CatalogoFeignClient;
import pe.com.unfpg.persona.entity.DocenteGradoEntity;
import pe.com.unfpg.persona.entity.DocenteGradoId;
import pe.com.unfpg.persona.repository.DocenteGradoRepository;
import pe.com.unfpg.persona.service.DocenteGradoService;


@Service
public class DocenteGradoServiceImpl implements DocenteGradoService {
 
    private final DocenteGradoRepository repositorio;
    private final CatalogoFeignClient catalogoFeignClient;
 

    public DocenteGradoServiceImpl(DocenteGradoRepository repositorio, CatalogoFeignClient catalogoFeignClient) {
        this.repositorio = repositorio;
        this.catalogoFeignClient = catalogoFeignClient;   // NEW
    }
 
    @Override
    public List<DocenteGradoEntity> findAll() {
        List<DocenteGradoEntity> docenteGrados = repositorio.findAll();
        for (DocenteGradoEntity docenteGrado : docenteGrados) {
            docenteGrado.setGradoinstruccion(catalogoFeignClient.getGradoInstruccion(docenteGrado.getCodgrai()));
        }
        return docenteGrados;
    }
    
    @Override
    public List<DocenteGradoEntity> findAllCustom() {
        List<DocenteGradoEntity> docenteGrados = repositorio.findAllCustom();
        for (DocenteGradoEntity docenteGrado : docenteGrados) {
            docenteGrado.setGradoinstruccion(catalogoFeignClient.getGradoInstruccion(docenteGrado.getCodgrai()));
        }
        return docenteGrados;
    }
    
    @Override
    public List<DocenteGradoEntity> findByDocente(Long coddoc) {
        List<DocenteGradoEntity> docenteGrados = repositorio.findAllCustom(coddoc);
        for (DocenteGradoEntity docenteGrado : docenteGrados) {
            docenteGrado.setGradoinstruccion(catalogoFeignClient.getGradoInstruccion(docenteGrado.getCodgrai()));
        }
        return docenteGrados;
    }
 
    @Override
    public DocenteGradoEntity findById(DocenteGradoId id) {
        DocenteGradoEntity docenteGrado = repositorio.findById(id).orElse(null);
        if (docenteGrado != null) {
            docenteGrado.setGradoinstruccion(catalogoFeignClient.getGradoInstruccion(docenteGrado.getCodgrai()));
        }
        return docenteGrado;
    }
 
    @Override
    public DocenteGradoEntity add(DocenteGradoEntity obj) {
        return repositorio.save(obj);
    }
 
    @Override
    public DocenteGradoEntity update(DocenteGradoEntity obj, DocenteGradoId id) {
        DocenteGradoEntity objdg = repositorio.findById(id).orElse(null);
        if (objdg != null) {
            BeanUtils.copyProperties(obj, objdg, "id", "docente", "codgrai", "gradoinstruccion");
            return repositorio.save(objdg);
        }
        return null;
    }
}