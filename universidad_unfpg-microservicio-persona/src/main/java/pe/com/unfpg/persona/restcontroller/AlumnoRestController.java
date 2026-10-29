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

import pe.com.unfpg.persona.entity.AlumnoEntity;
import pe.com.unfpg.persona.service.AlumnoService;



@RestController
@RequestMapping("/api/alumno")
public class AlumnoRestController {
	@Autowired
	private AlumnoService servicio;
	
	@GetMapping
	public List<AlumnoEntity> findAll(){
		return servicio.findAll();
	}
	
	@GetMapping("/custom")
	public List<AlumnoEntity> findAllCustom(){
		return servicio.findAllCustom();
	}
	
	
	@GetMapping("/{id}")
	public AlumnoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}
	
	
	@PostMapping
	public AlumnoEntity add(@RequestBody AlumnoEntity obj) {
		return servicio.add(obj);
	}
	
	@PutMapping("/{id}")
	public AlumnoEntity update(@RequestBody AlumnoEntity obj,
			@PathVariable Long id) {
		return servicio.update(obj, id);
	}
	
	@DeleteMapping("/{id}")
	public AlumnoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}
	
	@PatchMapping("/{id}")
	public AlumnoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}

