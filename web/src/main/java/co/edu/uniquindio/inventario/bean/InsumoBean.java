package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Insumo;
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
public class InsumoBean implements Serializable {

    @Getter @Setter
    private Insumo insumo;

    @Getter @Setter
    private List<Insumo> insumos;

    @Getter @Setter
    private List<Insumo> insumosSeleccionados;

    private boolean editarInsumo;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void init() {
        insumo = new Insumo();
        editarInsumo = false;
        insumosSeleccionados = new ArrayList<>();
        insumos = usuarioServicio.listarInsumo();
    }

    public void gestionarInsumo() {
        try {
            if(!editarInsumo) {
                Insumo nuevoInsumo = usuarioServicio.crearInsumo(insumo);
                insumos.add(nuevoInsumo);

                insumo = new Insumo();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión Insumo", "¡Se ha registrado el insumo con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            } else {
                usuarioServicio.actualizarInsumo(insumo);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión Insumo", "¡Se ha actualizado el insumo con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión Insumo", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }

    public void eliminarInsumos() {
        insumosSeleccionados.forEach(i -> {
            try {
                usuarioServicio.eliminarInsumo(i);
                insumos.remove(i);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        insumosSeleccionados.clear();
    }

    public String getMensajeEliminar() {
        if(insumosSeleccionados.isEmpty()) {
            return "Eliminar";
        } else {
            return insumosSeleccionados.size() == 1
                    ? "Eliminar 1 insumo"
                    : "Eliminar " + insumosSeleccionados.size() + " insumos";
        }
    }

    public String getTextoDialogo() { return editarInsumo ? "Editar Insumo" : "Crear Insumo";}

    public void dialogoSeleccionInsumo(Insumo insumoSeleccionado) {
        if(insumoSeleccionado != null) {
            this.insumo = insumoSeleccionado;
            editarInsumo = true;
        } else {
            this.insumo = new Insumo();
            editarInsumo = false;
        }
    }


}
