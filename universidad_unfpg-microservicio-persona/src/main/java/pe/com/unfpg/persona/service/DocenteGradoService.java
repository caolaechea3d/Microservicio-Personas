package pe.com.unfpg.persona.service;

import java.util.List;

import pe.com.unfpg.persona.entity.DocenteGradoEntity;
import pe.com.unfpg.persona.entity.DocenteGradoId;


public interface DocenteGradoService {
    List<DocenteGradoEntity> findAll();
    List<DocenteGradoEntity> findByDocente(Long coddoc);
    List<DocenteGradoEntity> findAllCustom();
    DocenteGradoEntity findById(DocenteGradoId id);
    DocenteGradoEntity add(DocenteGradoEntity obj);
    DocenteGradoEntity update(DocenteGradoEntity obj, DocenteGradoId id);
    
}