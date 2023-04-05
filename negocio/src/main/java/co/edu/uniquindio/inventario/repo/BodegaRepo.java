package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.Bodega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodegaRepo extends JpaRepository<Bodega, Integer> {
}
