package uce.edu.facu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.facu.model.DiscucionForo;
import uce.edu.facu.model.Foro;
import uce.edu.facu.repository.IForoDiscucionRepo;
import uce.edu.facu.service.to.ForoDiscucionTO;

@Service
public class ForoDiscucionServiceImpl implements IForoDiscucionService {

	@Autowired
	private IForoDiscucionRepo foroDiscuRepo;

	@Autowired
	private IForoService foroService;

	@Override
	public DiscucionForo guardarDiscucion(ForoDiscucionTO discuForo) {
		Foro foro = this.foroService.buscarPorID(discuForo.getIdForo());

		DiscucionForo dF = new DiscucionForo();
		dF.setEstudiante(discuForo.getCedulaEstu());
		dF.setFecha(discuForo.getDiscuForo().getFecha());
		dF.setForo(foro);
		dF.setMensaje(discuForo.getDiscuForo().getMensaje());

		discuForo.setDiscuForo(dF);

		return this.foroDiscuRepo.guardarDiscucion(dF);
	}

	@Override
	public DiscucionForo actualizarDiscucion(DiscucionForo discucion) {
		
		return this.foroDiscuRepo.actualizarDiscucion(discucion);
	}

	@Override
	public DiscucionForo buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.foroDiscuRepo.buscarPorId(id);
	}

	@Override
	public List<DiscucionForo> listarComentariosPorIdForo(Integer idForo) {
		List<DiscucionForo> lista = this.foroDiscuRepo.listarComentariosPorIdForo(idForo);
		return lista.stream().sorted((x,y)->y.getFecha().compareTo(x.getFecha())).collect(Collectors.toList());
	}

}
