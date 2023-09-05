package uce.edu.facu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.facu.model.DiscucionForo;

@Repository
@Transactional
public class ForoDiscucionRepoImpl implements IForoDiscucionRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public DiscucionForo guardarDiscucion(DiscucionForo discuForo) {
		// TODO Auto-generated method stub
		this.em.persist(discuForo);
		return discuForo;
	}

	@Override
	public DiscucionForo actualizarDiscucion(DiscucionForo discucion) {
		
		return this.em.merge(discucion);
	}

	@Override
	public DiscucionForo buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		
		return this.em.find(DiscucionForo.class, id);
	}

	@Override
	public List<DiscucionForo> listarComentariosPorIdForo(Integer idForo) {
		// TODO Auto-generated method stub
		TypedQuery<DiscucionForo> myQ = this.em.createQuery("SELECT fd FROM DiscucionForo fd JOIN FETCH fd.foro f WHERE f.id = :foroId", DiscucionForo.class);
		return myQ.setParameter("foroId", idForo).getResultList();
	}

}
