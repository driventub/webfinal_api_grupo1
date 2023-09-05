package uce.edu.facu.repository;

import java.util.List;

import uce.edu.facu.model.DiscucionForo;

public interface IForoDiscucionRepo {

	
	 DiscucionForo guardarDiscucion(DiscucionForo discuForo);
	
	 
	 DiscucionForo actualizarDiscucion(DiscucionForo discucion);
	 
	 DiscucionForo buscarPorId(Integer id);
	 
	 List<DiscucionForo> listarComentariosPorIdForo(Integer idForo);
}
