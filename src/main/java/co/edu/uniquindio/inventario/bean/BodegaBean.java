package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.excepciones.EliminarBodegaException;
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

    String GESTION_BODEGA = "Gestión Bodega";
    String MENSAJE_BEAN = "mensaje_bean";

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

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, GESTION_BODEGA, "¡Se ha registrado la bodega con éxito!");
                FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN, fm);
            } else {
                usuarioServicio.actualizarBodega(bodega);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, GESTION_BODEGA, "¡Se ha actualizado la bodega con éxito!");
                FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN, fm);
            }

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, GESTION_BODEGA, e.getMessage());
            FacesContext.getCurrentInstance().addMessage(MENSAJE_BEAN, fm);
        }

    }

    public void eliminarBodegas() {
        bodegasSeleccionadas.forEach(b -> {
            try {
                usuarioServicio.eliminarBodega(b);
                bodegas.remove(b);
            } catch (Exception e) {
                throw new EliminarBodegaException(e.getMessage());
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
