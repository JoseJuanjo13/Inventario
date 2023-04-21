package co.edu.uniquindio.inventario.servicios;

import co.edu.uniquindio.inventario.entidades.*;

import java.util.List;

public interface UsuarioServicio {

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
}
