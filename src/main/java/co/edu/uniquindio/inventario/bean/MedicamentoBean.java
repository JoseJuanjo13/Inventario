package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Medicamento;
import co.edu.uniquindio.inventario.excepciones.MedicamentoException;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class MedicamentoBean implements Serializable {

    @Getter @Setter
    private Medicamento medicamento;

    @Getter @Setter
    private List<Medicamento> medicamentos;

    @Getter @Setter
    private List<Medicamento> medicamentosSeleccionados;

    private boolean editarMedicamento;

    @Autowired
    private UsuarioServicio usuarioServicio;

    String gestionMedicamento = "Gestión Medicamento";

    @PostConstruct
    public void init() {
        medicamento = new Medicamento();
        editarMedicamento = false;
        medicamentosSeleccionados = new ArrayList<>();
        medicamentos = usuarioServicio.listarMedicamento();
    }

    public void gestionarMedicamento() {
        try {
            if(!editarMedicamento) {
                Medicamento nuevoMedicamento = usuarioServicio.crearMedicamento(medicamento);
                medicamentos.add(nuevoMedicamento);

                medicamento = new Medicamento();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, gestionMedicamento, "¡Se ha registrado el medicamento con éxito!");
                FacesContext.getCurrentInstance().addMessage(gestionMedicamento, fm);
            } else {
                usuarioServicio.actualizarMedicamento(medicamento);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, gestionMedicamento, "¡Se ha actualizado el medicamento con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, gestionMedicamento, e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }

    public void eliminarMedicamento() {
        medicamentosSeleccionados.forEach(m -> {
            try {
                usuarioServicio.eliminarMedicamento(m);
                medicamentos.remove(m);
            } catch (Exception e) {
                throw new MedicamentoException(e.getMessage());
            }
        });
        medicamentosSeleccionados.clear();
    }

    public String getMensajeEliminar() {

        if(medicamentosSeleccionados.isEmpty()) {

            return "Eliminar";
        } else {
            return medicamentosSeleccionados.size() == 1
                    ? "Eliminar 1 medicamento"
                    : "Eliminar " + medicamentosSeleccionados.size() + " medicamentos";
        }
    }

    public String getTextoDialogo() {
        return editarMedicamento ? "Editar Medicamento" : "Crear Medicamento";
    }

    public void dialogoSeleccionMedicamento(Medicamento medicamentoSeleccionado) {

        if(medicamentoSeleccionado != null) {
            this.medicamento = medicamentoSeleccionado;
            editarMedicamento = true;
        } else {
            this.medicamento = new Medicamento();
            editarMedicamento = false;
        }
    }

    public List<String> filtroEstados(String query) {
        List<String> listaNombreEstados = new ArrayList<>();
        listaNombreEstados.add("Activo"); listaNombreEstados.add("Inactivo");
        return listaNombreEstados;
    }

}
