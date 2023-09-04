package uce.edu.facu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
            for (MultipartFile imageFile : noticiaDTO.getImagen()) {
                // Save the image file and get the URL

                String imageUrl = imageService.saveImage(imageFile);

                imageUrls.add(imageUrl);

            }
            NoticiaTO noti = new NoticiaTO(noticiaDTO.getTitulo(), noticiaDTO.getDescripcion(),
                    noticiaDTO.getUrlVideo(), imageUrls);

            this.gestorService.nuevaNoticia(noti);
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    @GetMapping
    public List<NoticiaTO> obtenerNoticias() {
        return this.gestorService.obtenerNoticias();
    }

}
