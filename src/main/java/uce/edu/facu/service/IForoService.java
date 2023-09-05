package uce.edu.facu.service;

import java.util.List;

import uce.edu.facu.model.Foro;
import uce.edu.facu.service.to.ForoTO;

public interface IForoService {

	Foro crearForo(ForoTO foro);

	List<Foro> buscarPorAsunto(String sunto);
	
	Foro buscarPorID(Integer id);
	
	Foro actualizarForo(ForoTO foro);
	
	List<Foro> BuscarPorTag(String tag);
	
	List<Foro> listarForos();
	
	public Long obtenerNumeroComentarios(Integer id);
	
	Integer eliminarPorId(Integer id);
	
	public Boolean verificarSuscriptorParaEliminar(Integer idForo, String cedula) ;
}
