package co.edu.uniquindio.inventario.servicios;

import co.edu.uniquindio.inventario.entidades.*;
import co.edu.uniquindio.inventario.repo.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicios que se implementaran en la aplicacion del modulo de inventario
 **/
@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private final UsuarioRepo usuarioRepo;
    private final BodegaRepo bodegaRepo;
    private final InsumoRepo insumoRepo;
    private final MedicamentoRepo medicamentoRepo;

    private final ProveedorRepo proveedorRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo, BodegaRepo bodegaRepo, InsumoRepo insumoRepo,
                               MedicamentoRepo medicamentoRepo, ProveedorRepo proveedorRepo) {
        this.usuarioRepo = usuarioRepo;
        this.bodegaRepo = bodegaRepo;
        this.insumoRepo = insumoRepo;
        this.medicamentoRepo = medicamentoRepo;
        this.proveedorRepo = proveedorRepo;
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
            throw new Exception("El correo o la cédula se encuentran registrados");
        }else {
            return usuarioRepo.save(usuario);
        }
    }

    boolean esRepetido(String email, String cedula){
        Usuario emailRegistrado = usuarioRepo.comprobarEmail(email);
        Usuario cedulaRegistrada = usuarioRepo.comprobarCedula(cedula);
        return emailRegistrado != null && cedulaRegistrada != null;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws Exception {
        Optional<Usuario> guardado = usuarioRepo.findById(usuario.getCedula());
        if (guardado.isEmpty()){
            throw new Exception("El usuario no existe");
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public Boolean eliminarUsuario(Usuario usuario) throws Exception {
        Optional<Usuario> guardado = usuarioRepo.findById(usuario.getCedula());
        if (guardado.isEmpty()){
            throw new Exception("El usuario no existe");
        }else {
            usuarioRepo.delete(guardado.get());
            return true;
        }
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepo.findAll();
    }

    @Override
    public Bodega crearBodega(Bodega bodega) throws Exception {
        if(esRepetidoBodega(bodega.getNombre(), bodega.getAbreviacion())){
            throw new Exception("El nombre o la abreviacion ya esta registrado");
        }else {
            return bodegaRepo.save(bodega);
        }
    }

    private boolean esRepetidoBodega(String nombre, String abreviacion) {
        Bodega nombreRegistrado = bodegaRepo.comprobarNombre(nombre);
        Bodega abreviacionRegistrado = bodegaRepo.comprobarAbreviacion(abreviacion);
        return nombreRegistrado != null && abreviacionRegistrado != null;
    }

    @Override
    public Bodega actualizarBodega(Bodega bodega) throws Exception {
        Optional<Bodega> guardado = bodegaRepo.findById(bodega.getIdBodega());
        if (guardado.isEmpty()){
            throw new Exception("La bodega no existe");
        }
        return bodegaRepo.save(bodega);
    }

    @Override
    public Boolean eliminarBodega(Bodega bodega) throws Exception {
        Optional<Bodega> guardado = bodegaRepo.findById(bodega.getIdBodega());
        if (guardado.isEmpty()){
            throw new Exception("La bodega no existe");
        }else {
            bodegaRepo.delete(guardado.get());
            return true;
        }
    }

    @Override
    public List<Bodega> listarBodegas() {
        return bodegaRepo.findAll();
    }

    @Override
    public Insumo crearInsumo(Insumo insumo) throws Exception {
        if(esRepetidoInsumo(insumo.getNombre())){
            throw new Exception("El nombre ya esta registrado");
        }else {
            return insumoRepo.save(insumo);
        }
    }

    private boolean esRepetidoInsumo(String nombre) {
        Insumo nombreRegistrado = insumoRepo.comprobarNombre(nombre);
        return nombreRegistrado != null;
    }

    @Override
    public Insumo actualizarInsumo(Insumo insumo) throws Exception {
        Optional<Insumo> guardado = insumoRepo.findById(insumo.getIdInsumo());
        if (guardado.isEmpty()){
            throw new Exception("El insumo no existe");
        }
        return insumoRepo.save(insumo);
    }

    @Override
    public Boolean eliminarInsumo(Insumo insumo) throws Exception {
        Optional<Insumo> guardado = insumoRepo.findById(insumo.getIdInsumo());
        if (guardado.isEmpty()){
            throw new Exception("El insumo no existe");
        }else {
            insumoRepo.delete(guardado.get());
            return true;
        }
    }

    @Override
    public List<Insumo> listarInsumo() {
        return insumoRepo.findAll();
    }

    @Override
    public Medicamento crearMedicamento(Medicamento medicamento) throws Exception {
        if(esRepetidoMedicamento(medicamento.getPrincipioActivo())){
            throw new Exception("El nombre ya esta registrado");
        }else {
            return medicamentoRepo.save(medicamento);
        }
    }

    private boolean esRepetidoMedicamento(String principioActivo) {
        Medicamento princioActivoRegistrado = medicamentoRepo.comprobarPrincipioA(principioActivo);
        return princioActivoRegistrado != null;
    }

    @Override
    public Medicamento actualizarMedicamento(Medicamento medicamento) throws Exception {
        Optional<Medicamento> guardado = medicamentoRepo.findById(medicamento.getIdMedicamento());
        if (guardado.isEmpty()){
            throw new Exception("El medicamento no existe");
        }
        return medicamentoRepo.save(medicamento);
    }

    @Override
    public Boolean eliminarMedicamento(Medicamento medicamento) throws Exception {
        Optional<Medicamento> guardado = medicamentoRepo.findById(medicamento.getIdMedicamento());
        if (guardado.isEmpty()){
            throw new Exception("El insumo no existe");
        }else {
            medicamentoRepo.delete(guardado.get());
            return true;
        }
    }

    @Override
    public List<Medicamento> listarMedicamento() {
        return medicamentoRepo.findAll();
    }


    @Override
    public Proveedor crearProveedor(Proveedor proveedor) throws Exception {
        if(proveedorRepetido( proveedor.getNumeroIdentificacion() )){
            throw new Exception("El proveedor ya se encuentra registrado");
        }else {
            return proveedorRepo.save(proveedor);
        }
    }

    private boolean proveedorRepetido(String identificacion) {
        Proveedor proveedorRegistrado = proveedorRepo.comprobarIdentificacion(identificacion);
        return proveedorRegistrado != null;
    }

    @Override
    public Proveedor actualizarProveedor(Proveedor proveedor) throws Exception {
        Optional<Proveedor> guardado = proveedorRepo.findById(String.valueOf(proveedor.getNumeroIdentificacion()));
        if (guardado.isEmpty()){
            throw new Exception("El proveedor no existe");
        }
        return proveedorRepo.save(proveedor);
    }

    @Override
    public Boolean eliminarProveedor(Proveedor proveedor) throws Exception {
        Optional<Proveedor> guardado = proveedorRepo.findById(String.valueOf(proveedor.getNumeroIdentificacion()));
        if (guardado.isEmpty()){
            throw new Exception("El proveedor no existe");
        }else {
            proveedorRepo.delete(guardado.get());
            return true;
        }
    }

    @Override
    public List<Proveedor> listarProveedores() {
        return proveedorRepo.findAll();
    }

}
