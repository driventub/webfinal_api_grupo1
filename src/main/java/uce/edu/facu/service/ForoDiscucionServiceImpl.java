package uce.edu.facu.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uce.edu.facu.model.DiscucionForo;
import uce.edu.facu.model.Foro;
import uce.edu.facu.model.Suscriptor;
import uce.edu.facu.repository.IForoDiscucionRepo;
import uce.edu.facu.service.to.ForoDiscucionTO;

@Service
public class ForoDiscucionServiceImpl implements IForoDiscucionService {

	@Autowired
	private IForoDiscucionRepo foroDiscuRepo;

	@Autowired
	private IForoService foroService;
	
	@Autowired
	private ISuscriptorService susService;

	@Override
	public DiscucionForo guardarDiscucion(ForoDiscucionTO discuForo) {
		Foro foro = this.foroService.buscarPorID(discuForo.getIdForo());
		Suscriptor sus = this.susService.buscarPorCedula(discuForo.getCedulaEstu());

		DiscucionForo dF = new DiscucionForo();
		dF.setFecha(discuForo.getDiscuForo().getFecha());
		dF.setForo(foro);
		dF.setMensaje(discuForo.getDiscuForo().getMensaje());
        
		sus.setDiscuForo(dF);
		
		dF.setSuscriptor(sus);
		
		//this.susService.actualizarSuscriptor(sus);
	
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
