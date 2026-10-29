package pe.com.unfpg.persona.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.unfpg.persona.entity.EmpleadoGradoEntity;
import pe.com.unfpg.persona.entity.EmpleadoGradoId;
import pe.com.unfpg.persona.service.EmpleadoGradoService;


@RestController
@RequestMapping("/api/empleadogrado")
public class EmpleadoGradoRestController {

    @Autowired
    private EmpleadoGradoService servicio;

    @GetMapping
    public List<EmpleadoGradoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<EmpleadoGradoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/empleado/{codemp}")
    public List<EmpleadoGradoEntity> findByEmpleado(@PathVariable Long codemp) {
        return servicio.findByEmpleado(codemp);
    }

    @GetMapping("/{codemp}/{codgrai}")
    public EmpleadoGradoEntity findById(@PathVariable Long codemp,
                                        @PathVariable Long codgrai) {
        return servicio.findById(new EmpleadoGradoId(codemp, codgrai));
    }

    @PostMapping
    public EmpleadoGradoEntity add(@RequestBody EmpleadoGradoEntity obj) {
        return servicio.add(obj);
    }

    @PutMapping("/{codemp}/{codgrai}")
    public EmpleadoGradoEntity update(@RequestBody EmpleadoGradoEntity obj,
                                      @PathVariable Long codemp,
                                      @PathVariable Long codgrai) {
        return servicio.update(obj, new EmpleadoGradoId(codemp, codgrai));
    }
}