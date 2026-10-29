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

import pe.com.unfpg.persona.entity.DocenteGradoEntity;
import pe.com.unfpg.persona.entity.DocenteGradoId;
import pe.com.unfpg.persona.service.DocenteGradoService;


@RestController
@RequestMapping("/api/docentegrado")
public class DocenteGradoRestController {

    @Autowired
    private DocenteGradoService servicio;

    @GetMapping
    public List<DocenteGradoEntity> findAll() {
        return servicio.findAll();
    }

    @GetMapping("/custom")
    public List<DocenteGradoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }

    @GetMapping("/docente/{coddoc}")
    public List<DocenteGradoEntity> findByDocente(@PathVariable Long coddoc) {
        return servicio.findByDocente(coddoc);
    }

    @GetMapping("/{coddoc}/{codgrai}")
    public DocenteGradoEntity findById(@PathVariable Long coddoc,
                                       @PathVariable Long codgrai) {
        return servicio.findById(new DocenteGradoId(coddoc, codgrai));
    }

    @PostMapping
    public DocenteGradoEntity add(@RequestBody DocenteGradoEntity obj) {
        return servicio.add(obj);
    }

    @PutMapping("/{coddoc}/{codgrai}")
    public DocenteGradoEntity update(@RequestBody DocenteGradoEntity obj,
                                     @PathVariable Long coddoc,
                                     @PathVariable Long codgrai) {
        return servicio.update(obj, new DocenteGradoId(coddoc, codgrai));
    }

 
}