package co.edu.uniquindio.inventario.servicios;

import co.edu.uniquindio.inventario.entidades.*;

import java.io.Serializable;
import java.util.List;

public interface UsuarioServicio extends Serializable {

    Usuario login(String email, String contrasena) throws Exception;

    // Usuario
    Usuario crearUsuario(Usuario usuario) throws Exception;

    Usuario actualizarUsuario(Usuario usuario) throws Exception;

    Boolean eliminarUsuario(Usuario usuario) throws Exception;

    List<Usuario> listarUsuario();


    // Bodega
    Bodega crearBodega(Bodega bodega) throws Exception;

    Bodega actualizarBodega(Bodega bodega) throws Exception;

    Boolean eliminarBodega(Bodega bodega) throws Exception;

    List<Bodega> listarBodegas();

    // Insumos

    Insumo crearInsumo(Insumo insumo) throws Exception;

    Insumo actualizarInsumo(Insumo insumo) throws Exception;

    Boolean eliminarInsumo(Insumo insumo) throws Exception;

    List<Insumo> listarInsumo();

    // Medicamento

    Medicamento crearMedicamento(Medicamento medicamento) throws Exception;

    Medicamento actualizarMedicamento(Medicamento medicamento) throws Exception;

    Boolean eliminarMedicamento(Medicamento medicamento) throws Exception;

    List<Medicamento> listarMedicamento();

    // Proveedor

    Proveedor crearProveedor(Proveedor proveedor) throws Exception;

    Proveedor actualizarProveedor(Proveedor proveedor) throws Exception;

    Boolean eliminarProveedor(Proveedor proveedor) throws Exception;

    List<Proveedor> listarProveedores();


    // Compras

    OrdenCompra crearOrdenCompra(OrdenCompra ordenCompra) throws Exception;

    OrdenCompra actualizarOrdenCompra(OrdenCompra ordenCompra) throws Exception;

    Boolean eliminarOrdenCompra(OrdenCompra ordenCompra) throws Exception;

    List<OrdenCompra> listarOrdenesCompra();


    // Detalles Compra

    DetalleOrdenCompra crearDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) throws Exception;

    DetalleOrdenCompra actualizarOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) throws Exception;

    Boolean eliminarOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) throws Exception;

    List<DetalleOrdenCompra> listarDetallesOrdenesCompra(Integer idOrdenCompra);

    // Devoluciones Compra

    DevolucionCompra crearDevolucionCompra(DevolucionCompra devolucionCompra) throws Exception;

    DevolucionCompra actualizarDevolucionCompra(DevolucionCompra devolucionCompra) throws Exception;

    Boolean eliminarDevolucionCompra(DevolucionCompra devolucionCompra) throws Exception;

    List<DevolucionCompra> listarDevolucionesCompra();

    //Detalles Devolucion compra

    DetalleDevolucionCompra crearDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra) throws Exception;

    DetalleDevolucionCompra actualizarDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra) throws Exception;

    Boolean eliminarDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra) throws Exception;

    List<DetalleDevolucionCompra> listarDetallesDevolucionesCompra(Integer idDevolucionCompra);


    List<TiposIdentificacion> listarTiposIdentificacion();

    TiposIdentificacion obtenerTipoIdentificacion(Integer idIdentificacion) throws Exception;
}
