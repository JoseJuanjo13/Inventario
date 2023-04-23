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
    private final OrdenCompraRepo ordenCompraRepo;
    private final DetalleOrdenCompraRepo detalleOrdenCompraRepo;
    private final DevolucionCompraRepo devolucionCompraRepo;
    private final DetalleDevolucionCompraRepo detalleDevolucionCompraRepo;

    private final TiposIdentificacionRepo tiposIdentificacionRepo;

    public UsuarioServicioImpl(UsuarioRepo usuarioRepo, BodegaRepo bodegaRepo, InsumoRepo insumoRepo,
                               MedicamentoRepo medicamentoRepo, ProveedorRepo proveedorRepo, OrdenCompraRepo ordenCompraRepo,
                               DetalleOrdenCompraRepo detalleOrdenCompraRepo, DevolucionCompraRepo devolucionCompraRepo,
                               DetalleDevolucionCompraRepo detalleDevolucionCompraRepo, TiposIdentificacionRepo tiposIdentificacionRepo) {
        this.usuarioRepo = usuarioRepo;
        this.bodegaRepo = bodegaRepo;
        this.insumoRepo = insumoRepo;
        this.medicamentoRepo = medicamentoRepo;
        this.proveedorRepo = proveedorRepo;
        this.ordenCompraRepo = ordenCompraRepo;
        this.detalleOrdenCompraRepo = detalleOrdenCompraRepo;
        this.devolucionCompraRepo = devolucionCompraRepo;
        this.detalleDevolucionCompraRepo = detalleDevolucionCompraRepo;
        this.tiposIdentificacionRepo = tiposIdentificacionRepo;
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

    @Override
    public OrdenCompra crearOrdenCompra(OrdenCompra ordenCompra) throws Exception {
        return ordenCompraRepo.save(ordenCompra);
    }

    @Override
    public OrdenCompra actualizarOrdenCompra(OrdenCompra ordenCompra) throws Exception {
        Optional<OrdenCompra> guardado = ordenCompraRepo.findById(ordenCompra.getIdCompra());
        if (guardado.isEmpty()){
            throw new Exception("La orden de compra no existe");
        }
        return ordenCompraRepo.save(ordenCompra);
    }

    @Override
    public Boolean eliminarOrdenCompra(OrdenCompra ordenCompra) throws Exception {
        Optional<OrdenCompra> guardado = ordenCompraRepo.findById(ordenCompra.getIdCompra());
        if (guardado.isEmpty()){
            throw new Exception("La orden de compra no existe");
        }else {
            ordenCompraRepo.delete(guardado.get());
            return true;
        }
    }

    @Override
    public List<OrdenCompra> listarOrdenesCompra() {
        return ordenCompraRepo.findAll();
    }

    //Detalle Orden Compra
    @Override
    public DetalleOrdenCompra crearDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) throws Exception {
        return detalleOrdenCompraRepo.save(detalleOrdenCompra);
    }

    @Override
    public DetalleOrdenCompra actualizarOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) throws Exception {
        Optional<DetalleOrdenCompra> guardado = detalleOrdenCompraRepo.findById(detalleOrdenCompra.getIdDetalleOrdenCompra());
        if (guardado.isEmpty()){
            throw new Exception("La orden de compra no existe");
        }
        return detalleOrdenCompraRepo.save(detalleOrdenCompra);
    }

    @Override
    public Boolean eliminarOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) throws Exception {
        Optional<DetalleOrdenCompra> guardado = detalleOrdenCompraRepo.findById(detalleOrdenCompra.getIdDetalleOrdenCompra());
        if (guardado.isEmpty()){
            throw new Exception("La orden de compra no existe");
        }else {
            detalleOrdenCompraRepo.delete(guardado.get());
            return true;
        }
    }

    @Override
    public List<DetalleOrdenCompra> listarDetallesOrdenesCompra() {
        return detalleOrdenCompraRepo.findAll();
    }

    @Override
    public DevolucionCompra crearDevolucionCompra(DevolucionCompra devolucionCompra) throws Exception {
        return devolucionCompraRepo.save(devolucionCompra);
    }

    @Override
    public DevolucionCompra actualizarDevolucionCompra(DevolucionCompra devolucionCompra) throws Exception {
        Optional<DevolucionCompra> guardado = devolucionCompraRepo.findById(devolucionCompra.getIdDevolucionCompra());
        if (guardado.isEmpty()){
            throw new Exception("La devolucion de la compra no existe");
        }
        return devolucionCompraRepo.save(devolucionCompra);
    }

    @Override
    public Boolean eliminarDevolucionCompra(DevolucionCompra devolucionCompra) throws Exception {
        Optional<DevolucionCompra> guardado = devolucionCompraRepo.findById(devolucionCompra.getIdDevolucionCompra());
        if (guardado.isEmpty()){
            throw new Exception("La devolucion de la compra no existe");
        }else {
            devolucionCompraRepo.delete(guardado.get());
            return true;
        }
    }

    @Override
    public List<DevolucionCompra> listarDevolucionesCompra() {
        return devolucionCompraRepo.findAll();
    }

    @Override
    public DetalleDevolucionCompra crearDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra) throws Exception {
        return detalleDevolucionCompraRepo.save(detalleDevolucionCompra);
    }

    @Override
    public DetalleDevolucionCompra actualizarDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra) throws Exception {
        Optional<DetalleDevolucionCompra> guardado = detalleDevolucionCompraRepo.findById(detalleDevolucionCompra.getIdDetalleDevolucionCompra());
        if (guardado.isEmpty()){
            throw new Exception("El detalle de la devolucion de la compra no existe");
        }
        return detalleDevolucionCompraRepo.save(detalleDevolucionCompra);
    }

    @Override
    public Boolean eliminarDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra) throws Exception {
        Optional<DetalleDevolucionCompra> guardado = detalleDevolucionCompraRepo.findById(detalleDevolucionCompra.getIdDetalleDevolucionCompra());
        if (guardado.isEmpty()){
            throw new Exception("El detalle de la devolucion de la compra no existe");
        }else {
            detalleDevolucionCompraRepo.delete(guardado.get());
            return true;
        }
    }

    @Override
    public List<DetalleDevolucionCompra> listarDetallesDevolucionesCompra() {
        return detalleDevolucionCompraRepo.findAll();
    }

    @Override
    public List<TiposIdentificacion> listarTiposIdentificacion() {
        return tiposIdentificacionRepo.findAll();
    }

    @Override
    public TiposIdentificacion obtenerTipoIdentificacion(Integer idIdentificacion) throws Exception {
        if (idIdentificacion == null || idIdentificacion < 0) {
            throw new IllegalArgumentException("El ID de identificación es inválido: " + idIdentificacion);
        }
        return tiposIdentificacionRepo.findById(idIdentificacion)
                .orElseThrow(() -> new Exception("No se encontró el tipo de identificación con el ID: " + idIdentificacion));
    }


}
