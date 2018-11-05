package chc.udemy.jpa.repository;

import chc.udemy.jpa.models.entity.JugadorEntity;
import java.util.List;

public interface IJugadorDAO {
    /**
     * Metodo para buscar todos los Jugadores
     * @return
     */
    List<JugadorEntity> findAll();

    public void save(JugadorEntity jugadorEntity);

}
