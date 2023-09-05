package uce.edu.facu.service;

import java.util.List;

import uce.edu.facu.model.Suscriptor;

public interface ISuscriptorService {

    public Boolean guardarSuscriptor(Suscriptor suscriptor);

    public void actualizarSuscriptor(Suscriptor suscriptor);

    public Suscriptor buscarPorId(Integer id);

    public Suscriptor buscarPorCedula(String cedula);

    public Suscriptor consultaSuscripcionEstado(String estado);

    public List<Suscriptor> consultaSuscriptores();
    
    public Boolean verificarExistenciaSuscriptor(String cedula);

}
