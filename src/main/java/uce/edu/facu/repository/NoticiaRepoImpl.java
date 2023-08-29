package uce.edu.facu.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.facu.model.Noticia;


@Repository
@Transactional
public class NoticiaRepoImpl implements INoticiaRepo{
    

    @PersistenceContext
	private EntityManager em;

    @Override
    public void insertarNoticia(Noticia noti) {
        this.em.persist(noti);
        
    }

    @Override
    public List<Noticia> buscarTodos() {
        TypedQuery<Noticia> myQuery = this.em
				.createQuery("SELECT n FROM Noticia n  ", Noticia.class);

		return myQuery.getResultList();
        
    }

    
}
