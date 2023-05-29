package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.entidades.DetalleDevolucionCompra;
import co.edu.uniquindio.inventario.entidades.DevolucionCompra;
import co.edu.uniquindio.inventario.excepciones.DetalleDevolucionException;
import co.edu.uniquindio.inventario.excepciones.DevolucionCompraException;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
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

    @Getter @Setter
    private List<Bodega> listaBodegas;

    @Getter @Setter
    Bodega bodega;

    private boolean editarDevolucion;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private DetalleDevolucionCompraBean detalleDevolucionCompraBean;

    String devolucionCompraConst = "Devolución de compra";
    String mensajeBean = "mensaje_bean";

    @PostConstruct
    public void init() {
        devolucionCompra = new DevolucionCompra();
        editarDevolucion = false;
        devolucionesComprasSeleccionadas = new ArrayList<>();
        devolucionesCompras = usuarioServicio.listarDevolucionesCompra();
        listaBodegas = usuarioServicio.listarBodegas();
        bodega = new Bodega();
    }

    public void geationarDevolucionesCompras() {
        try {
            if(!editarDevolucion) {

                devolucionCompra.setTipoMovimiento("Negativo");
                devolucionCompra.setFecha(LocalDate.now());

                bodega = buscarBodega(bodega.getNombre());
                devolucionCompra.setBodega(bodega);

                DevolucionCompra nuevaDevolucionCompra = usuarioServicio.crearDevolucionCompra(devolucionCompra);
                devolucionesCompras.add(nuevaDevolucionCompra);

                devolucionCompra = new DevolucionCompra();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, devolucionCompraConst, "¡Se ha registrado la devolución de su compra con éxito!");
                FacesContext.getCurrentInstance().addMessage(mensajeBean, fm);
            } else {

                usuarioServicio.actualizarDevolucionCompra(devolucionCompra);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, devolucionCompraConst, "¡Se ha actualizado la devolución de su compra con éxito!");
                FacesContext.getCurrentInstance().addMessage(mensajeBean, fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, devolucionCompraConst, e.getMessage());
            FacesContext.getCurrentInstance().addMessage(mensajeBean, fm);
        }
    }

    private Bodega buscarBodega(String nombre) {
        final Bodega[] bodegaEncontrada = {new Bodega()};

        listaBodegas.forEach(b -> {
            if(b.getNombre().equalsIgnoreCase(nombre)) {
                bodegaEncontrada[0] = b;
            }
        });
        return bodegaEncontrada[0];
    }

    public void eliminarDevolucionesCompras() {
        devolucionesComprasSeleccionadas.forEach(dc -> {
            try {
                usuarioServicio.eliminarDevolucionCompra(dc);
                devolucionesCompras.remove(dc);
            } catch (Exception e) {
                throw new DevolucionCompraException(e.getMessage());
            }
        });
        devolucionesComprasSeleccionadas.clear();
    }

    public void dialogoConfirmacionDevolucion() {
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Devolución de compra", "¡Se ha realizado la devolución de su compra con éxito!");
        FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
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

    public List<String> getBodegas() {
        List<String> nombreBodegas = new ArrayList<>();
        listaBodegas.forEach(b -> nombreBodegas.add(b.getNombre()));
        return nombreBodegas;
    }

    public void navegarListaDetalleDevolucion(int idDevolucion) {
        try {
            detalleDevolucionCompraBean.setIdDevolucionCompra(idDevolucion);

            List<DetalleDevolucionCompra> detalles = usuarioServicio.listarDetallesDevolucionesCompra(idDevolucion);
            detalleDevolucionCompraBean.setDetalleDevolucionesCompras(detalles);

            FacesContext.getCurrentInstance().getExternalContext().redirect("/dispensacion/detalle_devolucion_compra.xhtml");
        } catch (IOException e) {
            throw new DetalleDevolucionException(e.getMessage());
        }
    }

    public List<String> filtroEstados(String query) {
        List<String> listaNombreEstados = new ArrayList<>();
        listaNombreEstados.add("Activo"); listaNombreEstados.add("Inactivo");
        return listaNombreEstados;
    }
}
