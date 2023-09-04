package uce.edu.facu.repository;

import java.time.LocalDateTime;
import java.util.List;

import uce.edu.facu.model.Queja;

public interface IQuejaRepo {

    public void insertarQueja(Queja q);
    public void actualizarQueja(Queja q);
    public void borrar(Integer id);

    public Queja buscarId(Integer id);
    public List<Queja> buscarFecha(LocalDateTime fecha);
    public List<Queja> buscarTodos();
    
}
