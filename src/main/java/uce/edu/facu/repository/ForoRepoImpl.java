package uce.edu.facu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import uce.edu.facu.model.Foro;

@Slf4j
@Repository
@Transactional
public class ForoRepoImpl implements IForoRepo {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Foro crearForo(Foro foro) {
		this.em.persist(foro);
		return foro;
	}

	@Override
	public List<Foro> buscarPorAsunto(String asunto) {
		TypedQuery<Foro> myQ = this.em.createQuery("select f from Foro f where f.asunto LIKE : asunto", Foro.class);
		return myQ.setParameter("asunto", "%"+asunto+"%").getResultList() ;
	}

	@Override
	public List<Foro> BuscarPorTag(String tag) {
		TypedQuery<Foro> myQ = this.em.createQuery("select f from Foro f where f.tag LIKE : tag", Foro.class);
		return myQ.setParameter("tag", "%"+tag+"%").getResultList() ;
	}

	@Override
	public Foro actualizarForo(Foro foro) {		
		return this.em.merge(foro);
	}

	@Override
	public Foro buscarPorID(Integer id) {
		return this.em.find(Foro.class, id);
	}

	@Override
	public List<Foro> listarForos() {
		// TODO Auto-generated method stub
		TypedQuery<Foro> myQ = this.em.createQuery("Select f from Foro f",Foro.class);
		return myQ.getResultList();
	}

	@Override
	public Foro actualizarPorCedulaSuscriptor(String cedula) {
		
		return null;
	}

	@Override
	public Long obtenerNumeroComentarios(Integer id) {
		TypedQuery<Long> myQ = this.em.createQuery("SELECT COUNT(d) FROM DiscucionForo d WHERE d.foro.id = :foroId",Long.class);
		Long count = myQ.setParameter("foroId", id).getSingleResult();
		return count;
	}

	@Override
	public Integer eliminarForoPorID(Integer id) {

		try {
		Foro f = this.buscarPorID(id);
		this.em.remove(f);
          return 1;
		}catch(NoResultException e) {
			log.error(e.getMessage());
			return 0;
		}
		
	}

	@Override
	public Boolean verificarSuscriptorParaEliminar(Integer idForo, String cedula) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			TypedQuery<Long> myQ= this.em.createQuery("SELECT COUNT(s) FROM Foro f JOIN f.suscriptores s WHERE f.id = :idForo AND s.cedula = :cedulaSuscriptor",Long.class);
			Long count = myQ.setParameter("idForo", idForo).setParameter("cedulaSuscriptor", cedula).getSingleResult();
			
			System.out.println("Count: "+count);
			if(count>0) {
		        flag = true;
			}
		}catch(NoResultException e) {
			log.error(e.getMessage());
		}
		return flag;
	}

}
