package pe.com.unfpg.persona.restcontroller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.unfpg.persona.entity.DocenteEntity;
import pe.com.unfpg.persona.service.DocenteService;



@RestController
@RequestMapping("/api/docente")
public class DocenteRestController {
	@Autowired
	private DocenteService servicio;
	
	@GetMapping
	public List<DocenteEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<DocenteEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	
	@GetMapping("/{id}")
	public DocenteEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	
	@PostMapping
	public DocenteEntity add(@RequestBody DocenteEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public DocenteEntity update(@RequestBody DocenteEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public DocenteEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PatchMapping("/{id}")
	public DocenteEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}

