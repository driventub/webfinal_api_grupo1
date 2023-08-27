package uce.edu.facu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.facu.model.Noticia;
import uce.edu.facu.repository.INoticiaRepo;
import uce.edu.facu.service.to.NoticiaTO;

@Service
public class GestorServiceImpl implements IGestorService {

    @Autowired
    private INoticiaRepo notiRepo;


    @Override
    public void nuevaNoticia(NoticiaTO noticia) {
        Noticia n = new Noticia();
        n.setTitulo(noticia.getTitulo());
        n.setDescripcion(noticia.getDescripcion());
        n.setFecha(LocalDateTime.now());
        n.setListaImagenes(n.getListaImagenes());
        n.setListaVideo(n.getListaVideo());

        this.notiRepo.insertarNoticia(n);
        
    }

    @Override
    public List<Noticia> obtenerNoticias() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obtenerNoticias'");
    }
    
}
