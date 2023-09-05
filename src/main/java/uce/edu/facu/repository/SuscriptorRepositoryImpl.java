package uce.edu.facu.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import uce.edu.facu.model.Suscriptor;

@Slf4j
@Repository
@Transactional
public class SuscriptorRepositoryImpl implements ISuscriptorRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void guardarSuscriptor(Suscriptor suscriptor) {
        this.entityManager.persist(suscriptor);
    }

    @Override
    public void actualizarSuscriptor(Suscriptor suscriptor) {
        this.entityManager.merge(suscriptor);
    }

    @Override
    public Suscriptor buscarPorId(Integer id) {
        return this.entityManager.find(Suscriptor.class, id);
    }

    @Override
    public Suscriptor buscarPorCedula(String cedula) {
        TypedQuery<Suscriptor> myQuery = this.entityManager
                .createQuery("SELECT s FROM Suscriptor s WHERE s.cedula=:datoCedula", Suscriptor.class);
        myQuery.setParameter("datoCedula", cedula);
        try {
            return myQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Suscriptor consultaSuscripcionEstado(String estado) {
        TypedQuery<Suscriptor> myQuery = this.entityManager
                .createQuery("SELECT s FROM Suscriptor s WHERE s.estado=:datoEstado", Suscriptor.class);
        myQuery.setParameter("datoEstado", estado);
        return myQuery.getSingleResult();
    }

    @Override
    public List<Suscriptor> consultaSuscriptores() {
        TypedQuery<Suscriptor> myQuery = this.entityManager
                .createQuery("SELECT s FROM Suscriptor s", Suscriptor.class);
        return myQuery.getResultList();
    }

	@Override
	public Boolean verificarExistenciaSuscriptor(String cedula) {
		boolean flag =false;
		try {
			TypedQuery<Suscriptor> myQ = this.entityManager.createQuery("SELECT s from Suscriptor s where s.cedula=:cedula",Suscriptor.class);
			Suscriptor sus = myQ.setParameter("cedula", cedula).getSingleResult();
			System.out.println("sus: "+sus.getNombre());
			flag = true;
		}catch(NoResultException e) {
			log.error(e.getMessage());
		}
		return flag;
	}

}
