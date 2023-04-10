package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Medicamento;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

public class MedicamentoBean implements Serializable {

    @Getter @Setter
    private Medicamento medicamento;

    public void init() {
        medicamento = new Medicamento();
    }


}
