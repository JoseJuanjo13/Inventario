package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.Proveedor;
import co.edu.uniquindio.inventario.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepo extends JpaRepository<Proveedor, Integer> {

    @Query("select p from Proveedor p where p.numeroIdentificacion = :identificacion")
    Proveedor comprobarIdentificacion(String identificacion);

}
