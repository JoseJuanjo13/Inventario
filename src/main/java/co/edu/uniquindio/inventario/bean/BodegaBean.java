package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Bodega;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class BodegaBean implements Serializable {

    @Getter @Setter
    private Bodega bodega;

    @Getter @Setter
    private List<Bodega> bodegas;

    @Getter @Setter
    private List<Bodega> bodegasSeleccionadas;

    private boolean editarBodega;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void init() {
        bodega = new Bodega();
        editarBodega = false;
        bodegasSeleccionadas = new ArrayList<>();
        bodegas = usuarioServicio.listarBodegas();
    }

    public void gestionarBodega() {
        try {
            if(!editarBodega) {
                Bodega nuevaBodega = usuarioServicio.crearBodega(bodega);
                bodegas.add(nuevaBodega);

                bodega = new Bodega();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión Bodega", "¡Se ha registrado la bodega con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            } else {
                usuarioServicio.actualizarBodega(bodega);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión Bodega", "¡Se ha actualizado la bodega con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Gestión Bodega", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }

    }

    public void eliminarBodegas() {
        bodegasSeleccionadas.forEach(b -> {
            try {
                usuarioServicio.eliminarBodega(b);
                bodegas.remove(b);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        bodegasSeleccionadas.clear();
    }

    public String getMensajeEliminar() {
        if(bodegasSeleccionadas.isEmpty()) {
            return "Eliminar";
        } else {
            return bodegasSeleccionadas.size() == 1
                    ? "Eliminar 1 bodega"
                    : "Eliminar " + bodegasSeleccionadas.size() + " bodegas";
        }
    }

    public String getTextoDialogo() {
        return editarBodega ? "Editar Bodega" : "Crear Bodega";
    }

    public void dialogoSeleccionBodega(Bodega bodegaSeleccionada) {

        if(bodegaSeleccionada != null) {
            this.bodega = bodegaSeleccionada;
            editarBodega = true;
        } else {
            this.bodega = new Bodega();
            editarBodega = false;
        }
    }


}
