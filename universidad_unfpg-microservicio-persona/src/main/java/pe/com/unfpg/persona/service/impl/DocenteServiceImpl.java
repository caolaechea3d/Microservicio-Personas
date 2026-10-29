package pe.com.unfpg.persona.service.impl;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.unfpg.persona.client.CatalogoFeignClient;
import pe.com.unfpg.persona.entity.DocenteEntity;
import pe.com.unfpg.persona.repository.DocenteRepository;
import pe.com.unfpg.persona.service.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService {
	private final DocenteRepository repositorio;
	private final CatalogoFeignClient catalogoFeignClient;
 
	DocenteServiceImpl(DocenteRepository repositorio, CatalogoFeignClient catalogoFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;	
	}
	
	@Override
	public List<DocenteEntity> findAll() {
		List<DocenteEntity> docentes = repositorio.findAll();
		for (DocenteEntity docente : docentes) {
			docente.setDistrito(catalogoFeignClient.getDistrito(docente.getCoddis()));
			docente.setEstadocivil(catalogoFeignClient.getEstadoCivil(docente.getCodestc()));
			docente.setSexo(catalogoFeignClient.getSexo(docente.getCodsex()));
			docente.setTipodocumento(catalogoFeignClient.getTipoDocumento(docente.getCodtipd()));
		}
		return docentes;
	}
	@Override
	public List<DocenteEntity> findAllCustom() {
		List<DocenteEntity> docentes = repositorio.findAllCustom();
		for (DocenteEntity docente : docentes) {
			docente.setDistrito(catalogoFeignClient.getDistrito(docente.getCoddis()));
			docente.setEstadocivil(catalogoFeignClient.getEstadoCivil(docente.getCodestc()));
			docente.setSexo(catalogoFeignClient.getSexo(docente.getCodsex()));
			docente.setTipodocumento(catalogoFeignClient.getTipoDocumento(docente.getCodtipd()));
		}
		return docentes;
	}
	@Override
	public DocenteEntity findById(Long id) {
		DocenteEntity docente = repositorio.findById(id).get();
		docente.setDistrito(catalogoFeignClient.getDistrito(docente.getCoddis()));
		docente.setEstadocivil(catalogoFeignClient.getEstadoCivil(docente.getCodestc()));
		docente.setSexo(catalogoFeignClient.getSexo(docente.getCodsex()));
		docente.setTipodocumento(catalogoFeignClient.getTipoDocumento(docente.getCodtipd()));
		return docente;
	}
	@Override
	public DocenteEntity add(DocenteEntity obj) {
		return repositorio.save(obj);
	}
	@Override
	public DocenteEntity update(DocenteEntity obj, Long id) {
		DocenteEntity objalu=repositorio.findById(id).get();
		BeanUtils.copyProperties(obj, objalu);
		return repositorio.save(objalu);
	}
	@Override
	public DocenteEntity delete(Long id) {
		DocenteEntity objalu=repositorio.findById(id).get();
		objalu.setEstado(false);
		return repositorio.save(objalu);
	}
	@Override
	public DocenteEntity enable(Long id) {
		DocenteEntity objalu=repositorio.findById(id).get();
		objalu.setEstado(true);
		return repositorio.save(objalu);
	}
}
 