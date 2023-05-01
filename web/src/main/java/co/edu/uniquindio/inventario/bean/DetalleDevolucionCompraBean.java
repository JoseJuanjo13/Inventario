package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.DetalleDevolucionCompra;
import co.edu.uniquindio.inventario.entidades.DevolucionCompra;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@SessionScope
public class DetalleDevolucionCompraBean implements Serializable {

    @Getter @Setter
    private DetalleDevolucionCompra detalleDevolucionCompra;

    @Getter @Setter
    private List<DetalleDevolucionCompra> detalleDevolucionesCompras;

    @Getter @Setter
    private List<DetalleDevolucionCompra> detalleDevolucionesSeleccionadas;

    private boolean editarDetalle;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Autowired
    private DevolucionCompraBean devolucionCompraBean;

    @Getter @Setter
    private int idDevolucionCompra;

    @PostConstruct
    public void init() {
        detalleDevolucionCompra = new DetalleDevolucionCompra();
        editarDetalle = false;
        detalleDevolucionesSeleccionadas = new ArrayList<>();
    }

    public void gestionarDetalleDevolucion() {

    }

}
