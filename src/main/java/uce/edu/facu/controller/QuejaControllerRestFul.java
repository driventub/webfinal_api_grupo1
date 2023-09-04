package uce.edu.facu.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uce.edu.facu.model.Queja;
import uce.edu.facu.service.IQuejaService;
import uce.edu.facu.service.to.QuejaTO;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping(path = "/quejas")
public class QuejaControllerRestFul {
    
    @Autowired
    private IQuejaService quejaService;

    @PostMapping(consumes = "application/json")
    public void ingresarQueja (@RequestBody Queja q){
        this.quejaService.insertarQuejaService(q);
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public QuejaTO consultarPorId(@PathVariable Integer id) {
        return this.quejaService.buscarIdService(id);
    }

    @DeleteMapping(path = "/{id}")
    public void borrarCedula(@PathVariable Integer id) {
        this.quejaService.borrarService(id);
    }

    @PutMapping(path = "/{id}",consumes = "application/json")
    public void actualizarEstudiante(@RequestBody Queja queja, @PathVariable Integer id) {
        queja.setId(id);
        this.quejaService.actualizarQuejaService(queja);
    }

    @GetMapping ( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuejaTO>> buscarTodos() {
        
        List<QuejaTO> lista = this.quejaService.buscarTodosService();
        
        return new ResponseEntity<>(lista, null, 200);

    }

    @GetMapping (path = "/{fecha}",consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QuejaTO>> buscarTodos(@PathVariable LocalDateTime fecha) {
        
        List<QuejaTO> lista = this.quejaService.buscarFechaService(fecha);
        
        return new ResponseEntity<>(lista, null, 200);

    }

}
