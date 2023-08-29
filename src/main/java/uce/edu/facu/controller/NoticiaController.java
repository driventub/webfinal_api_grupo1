package uce.edu.facu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<NoticiaTO> obtenerNoticias(){
        return this.gestorService.obtenerNoticias();
    }


}
