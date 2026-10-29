package pe.com.unfpg.persona.service;
import java.util.List;

import pe.com.unfpg.persona.entity.DocenteEntity;

public interface DocenteService {

	List<DocenteEntity> findAll();
	List<DocenteEntity> findAllCustom();
	DocenteEntity findById(Long id);
	DocenteEntity add(DocenteEntity obj);
	DocenteEntity update(DocenteEntity obj, Long id);
	DocenteEntity delete(Long id);
	DocenteEntity enable(Long id);
}


