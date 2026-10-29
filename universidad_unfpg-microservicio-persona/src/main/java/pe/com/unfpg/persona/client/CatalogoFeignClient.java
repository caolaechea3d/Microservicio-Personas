package pe.com.unfpg.persona.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="unfpg-microservicio-catalogo",url="http://localhost:9091/unfpg/api/")
public interface CatalogoFeignClient {
	@GetMapping("/distrito/{id}")
	Object getDistrito(@PathVariable("id") Long id);
	
	@GetMapping("/estadocivil/{id}")
	Object getEstadoCivil(@PathVariable("id") Long id);
	
	@GetMapping("/sexo/{id}")
	Object getSexo(@PathVariable("id") Long id);
	
	@GetMapping("/tipodocumento/{id}")
	Object getTipoDocumento(@PathVariable("id") Long id);
	
	@GetMapping("/gradoinstruccion/{id}")
	Object getGradoInstruccion(@PathVariable("id") Long id);
	
	@GetMapping("/areaempleo/{id}")
	Object getAreaEmpleo(@PathVariable("id") Long id);
	
	@GetMapping("/cargo/{id}")
	Object getCargo(@PathVariable("id") Long id);
	
}
