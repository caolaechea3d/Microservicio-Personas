package pe.com.unfpg.persona.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.persona.client.CatalogoFeignClient;
import pe.com.unfpg.persona.entity.AlumnoEntity;
import pe.com.unfpg.persona.repository.AlumnoRepository;
import pe.com.unfpg.persona.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	//@Autowired
	private AlumnoRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;
	
	public AlumnoServiceImpl(AlumnoRepository repositorio,
			CatalogoFeignClient catalogoFeignClient) {
		this.repositorio=repositorio;
		this.catalogoFeignClient=catalogoFeignClient;
	}
	
	@Override
	public List<AlumnoEntity> findAll() {
		List<AlumnoEntity> alumnos=repositorio.findAll();
		for(AlumnoEntity alumno:alumnos) {
			alumno.setDistrito(catalogoFeignClient.getDistrito(alumno.getCoddis()));
			alumno.setEstadocivil(catalogoFeignClient.getEstadoCivil(alumno.getCodestc()));
			alumno.setSexo(catalogoFeignClient.getSexo(alumno.getCodsex()));
			alumno.setTipodocumento(catalogoFeignClient.getTipoDocumento(alumno.getCodtipd()));
		}
		return alumnos;
	}
	@Override
	public List<AlumnoEntity> findAllCustom() {
		List<AlumnoEntity> alumnos=repositorio.findAllCustom();
		for(AlumnoEntity alumno:alumnos) {
			alumno.setDistrito(catalogoFeignClient.getDistrito(alumno.getCoddis()));
			alumno.setEstadocivil(catalogoFeignClient.getEstadoCivil(alumno.getCodestc()));
			alumno.setSexo(catalogoFeignClient.getSexo(alumno.getCodsex()));
			alumno.setTipodocumento(catalogoFeignClient.getTipoDocumento(alumno.getCodtipd()));
		}
		return alumnos;
	}
	@Override
	public AlumnoEntity findById(Long id) {
		AlumnoEntity alumno=repositorio.findById(id).get();
			alumno.setDistrito(catalogoFeignClient.getDistrito(alumno.getCoddis()));
			alumno.setEstadocivil(catalogoFeignClient.getEstadoCivil(alumno.getCodestc()));
			alumno.setSexo(catalogoFeignClient.getSexo(alumno.getCodsex()));
			alumno.setTipodocumento(catalogoFeignClient.getTipoDocumento(alumno.getCodtipd()));
		return alumno;
	}
	@Override
	public AlumnoEntity add(AlumnoEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public AlumnoEntity update(AlumnoEntity obj, Long id) {
		AlumnoEntity objalu=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objalu);
		return repositorio.save(objalu);
	}
	@Override
	public AlumnoEntity delete(Long id) {
		AlumnoEntity objalu=repositorio.findById(id).get();
		objalu.setEstado(false);
		return repositorio.save(objalu);
	}
	@Override
	public AlumnoEntity enable(Long id) {
		AlumnoEntity objalu=repositorio.findById(id).get();
		objalu.setEstado(true);
		return repositorio.save(objalu);
	}
}


