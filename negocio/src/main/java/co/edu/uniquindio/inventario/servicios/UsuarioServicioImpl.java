package co.edu.uniquindio.inventario.servicios;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.entidades.Insumo;
import co.edu.uniquindio.inventario.entidades.Medicamento;
import co.edu.uniquindio.inventario.entidades.Usuario;
import co.edu.uniquindio.inventario.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private UsuarioRepo usuarioRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public Usuario login(String email, String contrasena) throws Exception {
        Usuario usuario = usuarioRepo.comprobarUsuario(email, contrasena);
        if (usuario == null){
            throw new Exception("El correo o la contraseña incorrectos");
        }
        return usuario;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws Exception {
        if(esRepetido(usuario.getEmail(), usuario.getCedula())){
            throw new Exception("El correo o la cedula se encuentran registrados");
        }else {
            return usuarioRepo.save(usuario);
        }
    }

    boolean esRepetido(String email, String cedula){
        Usuario email_ = usuarioRepo.comprobarEmail(email);
        Usuario cedula_ = usuarioRepo.comprobarCedula(cedula);
        if(email_ != null || cedula_ != null){
            return true;
        }
        return false;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Boolean eliminarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> listarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public Bodega crearBodega(Bodega bodega) {
        return null;
    }

    @Override
    public Bodega actualizarBodega(Bodega bodega) {
        return null;
    }

    @Override
    public Boolean eliminarBodega(Bodega bodega) {
        return null;
    }

    @Override
    public List<Bodega> listarBodegas(Bodega bodega) {
        return null;
    }

    @Override
    public Insumo crearInsumo(Insumo insumo) {
        return null;
    }

    @Override
    public Insumo actualizarInsumo(Insumo insumo) {
        return null;
    }

    @Override
    public Boolean eliminarInsumo(Insumo insumo) {
        return false;
    }

    @Override
    public List<Insumo> listarInsumo(Insumo insumo) {
        return null;
    }

    @Override
    public Medicamento crearMedicamento(Medicamento medicamento) {
        return null;
    }

    @Override
    public Medicamento actualizarMedicamento(Medicamento medicamento) {
        return null;
    }

    @Override
    public Boolean eliminarMedicamento(Medicamento medicamento) {
        return false;
    }

    @Override
    public List<Medicamento> listarMedicamento(Medicamento medicamento) {
        return null;
    }

}
