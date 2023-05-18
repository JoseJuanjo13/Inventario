package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.DetalleDevolucionCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface DetalleDevolucionCompraRepo extends JpaRepository<DetalleDevolucionCompra, Integer>, Serializable {

    @Query("select d from DetalleDevolucionCompra d where d.devolucionCompra.idDevolucionCompra = :idDevolucionCompra")
    List<DetalleDevolucionCompra> detallesDevolucion(Integer idDevolucionCompra);

}
