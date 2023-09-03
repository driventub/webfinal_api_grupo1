package uce.edu.facu.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uce.edu.facu.model.Imagen;
import uce.edu.facu.model.Noticia;
import uce.edu.facu.model.Video;
import uce.edu.facu.repository.INoticiaRepo;
import uce.edu.facu.service.to.NoticiaTO;

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

    @Override
    public List<NoticiaTO> obtenerNoticias() {
        // List<Noticia> noti = this.notiRepo.buscarTodos();
        // List<NoticiaTO> to = new ArrayList<>();

        // for (Noticia noticia : noti) {
        //     List<String> lImg = new ArrayList<>();
        //     List<String> lVid = new ArrayList<>();

        //     for (Imagen img : noticia.getListaImagenes()) {
        //         lImg.add(img.getUrl());
        //     }

        //     for (Video video : noticia.getListaVideo()) {
        //         lVid.add(video.getUrl());
        //     }

        //     NoticiaTO noticiaTO = new NoticiaTO(noticia.getTitulo(), noticia.getDescripcion(), lImg, lVid);
        //     to.add(noticiaTO);
        // }
        // return to;
        return null;

    }

}
