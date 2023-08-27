package uce.edu.facu.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    
}
