package co.edu.uniquindio.inventario.servicios;

import co.edu.uniquindio.inventario.entidades.*;

import java.io.Serializable;
import java.util.List;

public interface UsuarioServicio extends Serializable {

    Usuario login(String email, String contrasena);

    // Usuario
    Usuario crearUsuario(Usuario usuario);

    Usuario actualizarUsuario(Usuario usuario);

    Boolean eliminarUsuario(Usuario usuario);

    List<Usuario> listarUsuario();


    // Bodega
    Bodega crearBodega(Bodega bodega);

    Bodega actualizarBodega(Bodega bodega);

    Boolean eliminarBodega(Bodega bodega);

    List<Bodega> listarBodegas();

    // Insumos

    Insumo crearInsumo(Insumo insumo);

    Insumo actualizarInsumo(Insumo insumo);

    Boolean eliminarInsumo(Insumo insumo);

    List<Insumo> listarInsumo();

    // Medicamento

    Medicamento crearMedicamento(Medicamento medicamento);

    Medicamento actualizarMedicamento(Medicamento medicamento);

    Boolean eliminarMedicamento(Medicamento medicamento);

    List<Medicamento> listarMedicamento();

    // Proveedor

    Proveedor crearProveedor(Proveedor proveedor);

    Proveedor actualizarProveedor(Proveedor proveedor);

    Boolean eliminarProveedor(Proveedor proveedor);

    List<Proveedor> listarProveedores();


    // Compras

    OrdenCompra crearOrdenCompra(OrdenCompra ordenCompra);

    OrdenCompra actualizarOrdenCompra(OrdenCompra ordenCompra);

    Boolean eliminarOrdenCompra(OrdenCompra ordenCompra);

    List<OrdenCompra> listarOrdenesCompra();


    // Detalles Compra

    DetalleOrdenCompra crearDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra);

    DetalleOrdenCompra actualizarOrdenCompra(DetalleOrdenCompra detalleOrdenCompra);

    Boolean eliminarOrdenCompra(DetalleOrdenCompra detalleOrdenCompra);

    List<DetalleOrdenCompra> listarDetallesOrdenesCompra(Integer idOrdenCompra);

    // Devoluciones Compra

    DevolucionCompra crearDevolucionCompra(DevolucionCompra devolucionCompra);

    DevolucionCompra actualizarDevolucionCompra(DevolucionCompra devolucionCompra);

    Boolean eliminarDevolucionCompra(DevolucionCompra devolucionCompra);

    List<DevolucionCompra> listarDevolucionesCompra();

    //Detalles Devolucion compra

    DetalleDevolucionCompra crearDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra);

    DetalleDevolucionCompra actualizarDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra);

    Boolean eliminarDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra);

    List<DetalleDevolucionCompra> listarDetallesDevolucionesCompra(Integer idDevolucionCompra);


    List<TiposIdentificacion> listarTiposIdentificacion();

    TiposIdentificacion obtenerTipoIdentificacion(Integer idIdentificacion);

    Bodega obtenerBodega(Integer id);

    Usuario obtenerUsuario(String id);

    Insumo obtenerInsumo(Integer id);

    Medicamento obtenerMedicamento(Integer id);

    Proveedor obtenerProveedor(String id);

    OrdenCompra obtenerOrdenCompra(Integer id);

    DevolucionCompra obtenerDevolucionCompra(Integer id);

    DetalleOrdenCompra obtenerDetalleOrdenCompra(Integer id);

    DetalleDevolucionCompra obtenerDetalleDevolucionCompra(Integer id);
}
