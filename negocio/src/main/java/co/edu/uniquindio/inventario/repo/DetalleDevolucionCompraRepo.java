package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.DetalleDevolucionCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleDevolucionCompraRepo extends JpaRepository<DetalleDevolucionCompra, Integer> {
}
