package uce.edu.facu.repository;

import java.util.List;

import uce.edu.facu.model.Suscriptor;

public interface ISuscriptorRepository {

    public void guardarSuscriptor(Suscriptor suscriptor);

    public void actualizarSuscriptor(Suscriptor suscriptor);

    public Suscriptor buscarPorId(Integer id);

    public Suscriptor buscarPorCedula(String cedula);

    public Suscriptor consultaSuscripcionEstado(String estado);

    public List<Suscriptor> consultaSuscriptores();

}
