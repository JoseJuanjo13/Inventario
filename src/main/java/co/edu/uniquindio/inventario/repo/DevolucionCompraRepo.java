package co.edu.uniquindio.inventario.repo;


import co.edu.uniquindio.inventario.entidades.DevolucionCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface DevolucionCompraRepo extends JpaRepository<DevolucionCompra, Integer>, Serializable {

    @Query("select de from DevolucionCompra de")
    List<DevolucionCompra> listaDevolucionesCompra();
    
}
