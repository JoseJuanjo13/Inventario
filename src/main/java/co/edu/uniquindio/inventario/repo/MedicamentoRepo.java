package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface MedicamentoRepo extends JpaRepository<Medicamento, Integer>, Serializable {

    @Query("select m from Medicamento m")
    List<Medicamento> listaMedicamentos();

    @Query("select m from Medicamento m where m.principioActivo = :principioActivo")
    Medicamento comprobarPrincipioA(String principioActivo);
}
