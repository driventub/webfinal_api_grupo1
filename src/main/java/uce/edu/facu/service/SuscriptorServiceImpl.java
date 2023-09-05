package uce.edu.facu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.facu.model.Suscriptor;
import uce.edu.facu.repository.ISuscriptorRepository;

@Service
public class SuscriptorServiceImpl implements ISuscriptorService {

    @Autowired
    private ISuscriptorRepository suscriptorRepo;

    @Override
    public Boolean guardarSuscriptor(Suscriptor suscriptor) {
        Suscriptor sus = this.suscriptorRepo.buscarPorCedula(suscriptor.getCedula());
        if (sus == null) {
            this.suscriptorRepo.guardarSuscriptor(suscriptor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void actualizarSuscriptor(Suscriptor suscriptor) {
        this.suscriptorRepo.actualizarSuscriptor(suscriptor);
    }

    @Override
    public Suscriptor buscarPorId(Integer id) {
        return this.suscriptorRepo.buscarPorId(id);
    }

    @Override
    public Suscriptor buscarPorCedula(String cedula) {
        return this.suscriptorRepo.buscarPorCedula(cedula);
    }

    @Override
    public Suscriptor consultaSuscripcionEstado(String estado) {
        return this.suscriptorRepo.consultaSuscripcionEstado(estado);
    }

    @Override
    public List<Suscriptor> consultaSuscriptores() {
        return this.suscriptorRepo.consultaSuscriptores();
    }

    @Override
    public Boolean verificarExistenciaSuscriptor(String cedula) {
        // TODO Auto-generated method stub
        return this.suscriptorRepo.verificarExistenciaSuscriptor(cedula);
    }

}
