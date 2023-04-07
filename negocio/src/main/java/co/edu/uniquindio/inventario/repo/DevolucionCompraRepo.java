package co.edu.uniquindio.inventario.repo;


import co.edu.uniquindio.inventario.entidades.DevolucionCompra;
import co.edu.uniquindio.inventario.entidades.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DevolucionCompraRepo extends JpaRepository<DevolucionCompra, Integer> {

    @Query("select de from DevolucionCompra de")
    List<DevolucionCompra> listaDevolucionesCompra();
    
}
