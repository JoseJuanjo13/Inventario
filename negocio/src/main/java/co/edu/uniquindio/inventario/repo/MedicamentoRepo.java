package co.edu.uniquindio.inventario.repo;

import co.edu.uniquindio.inventario.entidades.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentoRepo extends JpaRepository<Medicamento, Integer> {
}
