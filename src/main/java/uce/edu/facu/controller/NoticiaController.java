package uce.edu.facu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import uce.edu.facu.service.IGestorService;
import uce.edu.facu.service.ImageService;
import uce.edu.facu.service.to.NoticiaTO;
import uce.edu.facu.service.to.NoticiaTOFachada;

@RestController
@RequestMapping(path = "/noticias")
@CrossOrigin
public class NoticiaController {

    @Autowired
    IGestorService gestorService;

    @Autowired
    private ImageService imageService;

    @PostMapping
    public void crearNoticia(@ModelAttribute NoticiaTOFachada noticiaDTO) {

        try {

            // Handle image files
            List<String> imageUrls = new ArrayList<>();
            NoticiaTO noti = new NoticiaTO();

            if (noticiaDTO.getImagen() != null) {

                for (MultipartFile imageFile : noticiaDTO.getImagen()) {
                    // Save the image file and get the URL

                    String imageUrl = imageService.saveImage(imageFile);

                    imageUrls.add(imageUrl);

                }

                noti.setUrlImagen(imageUrls);

            }
            // else {
            // noti.setUrlImagen();
            // noti.setUrlVideo();
            // }
            noti.setTitulo(noticiaDTO.getTitulo());
            noti.setDescripcion(noticiaDTO.getDescripcion());
            noti.setUrlVideo(noticiaDTO.getUrlVideo());
            this.gestorService.nuevaNoticia(noti);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NoticiaTO>> obtenerNoticias() {
        return ResponseEntity.ok(this.gestorService.obtenerNoticias());
    }

}
