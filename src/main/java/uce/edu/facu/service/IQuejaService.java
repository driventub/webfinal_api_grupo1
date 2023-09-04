package uce.edu.facu.service;

import java.time.LocalDateTime;
import java.util.List;

import uce.edu.facu.model.Queja;
import uce.edu.facu.service.to.QuejaTO;

public interface IQuejaService {
    
    public void insertarQuejaService(Queja q);
    public void actualizarQuejaService(Queja q);
    public void borrarService(Integer id);

    public QuejaTO buscarIdService(Integer id);
    public List<QuejaTO> buscarFechaService(LocalDateTime fecha);
    public List<QuejaTO> buscarTodosService();

}
