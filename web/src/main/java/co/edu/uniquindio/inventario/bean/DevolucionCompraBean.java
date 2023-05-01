package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.DevolucionCompra;
import co.edu.uniquindio.inventario.entidades.OrdenCompra;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class DevolucionCompraBean implements Serializable {

    @Getter @Setter
    private DevolucionCompra devolucionCompra;

    @Getter @Setter
    private List<DevolucionCompra> devolucionesCompras;

    @Getter @Setter
    private List<DevolucionCompra> devolucionesComprasSeleccionadas;

    private boolean editarDevolucion;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void init() {
        devolucionCompra = new DevolucionCompra();
        editarDevolucion = false;
        devolucionesComprasSeleccionadas = new ArrayList<>();
        devolucionesCompras = usuarioServicio.listarDevolucionesCompra();
    }

    public void geationarDevolucionesCompras() {
        try {
            if(!editarDevolucion) {

                DevolucionCompra nuevaDevolucionCompra = usuarioServicio.crearDevolucionCompra(devolucionCompra);
                devolucionesCompras.add(nuevaDevolucionCompra);

                devolucionCompra = new DevolucionCompra();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Devolución de compra", "¡Se ha registrado la devolución de su compra con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            } else {

                usuarioServicio.actualizarDevolucionCompra(devolucionCompra);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Devolución de compra", "¡Se ha actualizado la devolución de su compra con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Devolución de compra", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }

    public void eliminarDevolucionesCompras() {
        devolucionesComprasSeleccionadas.forEach(dc -> {
            try {
                usuarioServicio.eliminarDevolucionCompra(dc);
                devolucionesCompras.remove(dc);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        devolucionesComprasSeleccionadas.clear();
    }

    public String getMensajeEliminar() {
        if(devolucionesComprasSeleccionadas.isEmpty()) {
            return "Eliminar";
        } else {
            return devolucionesComprasSeleccionadas.size() == 1
                    ? "Eliminar 1 devolución de compra"
                    : "Eliminar " + devolucionesComprasSeleccionadas.size() + " devoluciones de compras";
        }
    }

    public String getTextoDialogo() { return editarDevolucion ? "Editar Devolución Compra" : "Crear Devolución Compra";}

    public void dialogoSeleccionDevolucionCompra(DevolucionCompra devolucionCompraSeleccinada) {
        if(devolucionCompraSeleccinada != null) {
            this.devolucionCompra = devolucionCompraSeleccinada;
            editarDevolucion = true;
        } else {
            this.devolucionCompra = new DevolucionCompra();
            editarDevolucion = false;
        }
    }
}
