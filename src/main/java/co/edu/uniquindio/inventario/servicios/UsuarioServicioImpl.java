package co.edu.uniquindio.inventario.servicios;

import co.edu.uniquindio.inventario.entidades.*;
import co.edu.uniquindio.inventario.excepciones.UsuarioServicioException;
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

    private static final String USUARIO_NO_EXISTE = "El usuario no existe";
    private static final String ORDEN_COMPRA_NO_EXISTE = "La orden de compra no existe";
    private static final String BODEGA_NO_EXISTE = "La bodega no existe";
    private static final String INSUMO_NO_EXISTE = "El insumo no existe";
    private static final String MEDICAMENTO_NO_EXISTE = "El medicamento no existe";
    private static final String PROVEEDOR_NO_EXISTE = "El proveedor no existe";


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
    public Usuario login(String email, String contrasena) {
        Usuario usuario = usuarioRepo.comprobarUsuario(email, contrasena);
        if (usuario == null){
            throw new UsuarioServicioException("El correo o la contraseña incorrectos");
        }
        return usuario;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        if(esRepetido(usuario.getEmail(), usuario.getCedula())){
            throw new UsuarioServicioException("El correo o la cédula se encuentran registrados");
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
    public Usuario actualizarUsuario(Usuario usuario) {
        Optional<Usuario> guardado = usuarioRepo.findById(usuario.getCedula());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(USUARIO_NO_EXISTE);
        }
        return usuarioRepo.save(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        Optional<Usuario> guardado = usuarioRepo.findById(usuario.getCedula());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(USUARIO_NO_EXISTE);
        }else {
            usuarioRepo.delete(guardado.get());
        }
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepo.findAll();
    }

    @Override
    public Bodega crearBodega(Bodega bodega) {
        if(esRepetidoBodega(bodega.getNombre(), bodega.getAbreviacion())){
            throw new UsuarioServicioException("El nombre o la abreviacion ya esta registrado");
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
    public Bodega actualizarBodega(Bodega bodega) {
        Optional<Bodega> guardado = bodegaRepo.findById(bodega.getIdBodega());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(BODEGA_NO_EXISTE);
        }
        return bodegaRepo.save(bodega);
    }

    @Override
    public void eliminarBodega(Bodega bodega) {
        Optional<Bodega> guardado = bodegaRepo.findById(bodega.getIdBodega());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(BODEGA_NO_EXISTE);
        }else {
            bodegaRepo.delete(guardado.get());
        }
    }

    @Override
    public List<Bodega> listarBodegas() {
        return bodegaRepo.findAll();
    }

    @Override
    public Insumo crearInsumo(Insumo insumo) {
        if(esRepetidoInsumo(insumo.getNombre())){
            throw new UsuarioServicioException("El nombre ya esta registrado");
        }else {
            return insumoRepo.save(insumo);
        }
    }

    private boolean esRepetidoInsumo(String nombre) {
        Insumo nombreRegistrado = insumoRepo.comprobarNombre(nombre);
        return nombreRegistrado != null;
    }

    @Override
    public Insumo actualizarInsumo(Insumo insumo) {
        Optional<Insumo> guardado = insumoRepo.findById(insumo.getIdInsumo());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(INSUMO_NO_EXISTE);
        }
        return insumoRepo.save(insumo);
    }

    @Override
    public void eliminarInsumo(Insumo insumo) {
        Optional<Insumo> guardado = insumoRepo.findById(insumo.getIdInsumo());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(INSUMO_NO_EXISTE);
        }else {
            insumoRepo.delete(guardado.get());
        }
    }

    @Override
    public List<Insumo> listarInsumo() {
        return insumoRepo.findAll();
    }

    @Override
    public Medicamento crearMedicamento(Medicamento medicamento) {
        if(esRepetidoMedicamento(medicamento.getPrincipioActivo())){
            throw new UsuarioServicioException("El nombre ya esta registrado");
        }else {
            return medicamentoRepo.save(medicamento);
        }
    }

    private boolean esRepetidoMedicamento(String principioActivo) {
        Medicamento princioActivoRegistrado = medicamentoRepo.comprobarPrincipioA(principioActivo);
        return princioActivoRegistrado != null;
    }

    @Override
    public Medicamento actualizarMedicamento(Medicamento medicamento) {
        Optional<Medicamento> guardado = medicamentoRepo.findById(medicamento.getIdMedicamento());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(MEDICAMENTO_NO_EXISTE);
        }
        return medicamentoRepo.save(medicamento);
    }

    @Override
    public void eliminarMedicamento(Medicamento medicamento) {
        Optional<Medicamento> guardado = medicamentoRepo.findById(medicamento.getIdMedicamento());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(MEDICAMENTO_NO_EXISTE);
        }else {
            medicamentoRepo.delete(guardado.get());
        }
    }

    @Override
    public List<Medicamento> listarMedicamento() {
        return medicamentoRepo.findAll();
    }


    @Override
    public Proveedor crearProveedor(Proveedor proveedor) {
        if(proveedorRepetido( proveedor.getNumeroIdentificacion() )){
            throw new UsuarioServicioException("El proveedor ya se encuentra registrado");
        }else {
            return proveedorRepo.save(proveedor);
        }
    }

    private boolean proveedorRepetido(String identificacion) {
        Proveedor proveedorRegistrado = proveedorRepo.comprobarIdentificacion(identificacion);
        return proveedorRegistrado != null;
    }

    @Override
    public Proveedor actualizarProveedor(Proveedor proveedor) {
        Optional<Proveedor> guardado = proveedorRepo.findById(String.valueOf(proveedor.getNumeroIdentificacion()));
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(PROVEEDOR_NO_EXISTE);
        }
        return proveedorRepo.save(proveedor);
    }

    @Override
    public void eliminarProveedor(Proveedor proveedor) {
        Optional<Proveedor> guardado = proveedorRepo.findById(String.valueOf(proveedor.getNumeroIdentificacion()));
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(PROVEEDOR_NO_EXISTE);
        }else {
            proveedorRepo.delete(guardado.get());
        }
    }

    @Override
    public List<Proveedor> listarProveedores() {
        return proveedorRepo.findAll();
    }

    @Override
    public OrdenCompra crearOrdenCompra(OrdenCompra ordenCompra) {
        return ordenCompraRepo.save(ordenCompra);
    }

    @Override
    public OrdenCompra actualizarOrdenCompra(OrdenCompra ordenCompra){
        Optional<OrdenCompra> guardado = ordenCompraRepo.findById(ordenCompra.getIdCompra());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(ORDEN_COMPRA_NO_EXISTE);
        }
        return ordenCompraRepo.save(ordenCompra);
    }

    @Override
    public void eliminarOrdenCompra(OrdenCompra ordenCompra) {
        Optional<OrdenCompra> guardado = ordenCompraRepo.findById(ordenCompra.getIdCompra());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(ORDEN_COMPRA_NO_EXISTE);
        }else {
            ordenCompraRepo.delete(guardado.get());
        }
    }

    @Override
    public List<OrdenCompra> listarOrdenesCompra() {
        return ordenCompraRepo.findAll();
    }

    //Detalle Orden Compra
    @Override
    public DetalleOrdenCompra crearDetalleOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) {
        return detalleOrdenCompraRepo.save(detalleOrdenCompra);
    }

    @Override
    public DetalleOrdenCompra actualizarOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) {
        Optional<DetalleOrdenCompra> guardado = detalleOrdenCompraRepo.findById(detalleOrdenCompra.getIdDetalleOrdenCompra());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException(ORDEN_COMPRA_NO_EXISTE);
        }
        return detalleOrdenCompraRepo.save(detalleOrdenCompra);
    }

    @Override
    public void eliminarOrdenCompra(DetalleOrdenCompra detalleOrdenCompra) {
        Optional<DetalleOrdenCompra> guardado = detalleOrdenCompraRepo.findById(detalleOrdenCompra.getIdDetalleOrdenCompra());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException("El detalle de la orden de compra no existe");
        }else {
            detalleOrdenCompraRepo.delete(guardado.get());
        }
    }

    @Override
    public List<DetalleOrdenCompra> listarDetallesOrdenesCompra(Integer idOrdenCompra) {
        if (idOrdenCompra == null) {
            throw new UsuarioServicioException("El id de la orden de compra no puede ser nulo");
        }
        return detalleOrdenCompraRepo.detallesCompra(idOrdenCompra);
    }

    @Override
    public DevolucionCompra crearDevolucionCompra(DevolucionCompra devolucionCompra) {
        return devolucionCompraRepo.save(devolucionCompra);
    }

    @Override
    public DevolucionCompra actualizarDevolucionCompra(DevolucionCompra devolucionCompra) {
        Optional<DevolucionCompra> guardado = devolucionCompraRepo.findById(devolucionCompra.getIdDevolucionCompra());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException("La devolucion de la compra no existe");
        }
        return devolucionCompraRepo.save(devolucionCompra);
    }

    @Override
    public void eliminarDevolucionCompra(DevolucionCompra devolucionCompra) {
        Optional<DevolucionCompra> guardado = devolucionCompraRepo.findById(devolucionCompra.getIdDevolucionCompra());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException("La devolucion de la compra no existe");
        }else {
            devolucionCompraRepo.delete(guardado.get());
        }
    }

    @Override
    public List<DevolucionCompra> listarDevolucionesCompra() {
        return devolucionCompraRepo.findAll();
    }

    @Override
    public DetalleDevolucionCompra crearDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra) {
        return detalleDevolucionCompraRepo.save(detalleDevolucionCompra);
    }

    @Override
    public DetalleDevolucionCompra actualizarDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra) {
        Optional<DetalleDevolucionCompra> guardado = detalleDevolucionCompraRepo.findById(detalleDevolucionCompra.getIdDetalleDevolucionCompra());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException("El detalle de la devolucion de la compra no existe");
        }
        return detalleDevolucionCompraRepo.save(detalleDevolucionCompra);
    }

    @Override
    public void eliminarDetalleDevolucionCompra(DetalleDevolucionCompra detalleDevolucionCompra) {
        Optional<DetalleDevolucionCompra> guardado = detalleDevolucionCompraRepo.findById(detalleDevolucionCompra.getIdDetalleDevolucionCompra());
        if (guardado.isEmpty()){
            throw new UsuarioServicioException("El detalle de la devolucion de la compra no existe");
        }else {
            detalleDevolucionCompraRepo.delete(guardado.get());
        }
    }

    @Override
    public List<DetalleDevolucionCompra> listarDetallesDevolucionesCompra(Integer idDevolucionCompra) {
        if (idDevolucionCompra == null) {
            throw new UsuarioServicioException("El id de la devolucion de compra no puede ser nulo");
        }
        return detalleDevolucionCompraRepo.detallesDevolucion(idDevolucionCompra);
    }

    @Override
    public List<TiposIdentificacion> listarTiposIdentificacion() {
        return tiposIdentificacionRepo.findAll();
    }

    @Override
    public TiposIdentificacion obtenerTipoIdentificacion(Integer idIdentificacion) {
        if (idIdentificacion == null || idIdentificacion < 0) {
            throw new UsuarioServicioException("El ID de identificación es inválido: " + idIdentificacion);
        }
        return tiposIdentificacionRepo.findById(idIdentificacion)
                .orElseThrow(() -> new UsuarioServicioException("No se encontró el tipo de identificación con el ID: " + idIdentificacion));
    }

    @Override
    public Bodega obtenerBodega(Integer id) {
        Optional<Bodega> guardado = bodegaRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new UsuarioServicioException(BODEGA_NO_EXISTE);
        }
        return guardado.get();
    }

    @Override
    public Usuario obtenerUsuario(String id) {
        Optional<Usuario> guardado = usuarioRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new UsuarioServicioException(USUARIO_NO_EXISTE);
        }
        return guardado.get();
    }

    @Override
    public Insumo obtenerInsumo(Integer id) {
        Optional<Insumo> guardado = insumoRepo.findById(id);

        if (guardado.isEmpty()) {
            throw new UsuarioServicioException(INSUMO_NO_EXISTE);
        }
        return guardado.get();
    }

    @Override
    public Medicamento obtenerMedicamento(Integer id) {
        Optional<Medicamento> guardado = medicamentoRepo.findById(id);
        if (guardado.isEmpty()) {
            throw new UsuarioServicioException(MEDICAMENTO_NO_EXISTE);
        }
        return guardado.get();
    }

    @Override
    public Proveedor obtenerProveedor(String id) {
        Optional<Proveedor> guardado = proveedorRepo.findById(id);
        if (guardado.isEmpty()) {
            throw new UsuarioServicioException(PROVEEDOR_NO_EXISTE);
        }
        return guardado.get();
    }

    @Override
    public OrdenCompra obtenerOrdenCompra(Integer id) {
        Optional<OrdenCompra> guardado = ordenCompraRepo.findById(id);
        if (guardado.isEmpty()) {
            throw new UsuarioServicioException(ORDEN_COMPRA_NO_EXISTE);
        }
        return guardado.get();
    }

    @Override
    public DevolucionCompra obtenerDevolucionCompra(Integer id) {
        Optional<DevolucionCompra> guardado = devolucionCompraRepo.findById(id);
        if (guardado.isEmpty()) {
            throw new UsuarioServicioException("La devolucion de compra no existe");
        }
        return guardado.get();
    }

    @Override
    public DetalleOrdenCompra obtenerDetalleOrdenCompra(Integer id) {
        Optional<DetalleOrdenCompra> guardado = detalleOrdenCompraRepo.findById(id);
        if (guardado.isEmpty()) {
            throw new UsuarioServicioException("El detalle de la orden de compra no existe");
        }
        return guardado.get();
    }

    @Override
    public DetalleDevolucionCompra obtenerDetalleDevolucionCompra(Integer id) {
        Optional<DetalleDevolucionCompra> guardado = detalleDevolucionCompraRepo.findById(id);
        if (guardado.isEmpty()) {
            throw new UsuarioServicioException("El detalle de la devolucion de compra no existe");
        }
        return guardado.get();
    }


}
