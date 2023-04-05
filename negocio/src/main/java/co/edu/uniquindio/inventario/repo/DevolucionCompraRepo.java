package co.edu.uniquindio.inventario.repo;


import co.edu.uniquindio.inventario.entidades.DevolucionCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevolucionCompraRepo extends JpaRepository<DevolucionCompra, Integer> {
}
