package uce.edu.facu.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import uce.edu.facu.model.Foro;
import uce.edu.facu.model.Suscriptor;
import uce.edu.facu.repository.IForoRepo;
import uce.edu.facu.service.to.ForoTO;

@Service
public class ForoServiceImpl implements IForoService{

	@Autowired
	private IForoRepo foroRepo;
	
	@Autowired
	private ISuscriptorService suscriptorService;

	@Override
	@Transactional
	public Foro crearForo(ForoTO foro) {
		Suscriptor s = this.suscriptorService.buscarPorCedula(foro.getCedulaEstudiante());

		 this.suscriptorService.guardarSuscriptor(s);
		
	    Foro f = new Foro();
	    f.setAsunto(foro.getAsunto());
	    f.setMensaje(foro.getMensaje());
	    f.setTag(foro.getForo().getTag());
	    f.setFechaCreacion(foro.getForo().getFechaCreacion());
    
	    Set<Suscriptor> suscriptores = new HashSet<>();
	    suscriptores.add(s);
	    f.setSuscriptores(suscriptores);
	    
	    return this.foroRepo.crearForo(f);
	}

	@Override
	public List<Foro> buscarPorAsunto(String sunto) {
		// TODO Auto-generated method stub
		return this.foroRepo.buscarPorAsunto(sunto);
	}

	@Override
	public Foro buscarPorID(Integer id) {
		// TODO Auto-generated method stub
		return this.foroRepo.buscarPorID(id);
	}

	@Override
	public Foro actualizarForo(ForoTO foro) {
		// TODO Auto-generated method stub
		Foro f = this.foroRepo.buscarPorID(foro.getForo().getId());
		   f.setAsunto(foro.getAsunto());
		   f.setMensaje(foro.getMensaje());
		return this.foroRepo.actualizarForo(f);
	}

	@Override
	public List<Foro> BuscarPorTag(String tag) {
		// TODO Auto-generated method stub
		return this.foroRepo.BuscarPorTag(tag);
	}

	@Override
	public List<Foro> listarForos() {
		// TODO Auto-generated method stub
		List<Foro> foros = this.foroRepo.listarForos();
		return foros.stream().sorted((x,y)->y.getFechaCreacion().compareTo(x.getFechaCreacion())).collect(Collectors.toList());
	}

	@Override
	public Long obtenerNumeroComentarios(Integer id) {
		// TODO Auto-generated method stub
		return this.foroRepo.obtenerNumeroComentarios(id);
	}

	@Override
	public Integer eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.foroRepo.eliminarForoPorID(id);
	}

	@Override
	public Boolean verificarSuscriptorParaEliminar(Integer idForo, String cedula) {
		// TODO Auto-generated method stub
		return this.foroRepo.verificarSuscriptorParaEliminar(idForo, cedula);
	}
	
}
