package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.*;
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

    @Getter @Setter
    private List<Medicamento> listaMedicamentos;

    @Getter @Setter
    private List<Insumo> listaInsumos;

    @Autowired
    private DevolucionCompraBean devolucionCompraBean;

    @Getter @Setter
    private int idDevolucionCompra;

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
        detalleDevolucionCompra = new DetalleDevolucionCompra();
        detalleDevolucionCompra.setMedicamento(new Medicamento());
        detalleDevolucionCompra.setInsumo(new Insumo());
        medicamento = new Medicamento();
        insumo = new Insumo();
        editarDetalle = false;
        habButtonMedicamento = false;
        habButtonInsumo = true;
        detalleDevolucionesSeleccionadas = new ArrayList<>();
        tiposActividad = new ArrayList<>(Arrays.asList("Medicamento", "Insumo"));
        listaMedicamentos = usuarioServicio.listarMedicamento();
        listaInsumos = usuarioServicio.listarInsumo();
    }

    public void gestionarDetalleDevolucionCompra() {
        double subtotalCompra = agregarSubtotalDevolucion();
        detalleDevolucionCompra.setSubtotal(subtotalCompra);

        try {
            if(!editarDetalle) {

                medicamento = buscarMedicamento(medicamento.getPrincipioActivo());
                detalleDevolucionCompra.setMedicamento(medicamento);

                insumo = buscarInsumo(insumo.getNombre());
                detalleDevolucionCompra.setInsumo(insumo);

                if(!habButtonMedicamento) {
                    detalleDevolucionCompra.setTipoActividad("Medicamento");
                } else {
                    detalleDevolucionCompra.setTipoActividad("Insumo");
                }

                DevolucionCompra devolucionCompra = buscarDevolucionCompra(idDevolucionCompra);
                detalleDevolucionCompra.setDevolucionCompra(devolucionCompra);

                DetalleDevolucionCompra nuevoDetalleDevolucionCompra = usuarioServicio.crearDetalleDevolucionCompra(detalleDevolucionCompra);
                detalleDevolucionesCompras.add(nuevoDetalleDevolucionCompra);

                getTotalDetallesDevolucion();
                detalleDevolucionCompra = new DetalleDevolucionCompra();
                medicamento = new Medicamento();
                insumo = new Insumo();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Detalle Devolución compra", "¡Se ha registrado el detalle de la devolución de su compra con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            } else {

                medicamento = buscarMedicamento(medicamento.getPrincipioActivo());
                if(medicamento != null) {
                    detalleDevolucionCompra.setMedicamento(medicamento);
                }

                insumo = buscarInsumo(insumo.getNombre());
                if(insumo != null) {
                    detalleDevolucionCompra.setInsumo(insumo);
                }

                if(!habButtonMedicamento) {
                    detalleDevolucionCompra.setTipoActividad("Medicamento");
                } else {
                    detalleDevolucionCompra.setTipoActividad("Insumo");
                }

                DevolucionCompra devolucionCompra = buscarDevolucionCompra(idDevolucionCompra);
                detalleDevolucionCompra.setDevolucionCompra(devolucionCompra);

                usuarioServicio.actualizarDetalleDevolucionCompra(detalleDevolucionCompra);

                getTotalDetallesDevolucion();
                detalleDevolucionCompra = new DetalleDevolucionCompra();
                medicamento = new Medicamento();
                insumo = new Insumo();

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Detalle devolución compra", "¡Se ha actualizado el detalle de la devolución de su compra con éxito!");
                FacesContext.getCurrentInstance().addMessage(null, fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Detalle Devolución Compra", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }

    private DevolucionCompra buscarDevolucionCompra(int idDevolucionCompra) {
        final DevolucionCompra[] devolucionCompraEncontrada = new DevolucionCompra[1];
        List<DevolucionCompra> devoluciones = usuarioServicio.listarDevolucionesCompra();

        devoluciones.forEach(devolucionCompra -> {
            if(devolucionCompra.getIdDevolucionCompra() == idDevolucionCompra) {
                devolucionCompraEncontrada[0] = devolucionCompra;
            }
        });
        return devolucionCompraEncontrada[0];
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

    private double agregarSubtotalDevolucion() {
        return detalleDevolucionCompra.getCantidad() * detalleDevolucionCompra.getValorUnitario();
    }

    public void eliminarDetallesDevolucion() {
        detalleDevolucionesSeleccionadas.forEach(dc -> {
            try {
                usuarioServicio.eliminarDetalleDevolucionCompra(dc);
                detalleDevolucionesCompras.remove(dc);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        detalleDevolucionesSeleccionadas.clear();
    }

    public String getMensajeEliminar() {
        if(detalleDevolucionesSeleccionadas.isEmpty()) {
            return "Eliminar";
        } else {
            return detalleDevolucionesSeleccionadas.size() == 1
                    ? "Eliminar 1 detalle de la devolución de la compra"
                    : "Eliminar " + detalleDevolucionesSeleccionadas.size() + " detalles de la devolución.";
        }
    }

    public String getTextoDialogo() { return editarDetalle ? "Editar Detalle Devolución" : "Crear Detalle Devolución";}

    public void dialogoSeleccionDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionSeleccinada) {
        if(detalleDevolucionSeleccinada != null) {
            this.detalleDevolucionCompra = detalleDevolucionSeleccinada;
            editarDetalle = true;
        } else {
            this.detalleDevolucionCompra = new DetalleDevolucionCompra();
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

    private void getTotalDetallesDevolucion() {
        List<DetalleDevolucionCompra> detalles = usuarioServicio.listarDetallesDevolucionesCompra(idDevolucionCompra);
        double total = detalles.stream().mapToDouble(DetalleDevolucionCompra::getSubtotal).sum();

       /* DevolucionCompra devolucionCompra = buscarDevolucionCompra(idDevolucionCompra);
        devolucionCompra.setT(total);*/
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
