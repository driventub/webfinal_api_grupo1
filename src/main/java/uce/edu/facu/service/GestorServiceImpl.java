package uce.edu.facu.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uce.edu.facu.model.Imagen;
import uce.edu.facu.model.Noticia;
import uce.edu.facu.model.Video;
import uce.edu.facu.repository.INoticiaRepo;
import uce.edu.facu.service.to.NoticiaTO;

import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.context.support.ServletContextResourceLoader;

@Service
public class GestorServiceImpl implements IGestorService {

    @Autowired
    private INoticiaRepo notiRepo;

    @Override
    @Transactional
    public void nuevaNoticia(NoticiaTO noticia) {
        Noticia n = new Noticia();
        List<Imagen> lImagen = new ArrayList<>();
        List<Video> lVideo = new ArrayList<>();

        n.setTitulo(noticia.getTitulo());
        n.setDescripcion(noticia.getDescripcion());
        n.setFecha(LocalDateTime.now());

        for (String img : noticia.getUrlImagen()) {
            Imagen nImagen = new Imagen();
            nImagen.setUrl(img);
            nImagen.setNoticia(n);
            lImagen.add(nImagen);
        }
        for (String vid : noticia.getUrlVideo()) {
            Video nVideo = new Video();
            nVideo.setUrl(vid);
            nVideo.setNoticia(n);
            lVideo.add(nVideo);
        }

        n.setListaImagenes(lImagen);
        n.setListaVideo(lVideo);

        this.notiRepo.insertarNoticia(n);

    }

    @Autowired
    private ServletContext servletContext;
    @Override
    public List<NoticiaTO> obtenerNoticias() throws IOException {
         List<Noticia> noti = this.notiRepo.buscarTodos();
         List<NoticiaTO> to = new ArrayList<>();

         for (Noticia noticia : noti) {
             List<String> lImg = new ArrayList<>();
             List<String> lVid = new ArrayList<>();

             for (Imagen img : noticia.getListaImagenes()) {
                 String imagenFileName = img.getUrl();
                 System.out.println(imagenFileName);
                 String src = getResourceUrl("imgs/" + imagenFileName);
                 System.out.println(src);
                 lImg.add(src);
             }

             for (Video video : noticia.getListaVideo()) {
                 lVid.add(video.getUrl());
             }

             NoticiaTO noticiaTO = new NoticiaTO(noticia.getTitulo(), noticia.getDescripcion(), lVid, lImg);
             to.add(noticiaTO);
         }



         return to;


    }

    private String getResourceUrl(String path) throws IOException {
        ServletContextResource resource = new ServletContextResource(servletContext, path);
        return resource.exists() ? resource.getURL().toString() : null;
    }


}
