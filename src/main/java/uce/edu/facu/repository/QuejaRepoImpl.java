package uce.edu.facu.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import uce.edu.facu.model.Queja;


@Repository
@Transactional
public class QuejaRepoImpl implements IQuejaRepo{

    @PersistenceContext
	private EntityManager em;

    @Override
    public void insertarQueja(Queja q) {
        this.em.persist(q);    
    }

    @Override
    public void actualizarQueja(Queja q) {
        this.em.merge(q);
    }

    @Override
    public void borrar(Integer id) {
        this.em.remove(this.buscarId(id));
    }

    @Override
    public Queja buscarId(Integer id) {
        return this.em.find(Queja.class,id);
    }

    @Override
    public List<Queja> buscarFecha(LocalDateTime fecha) {
        TypedQuery<Queja> myQuery = this.em
        .createQuery("SELECT a FROM Queja a WHERE a.fecha > : fecha ", Queja.class)
        .setParameter("fecha", fecha);

        return myQuery.getResultList();
    }

    @Override
    public List<Queja> buscarTodos() {
        TypedQuery<Queja> myQuery = this.em
				.createQuery("SELECT a FROM Queja a ", Queja.class);

		return myQuery.getResultList();    
    }
    
}