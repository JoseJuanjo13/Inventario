package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdenCompraRepo extends JpaRepository<OrdenCompra, Integer> {

    @Query("select or from OrdenCompra or where or.estado = 'Activo'")
    List<OrdenCompra> listaOrdenesCompra();
}
