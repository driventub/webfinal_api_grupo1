package uce.edu.facu.service;

import java.util.List;

import uce.edu.facu.model.DiscucionForo;
import uce.edu.facu.service.to.ForoDiscucionTO;

public interface IForoDiscucionService {

	
 DiscucionForo guardarDiscucion(ForoDiscucionTO discuForo);
	
	 
	 DiscucionForo actualizarDiscucion(DiscucionForo discucion);
	 
	 DiscucionForo buscarPorId(Integer id);
	 
	 List<DiscucionForo> listarComentariosPorIdForo(Integer idForo) ;
	
}
