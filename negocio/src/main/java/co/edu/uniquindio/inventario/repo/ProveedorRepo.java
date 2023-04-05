package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepo extends JpaRepository<Proveedor, Integer> {
}
