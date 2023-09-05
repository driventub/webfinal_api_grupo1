package uce.edu.facu.repository;

import java.util.List;

import uce.edu.facu.model.Foro;

public interface IForoRepo {

	Foro crearForo(Foro foro);

	List<Foro> buscarPorAsunto(String sunto);

	Foro actualizarForo(Foro foro);

	List<Foro> BuscarPorTag(String tag);

	Foro buscarPorID(Integer id);

	List<Foro> listarForos();
	
	Foro actualizarPorCedulaSuscriptor(String cedula);
	
	Long obtenerNumeroComentarios(Integer id);
	
	Integer eliminarForoPorID(Integer id);
	
	Boolean verificarSuscriptorParaEliminar(Integer idForo, String cedula);
}
