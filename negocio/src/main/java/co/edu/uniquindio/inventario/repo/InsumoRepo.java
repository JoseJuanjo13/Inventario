package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsumoRepo extends JpaRepository<Insumo, Integer> {
}
