package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.DetalleOrdenCompra;
import co.edu.uniquindio.inventario.entidades.Insumo;
import co.edu.uniquindio.inventario.entidades.Medicamento;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@SessionScope
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

    @Getter @Setter
    private List<Medicamento> listaMedicamentos;

    @Getter @Setter
    private List<Insumo> listaInsumos;

    @Autowired
    private OrdenCompraBean ordenCompraBean;

    private int idOrdenCompra;

    public void setIdOrdenCompra(int nuevoId) {
        this.idOrdenCompra = nuevoId;
    }

    @Getter @Setter
    private List<String> tiposActividad;

    @Getter @Setter
    private boolean habButtonMedicamento, habButtonInsumo;

    @Getter @Setter
    Medicamento medicamento;

    @Getter @Setter
    Insumo insumo;

    @PostConstruct
    public void init() {
        detalleOrdenCompra = new DetalleOrdenCompra();
        detalleOrdenCompra.setMedicamento(new Medicamento());
        detalleOrdenCompra.setInsumo(new Insumo());
        medicamento = new Medicamento();
        insumo = new Insumo();
        editarDetalle = false;
        habButtonMedicamento = false;
        habButtonInsumo = true;
        detallesCompraSeleccionados = new ArrayList<>();
        tiposActividad = new ArrayList<>(Arrays.asList("Medicamento", "Insumo"));
        listaMedicamentos = usuarioServicio.listarMedicamento();
        listaInsumos = usuarioServicio.listarInsumo();
    }

    public void gestionarDetalleOrdenCompra() {
        double subtotalCompra = agregarSubtotalCompra();
        detalleOrdenCompra.setSubtotal(subtotalCompra);

        try {
            if(!editarDetalle) {

                medicamento = buscarMedicamento(medicamento.getPrincipioActivo());
                detalleOrdenCompra.setMedicamento(medicamento);

                insumo = buscarInsumo(insumo.getNombre());
                detalleOrdenCompra.setInsumo(insumo);

                if(!habButtonMedicamento) {
                    detalleOrdenCompra.setTipoActividad("Medicamento");
                } else {
                    detalleOrdenCompra.setTipoActividad("Insumo");
                }

                OrdenCompra ordenCompra = buscarOrdenCompra(idOrdenCompra);
                detalleOrdenCompra.setOrdenCompra(ordenCompra);

                DetalleOrdenCompra nuevoDetalleOrdenCompra = usuarioServicio.crearDetalleOrdenCompra(detalleOrdenCompra);
                detallesCompra.add(nuevoDetalleOrdenCompra);

                getTotalDetallesCompra();
                detalleOrdenCompra = new DetalleOrdenCompra();
                medicamento = new Medicamento();
                insumo = new Insumo();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Detalle de la compra", "¡Se ha registrado el detalle de la orden de su compra con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            } else {

                medicamento = buscarMedicamento(medicamento.getPrincipioActivo());
                if(medicamento != null) {
                    detalleOrdenCompra.setMedicamento(medicamento);
                }

                insumo = buscarInsumo(insumo.getNombre());
                if(insumo != null) {
                    detalleOrdenCompra.setInsumo(insumo);
                }

                if(!habButtonMedicamento) {
                    detalleOrdenCompra.setTipoActividad("Medicamento");
                } else {
                    detalleOrdenCompra.setTipoActividad("Insumo");
                }

                OrdenCompra ordenCompra = buscarOrdenCompra(idOrdenCompra);
                detalleOrdenCompra.setOrdenCompra(ordenCompra);

                usuarioServicio.actualizarOrdenCompra(detalleOrdenCompra);

                getTotalDetallesCompra();
                detalleOrdenCompra = new DetalleOrdenCompra();
                medicamento = new Medicamento();
                insumo = new Insumo();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Detalle de la compra", "¡Se ha actualizado el detalle de la orden de su compra con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(detalleOrdenCompra);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Detalle Orden de compra", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }

    private OrdenCompra buscarOrdenCompra(int idOrdenCompra) {
        final OrdenCompra[] ordenCompraEncontrada = new OrdenCompra[1];
        List<OrdenCompra> ordenes = usuarioServicio.listarOrdenesCompra();

        ordenes.forEach(ordenCompra -> {
            if(ordenCompra.getIdCompra() == idOrdenCompra) {
                ordenCompraEncontrada[0] = ordenCompra;
            }
        });
        return ordenCompraEncontrada[0];
    }

    private Medicamento buscarMedicamento(String nombreMedicamento) {
        final Medicamento[] medicamento = new Medicamento[1];

        listaMedicamentos.forEach(m -> {
            if(m.getPrincipioActivo().equalsIgnoreCase(nombreMedicamento)) {
                medicamento[0] = m;
            }
        });
        return medicamento[0];
    }

    private Insumo buscarInsumo(String nombre) {
        final Insumo[] insumo = new Insumo[1];

        listaInsumos.forEach(i -> {
            if(i.getNombre().equalsIgnoreCase(nombre)) {
                insumo[0] = i;
            }
        });
        return insumo[0];
    }

    private double agregarSubtotalCompra() {
        double subtotal = 0.0;
        return subtotal = detalleOrdenCompra.getCantidadSolicitada() * detalleOrdenCompra.getValorUnitario();
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

    public List<String> getMedicamentos() {
        List<String> nombreMedicamentos = new ArrayList<>();
        listaMedicamentos.forEach(medicamento -> {
            nombreMedicamentos.add(medicamento.getPrincipioActivo());
        });
        return nombreMedicamentos;
    }

    public List<String> getInsumos() {
        List<String> nombreInsumos = new ArrayList<>();
        listaInsumos.forEach(insumo -> {
            nombreInsumos.add(insumo.getNombre());
        });
        return nombreInsumos;
    }

    public void getTotalDetallesCompra() throws Exception {
        List<DetalleOrdenCompra> detalles = usuarioServicio.listarDetallesOrdenesCompra(idOrdenCompra);
        double totalCompra = detalles.stream().mapToDouble(DetalleOrdenCompra::getSubtotal).sum();

        OrdenCompra ordenCompra = buscarOrdenCompra(idOrdenCompra);
        ordenCompra.setTotal(totalCompra);
        usuarioServicio.actualizarOrdenCompra(ordenCompra);
    }

    public void habilitarOpcion() {
        if (habButtonMedicamento == true) {
            habButtonMedicamento = false;
            habButtonInsumo = true;
        } else {
            habButtonMedicamento = true;
            habButtonInsumo = false;
        }
    }


}
