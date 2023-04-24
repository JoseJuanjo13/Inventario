package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.DetalleOrdenCompra;
import co.edu.uniquindio.inventario.entidades.OrdenCompra;
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
public class DetalleOrdenCompraBean implements Serializable {

    @Getter @Setter
    private DetalleOrdenCompra detalleOrdenCompra;

    @Getter @Setter
    private List<DetalleOrdenCompra> detallesCompra;

    @Getter @Setter
    private List<DetalleOrdenCompra> detallesCompraSeleccionados;

    private boolean editarDetalle;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void init() {
        detalleOrdenCompra = new DetalleOrdenCompra();
        editarDetalle = false;
        detallesCompraSeleccionados = new ArrayList<>();
        detallesCompra = usuarioServicio.listarDetallesOrdenesCompra();
    }

    public void gestionarOrdenCompra() {
        try {
            if(!editarDetalle) {
                DetalleOrdenCompra nuevoDetalleCompra = usuarioServicio.crearDetalleOrdenCompra(detalleOrdenCompra);
                detallesCompra.add(nuevoDetalleCompra);

                detalleOrdenCompra = new DetalleOrdenCompra();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Detalle de la compra", "¡Se ha registrado el detalle de la orden de su compra con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            } else {
                usuarioServicio.actualizarOrdenCompra(detalleOrdenCompra);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Detalle de la compra", "¡Se ha actualizado el detalle de la orden de su compra con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Detalle Orden de compra", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }

    public void eliminarDetallesCompra() {
        detallesCompraSeleccionados.forEach(dc -> {
            try {
                usuarioServicio.eliminarOrdenCompra(dc);
                detallesCompra.remove(dc);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        detallesCompraSeleccionados.clear();
    }

    public String getMensajeEliminar() {
        if(detallesCompraSeleccionados.isEmpty()) {
            return "Eliminar";
        } else {
            return detallesCompraSeleccionados.size() == 1
                    ? "Eliminar 1 detalle de la compra"
                    : "Eliminar " + detallesCompraSeleccionados.size() + " detalles de la compra";
        }
    }

    public String getTextoDialogo() { return editarDetalle ? "Editar Detalle Compra" : "Crear Detalle Compra";}

    public void dialogoSeleccionDetalleOrdenCompra(DetalleOrdenCompra detalleCompraSeleccinada) {
        if(detalleCompraSeleccinada != null) {
            this.detalleOrdenCompra = detalleCompraSeleccinada;
            editarDetalle = true;
        } else {
            this.detalleOrdenCompra = new DetalleOrdenCompra();
            editarDetalle = false;
        }
    }

}
