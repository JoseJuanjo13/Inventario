package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Proveedor;
import co.edu.uniquindio.inventario.entidades.TiposIdentificacion;
import co.edu.uniquindio.inventario.excepciones.ProveedorException;
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
public class ProveedorBean implements Serializable {

    @Getter @Setter
    private Proveedor proveedor;

    @Getter @Setter
    private List<Proveedor> proveedores;

    @Getter @Setter
   private List<Proveedor> proveedoresSeleccionados;

    private boolean editarProveedor;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private List<TiposIdentificacion> tiposIdentificacion;

    String gestionProveedor = "Gestión Proveedor";
    String mensajeBean = "mensaje_bean";

    @PostConstruct
    public void init() {
        proveedor = new Proveedor();
        editarProveedor = false;
        proveedoresSeleccionados = new ArrayList<>();
        proveedores = usuarioServicio.listarProveedores();
        tiposIdentificacion = usuarioServicio.listarTiposIdentificacion();
    }

    public void gestionarProveedor() {
        try {
            if(!editarProveedor) {
                Proveedor nuevoProveedor = usuarioServicio.crearProveedor(proveedor);
                proveedores.add(nuevoProveedor);

                proveedor = new Proveedor();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, gestionProveedor, "¡Se ha registrado el proveedor con éxito!");
                FacesContext.getCurrentInstance().addMessage(mensajeBean, fm);
            } else {
                usuarioServicio.actualizarProveedor(proveedor);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, gestionProveedor, "¡Se ha actualizado el proveedor con éxito!");
                FacesContext.getCurrentInstance().addMessage(mensajeBean, fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, gestionProveedor, e.getMessage());
            FacesContext.getCurrentInstance().addMessage(mensajeBean, fm);
        }
    }

    public void eliminarProveedores() {
        proveedoresSeleccionados.forEach(p -> {
            try {
                usuarioServicio.eliminarProveedor(p);
                proveedores.remove(p);
            } catch (Exception e) {
                throw new ProveedorException(e.getMessage());
            }
        });
        proveedoresSeleccionados.clear();
    }

    public String getMensajeEliminar() {
        if(proveedoresSeleccionados.isEmpty()) {
            return "Eliminar";
        } else {
            return proveedoresSeleccionados.size() == 1
                    ? "Eliminar 1 proveedor"
                    : "Eliminar " + proveedoresSeleccionados.size() + " proveedores";
        }
    }

    public String getTextoDialogo() { return editarProveedor ? "Editar Proveedor" : "Crear Proveedor";}

    public void dialogoSeleccionProveedor(Proveedor proveedorSeleccinado) {
        if(proveedorSeleccinado != null) {
            this.proveedor = proveedorSeleccinado;
            editarProveedor = true;
        } else {
            this.proveedor = new Proveedor();
            editarProveedor = false;
        }
    }

}
