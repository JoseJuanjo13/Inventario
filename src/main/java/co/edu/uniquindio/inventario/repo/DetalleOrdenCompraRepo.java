package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.DetalleOrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface DetalleOrdenCompraRepo extends JpaRepository<DetalleOrdenCompra, Integer>, Serializable {

    @Query("select d from DetalleOrdenCompra d where d.ordenCompra.idCompra = :idOrdenCompra")
    List<DetalleOrdenCompra> detallesCompra(Integer idOrdenCompra);
}
