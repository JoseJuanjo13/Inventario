package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface InsumoRepo extends JpaRepository<Insumo, Integer>, Serializable {

    @Query("select i from Insumo i")
    List<Insumo> listaInsumos();

    @Query("select i from Insumo i where i.nombre = :nombre")
    Insumo comprobarNombre(String nombre);
}
