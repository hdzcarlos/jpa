package chc.udemy.jpa.repository;


import chc.udemy.jpa.models.entity.JugadorEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
/**
 * Marcamos la clase como componente de persistencia , con acceso a datos.
 */

@Repository
public class JugadorDAOImpl implements IJugadorDAO {
    /**
     * El EntityManager se utiliza con JPA!  en versiones antiguas de spring
     */
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<JugadorEntity> findAll() {
        return entityManager.createQuery("from JugadorEntity").getResultList();
    }
    /**
     * Metodo para guardar los datos que vienen de la vista  en base de datos
     */
    @Override
    @Transactional
    public void save(JugadorEntity jugadorEntity) {
        entityManager.persist(jugadorEntity);
    }

}
