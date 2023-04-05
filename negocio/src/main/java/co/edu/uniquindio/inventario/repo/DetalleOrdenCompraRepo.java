package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.DetalleOrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenCompraRepo extends JpaRepository<DetalleOrdenCompra, Integer> {
}
