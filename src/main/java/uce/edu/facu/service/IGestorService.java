package uce.edu.facu.service;

import java.util.List;

import uce.edu.facu.service.to.NoticiaTO;

public interface IGestorService {
    public void nuevaNoticia(NoticiaTO noticia);
    public List<NoticiaTO> obtenerNoticias();
}
