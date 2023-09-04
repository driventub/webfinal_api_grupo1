package uce.edu.facu.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.facu.model.Queja;
import uce.edu.facu.repository.IQuejaRepo;
import uce.edu.facu.service.to.QuejaTO;

@Service
public class QuejaServiceImpl implements IQuejaService{

    @Autowired
    private IQuejaRepo quejaRepo;

    @Override
    public void insertarQuejaService(Queja q) {
        q.setFecha(LocalDateTime.now());
        this.quejaRepo.insertarQueja(q);
    }

    @Override
    public void actualizarQuejaService(Queja q) {
        q.setFecha(LocalDateTime.now());

        if(q.getAsunto().contains("(")){
            this.quejaRepo.actualizarQueja(q);
        }else{
            q.setAsunto(q.getAsunto()+" (Editado)");
            this.quejaRepo.actualizarQueja(q);
        }    
    }

    @Override
    public void borrarService(Integer id) {
        this.quejaRepo.borrar(id);    
    }

    @Override
    public QuejaTO buscarIdService(Integer id) {
        Queja q= this.quejaRepo.buscarId(id);
        return this.convertir(q);
    }

    @Override
    public List<QuejaTO> buscarFechaService(LocalDateTime fecha) {
        List<Queja> lista=this.quejaRepo.buscarFecha(fecha);
        List<QuejaTO> listaTO=lista.stream()
        .map(quejas -> this.convertir(quejas))
        .collect(Collectors.toList());

        return listaTO;   
    }

    @Override
    public List<QuejaTO> buscarTodosService() {
        List<Queja> lista=this.quejaRepo.buscarTodos();
        List<QuejaTO> listaTO=lista.stream()
        .map(quejas -> this.convertir(quejas))
        .collect(Collectors.toList());

        return listaTO;  
    }
    
    private QuejaTO convertir(Queja queja){
        QuejaTO queTO=new QuejaTO();
        queTO.setId(queja.getId());
        queTO.setNombre(queja.getNombre());
        queTO.setAsunto(queja.getAsunto());
        queTO.setFecha(queja.getFecha());
        queTO.setCuerpo(queja.getCuerpo());

        return queTO;
    }

}