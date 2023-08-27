package uce.edu.facu.repository;

import java.util.List;

import uce.edu.facu.model.Noticia;

public interface INoticiaRepo {
    public void insertarNoticia(Noticia noti);
    public List<Noticia> buscarTodos();
}
