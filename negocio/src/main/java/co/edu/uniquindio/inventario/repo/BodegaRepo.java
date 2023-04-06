package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BodegaRepo extends JpaRepository<Bodega, Integer> {

    @Query("select b from Bodega b")
    List<Bodega> listaBodegas();

    @Query("select b from Bodega b where b.nombre = :nombre")
    Bodega comprobarNombre(String nombre);

    @Query("select b from Bodega b where b.abreviacion = :abreviacion")
    Bodega comprobarAbreviacion(String abreviacion);
}
