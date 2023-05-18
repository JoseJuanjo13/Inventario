package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.TiposIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface TiposIdentificacionRepo extends JpaRepository<TiposIdentificacion, Integer>, Serializable {
}
