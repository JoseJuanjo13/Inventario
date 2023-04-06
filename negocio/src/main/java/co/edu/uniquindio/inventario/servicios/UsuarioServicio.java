package co.edu.uniquindio.inventario.servicios;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.entidades.Insumo;
import co.edu.uniquindio.inventario.entidades.Medicamento;
import co.edu.uniquindio.inventario.entidades.Usuario;

import java.util.List;

public interface UsuarioServicio {

    Usuario login(String email, String contrasena) throws Exception;

    // Usuario
    Usuario crearUsuario(Usuario usuario) throws Exception;

    Usuario actualizarUsuario(Usuario usuario);

    Boolean eliminarUsuario(Usuario usuario);

    List<Usuario> listarUsuario(Usuario usuario);


    // Bodega
    Bodega crearBodega(Bodega bodega);

    Bodega actualizarBodega(Bodega bodega);

    Boolean eliminarBodega(Bodega bodega);

    List<Bodega> listarBodegas(Bodega bodega);

    // Insumos

    Insumo crearInsumo(Insumo insumo);

    Insumo actualizarInsumo(Insumo insumo);

    Boolean eliminarInsumo(Insumo insumo);

    List<Insumo> listarInsumo(Insumo insumo);

    // Medicamento

    Medicamento crearMedicamento(Medicamento medicamento);

    Medicamento actualizarMedicamento(Medicamento medicamento);

    Boolean eliminarMedicamento(Medicamento medicamento);

    List<Medicamento> listarMedicamento(Medicamento medicamento);

    //
}
