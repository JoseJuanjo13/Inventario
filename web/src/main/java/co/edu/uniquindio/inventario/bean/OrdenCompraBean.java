package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.entidades.OrdenCompra;
import co.edu.uniquindio.inventario.entidades.Proveedor;
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
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Component
@ViewScoped
public class OrdenCompraBean implements Serializable {

    @Getter @Setter
    private OrdenCompra ordenCompra;

    @Getter @Setter
    private List<OrdenCompra> ordenesCompras;

    @Getter @Setter
    private List<OrdenCompra> ordenesComprasSeleccionadas;

    private boolean editarOrdenCompra;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private String nombreProveedor;

    @Getter @Setter
    private String nombreBodega;

    @Getter @Setter
    private double totalCompra = 0.0;

    @PostConstruct
    public void init() {
        ordenCompra = new OrdenCompra();
        editarOrdenCompra = false;
        ordenesComprasSeleccionadas = new ArrayList<>();
        ordenesCompras = usuarioServicio.listarOrdenesCompra();
    }

    public void gestionarOrdenCompra() {
        Proveedor proveedor;
        Bodega bodega;
        try {
            if(!editarOrdenCompra) {

                proveedor = validarProveedor(nombreProveedor);
                bodega = validarBodega(nombreBodega);

                ordenCompra.setFecha(LocalDate.now());
                ordenCompra.setEstado("Activo");
                ordenCompra.setProveedor(proveedor);
                ordenCompra.setBodega(bodega);
                ordenCompra.setTotal(totalCompra);

                OrdenCompra nuevaOrdenCompra = usuarioServicio.crearOrdenCompra(ordenCompra);
                ordenesCompras.add(nuevaOrdenCompra);

                ordenCompra = new OrdenCompra();
                nombreBodega = "";
                nombreProveedor = "";

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Orden de compra", "¡Se ha registrado la orden de compra con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            } else {

                nombreProveedor = ordenCompra.getProveedor().getNombre();
                nombreBodega = ordenCompra.getBodega().getNombre();

                proveedor = validarProveedor(nombreProveedor);
                bodega = validarBodega(nombreBodega);

                ordenCompra.setFecha(LocalDate.now());
                ordenCompra.setEstado("Activo");
                ordenCompra.setProveedor(proveedor);
                ordenCompra.setBodega(bodega);
                ordenCompra.setTotal(totalCompra);

                usuarioServicio.actualizarOrdenCompra(ordenCompra);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Orden de compra", "¡Se ha actualizado la orden de compra con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Orden de compra", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }

    private Proveedor validarProveedor(String nombreProveedor) throws Exception {
        List<Proveedor> listaProveedores = usuarioServicio.listarProveedores();
        AtomicReference<Proveedor> busqueda = new AtomicReference<>(new Proveedor());

        listaProveedores.forEach(proveedor -> {
            if(proveedor.getNombre().equalsIgnoreCase(nombreProveedor)) {
                busqueda.set(proveedor);
            }
        });
        if(busqueda.get().getNumeroIdentificacion() == null) {
            throw new Exception("El proveedor no se encuentra registrado.");
        }
        return busqueda.get();
    }

    private Bodega validarBodega(String nombreBodega) throws Exception {
        List<Bodega> listaBodegas = usuarioServicio.listarBodegas();
        AtomicReference<Bodega> busqueda = new AtomicReference<>(new Bodega());
        listaBodegas.forEach(bodega -> {
            if(bodega.getNombre().equalsIgnoreCase(nombreBodega)) {
                busqueda.set(bodega);
            }
        });
        if(busqueda.get().getIdBodega() == null) {
            throw new Exception("La bodega no se encuentra registrada.");
        }
        return busqueda.get();
    }

    public void eliminarOrdenesCompras() {
        ordenesComprasSeleccionadas.forEach(oc -> {
            try {
                usuarioServicio.eliminarOrdenCompra(oc);
                ordenesCompras.remove(oc);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        ordenesComprasSeleccionadas.clear();
    }

    public String getMensajeEliminar() {
        if(ordenesComprasSeleccionadas.isEmpty()) {
            return "Eliminar";
        } else {
            return ordenesComprasSeleccionadas.size() == 1
                    ? "Eliminar 1 orden de compra"
                    : "Eliminar " + ordenesComprasSeleccionadas.size() + " ordenes de compras";
        }
    }

    public String getTextoDialogo() { return editarOrdenCompra ? "Editar Orden Compra" : "Crear Orden Compra";}

    public void dialogoSeleccionOrdenCompra(OrdenCompra ordenCompraSeleccinada) {
        if(ordenCompraSeleccinada != null) {
            this.ordenCompra = ordenCompraSeleccinada;
            editarOrdenCompra = true;
        } else {
            this.ordenCompra = new OrdenCompra();
            editarOrdenCompra = false;
        }
    }

    public List<String> filtroProveedor(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> listaNombreProveedores = new ArrayList<>();
        List<Proveedor> proveedores = usuarioServicio.listarProveedores();
        for (Proveedor proveedor : proveedores) {
            listaNombreProveedores.add(proveedor.getNombre());
        }

        return listaNombreProveedores.stream().filter(t -> t.toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }

    public List<String> filtroBodega(String query) {
        String queryLowerCase = query.toLowerCase();
        List<String> listaNombreBodegas = new ArrayList<>();
        List<Bodega> bodegas = usuarioServicio.listarBodegas();
        for (Bodega bodega : bodegas) {
            listaNombreBodegas.add(bodega.getNombre());
        }
        return listaNombreBodegas.stream().filter(t -> t.toLowerCase().contains(queryLowerCase)).collect(Collectors.toList());
    }
}
