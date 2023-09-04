package uce.edu.facu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import uce.edu.facu.service.IGestorService;
import uce.edu.facu.service.to.NoticiaTO;

@RestController
@RequestMapping(path = "/noticias")
@CrossOrigin
public class NoticiaController {
    
    @Autowired
    IGestorService gestorService;

    @PostMapping
    public void crearNoticia(@RequestBody NoticiaTO noticia){
        this.gestorService.nuevaNoticia(noticia);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NoticiaTO>>  obtenerNoticias(){
        return ResponseEntity.ok(this.gestorService.obtenerNoticias()) ;
    }


}
