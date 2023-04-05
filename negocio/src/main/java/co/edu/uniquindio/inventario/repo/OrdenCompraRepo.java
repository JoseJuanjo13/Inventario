package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenCompraRepo extends JpaRepository<OrdenCompra, Integer> {
}
