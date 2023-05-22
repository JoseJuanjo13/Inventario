package co.edu.uniquindio.inventario.test;

import co.edu.uniquindio.inventario.entidades.*;
import co.edu.uniquindio.inventario.excepciones.*;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class PruebasTest {
    @Autowired
    UsuarioServicio usuarioServicio;

    @Test
    void crearBodega() {
        ArrayList<String> tel = new ArrayList<>();
        tel.add("3134455");
        Bodega bodega = new Bodega("bodega", "bod", "direccion", tel, "activo");
        Bodega creada = usuarioServicio.crearBodega(bodega);
        assertNotNull(creada);
    }

    @Test
    void actualizarBodega() {
        Bodega bodega = usuarioServicio.obtenerBodega(2);
        bodega.setEstado("inactivo");
        Bodega actualizar = usuarioServicio.actualizarBodega(bodega);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarBodega() {
        Bodega bodega = usuarioServicio.obtenerBodega(2);
        usuarioServicio.eliminarBodega(bodega);
        Exception exception = Assertions.assertThrows(Exception.class, () -> usuarioServicio.eliminarBodega(bodega));
        String mensajeEsperado = "La bodega no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void listarBodegas() {
        List<Bodega> bodegas = usuarioServicio.listarBodegas();
        assertNotNull(bodegas);
        assertFalse(bodegas.isEmpty());
    }

    @Test
    void crearUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("jessica"); usuario.setApellido("ospiba"); usuario.setEmail("corrreo@correo.com");
        usuario.setContrasena("123"); usuario.setTelefono("313"); usuario.setCedula("1094");
        Usuario creado = usuarioServicio.crearUsuario(usuario);
        assertNotNull(creado);
    }

    @Test
    void actualizarUsuario() {
        Usuario usuario = usuarioServicio.obtenerUsuario("1094973943");
        usuario.setNombre("prueba");
        Usuario actualizar = usuarioServicio.actualizarUsuario(usuario);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarUsuario() {
        Usuario usuario = usuarioServicio.obtenerUsuario("1094973943");
        usuarioServicio.eliminarUsuario(usuario);
        Exception exception = Assertions.assertThrows(Exception.class, () -> usuarioServicio.eliminarUsuario(usuario));
        String mensajeEsperado = "El usuario no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void listarUsuarios() {
        List<Usuario> usuarios = usuarioServicio.listarUsuario();
        assertNotNull(usuarios);
        assertFalse(usuarios.isEmpty());
    }

    @Test
    void crearInsumo() {
        Insumo insumo = new Insumo();
        insumo.setNombre("insumopru"); insumo.setTipoInsumo("tipo"); insumo.setEstado("activo");
        insumo.setFecha(LocalDate.now()); insumo.setPresentacion("presentacion"); insumo.setUsuarioCreacion("1094");
        insumo.setVidaUtil(2);
        Insumo creado = usuarioServicio.crearInsumo(insumo);
        assertNotNull(creado);
    }

    @Test
    void actualizarInsumo() {
        Insumo insumo = usuarioServicio.obtenerInsumo(1);
        insumo.setNombre("prueba");
        Insumo actualizar = usuarioServicio.actualizarInsumo(insumo);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarInsumo() {
        Insumo insumo = usuarioServicio.obtenerInsumo(1);
        usuarioServicio.eliminarInsumo(insumo);
        Exception exception = Assertions.assertThrows(Exception.class, () -> usuarioServicio.eliminarInsumo(insumo));
        String mensajeEsperado = "El insumo no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void listarInsumos() {
        List<Insumo> insumos = usuarioServicio.listarInsumo();
        assertNotNull(insumos);
        assertFalse(insumos.isEmpty());
    }

    @Test
    void crearMedicamento() {
        Medicamento medicamento = new Medicamento();
        medicamento.setPrincipioActivo("principioMedi"); medicamento.setConcentracion("concent"); medicamento.setUnidad("unidapru");
        medicamento.setPresentacion("presenMed"); medicamento.setViaAdministracion("presentacionMed"); medicamento.setFecha(LocalDate.now());
        Medicamento creado = usuarioServicio.crearMedicamento(medicamento);
        assertNotNull(creado);
    }

    @Test
    void actualizarMedicamento() {
        Medicamento medicamento = usuarioServicio.obtenerMedicamento(1);
        medicamento.setPrincipioActivo("prueba");
        Medicamento actualizar = usuarioServicio.actualizarMedicamento(medicamento);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarMedicamento() {
        Medicamento medicamento = usuarioServicio.obtenerMedicamento(1);
        usuarioServicio.eliminarMedicamento(medicamento);
        Exception exception = Assertions.assertThrows(Exception.class, () -> usuarioServicio.eliminarMedicamento(medicamento));
        String mensajeEsperado = "El medicamento no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void listarMedicamentos() {
        List<Medicamento> medicamentos = usuarioServicio.listarMedicamento();
        assertNotNull(medicamentos);
        assertFalse(medicamentos.isEmpty());
    }

    @Test
    void crearProveedor() {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("nombreProv"); proveedor.setNumeroIdentificacion("1094973"); proveedor.setRazonSocial("razonPrueba");
        proveedor.setDireccion("carrera prueba"); proveedor.setCorreo("correo@correo.com"); proveedor.setTelefono("313774");
        proveedor.setUsuarioCreacion("10947788");
        Proveedor creado = usuarioServicio.crearProveedor(proveedor);
        assertNotNull(creado);
    }

    @Test
    void actualizarProveedor() {
        Proveedor proveedor = usuarioServicio.obtenerProveedor("111222333");
        proveedor.setNombre("prueba");
        Proveedor actualizar = usuarioServicio.actualizarProveedor(proveedor);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarProveedor() {
        Proveedor proveedor = usuarioServicio.obtenerProveedor("111222333");
        usuarioServicio.eliminarProveedor(proveedor);
        Exception exception = Assertions.assertThrows(Exception.class, () -> usuarioServicio.eliminarProveedor(proveedor));
        String mensajeEsperado = "El proveedor no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void listarProveedores() {
        List<Proveedor> proveedores = usuarioServicio.listarProveedores();
        assertNotNull(proveedores);
        assertFalse(proveedores.isEmpty());
    }

    @Test
    void crearOrdenCompra() {
        OrdenCompra ordenCompra = new OrdenCompra();
        ordenCompra.setDetalleOrdenCompras(null); ordenCompra.setFecha(LocalDate.now()); ordenCompra.setNumeroAutorizacion("12345");
        ordenCompra.setTipoMovimiento("positivo"); ordenCompra.setTotal(0.0); ordenCompra.setFechaAutorizacion(LocalDate.now());
        ordenCompra.setUsuarioCreacion("10947788");
        OrdenCompra creado = usuarioServicio.crearOrdenCompra(ordenCompra);
        assertNotNull(creado);
    }

    @Test
    void actualizarOrdenCompra() {
        OrdenCompra ordenCompra = usuarioServicio.obtenerOrdenCompra(1);
        ordenCompra.setEstado("inactivo");
        OrdenCompra actualizar = usuarioServicio.actualizarOrdenCompra(ordenCompra);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarOrdenCompra() {
        OrdenCompra ordenCompra = usuarioServicio.obtenerOrdenCompra(1);
        usuarioServicio.eliminarOrdenCompra(ordenCompra);
        Exception exception = Assertions.assertThrows(Exception.class, () -> usuarioServicio.eliminarOrdenCompra(ordenCompra));
        String mensajeEsperado = "La orden de compra no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void listarOrdenesCompra() {
        List<OrdenCompra> ordenCompras = usuarioServicio.listarOrdenesCompra();
        assertNotNull(ordenCompras);
        assertFalse(ordenCompras.isEmpty());
    }

    @Test
    void crearDevolucionCompra() {
        DevolucionCompra devolucionCompra = new DevolucionCompra();
        devolucionCompra.setDetalleOrdenCompras(null); devolucionCompra.setFecha(LocalDate.now()); devolucionCompra.setNumeroAutorizacion("12345");
        devolucionCompra.setTipoMovimiento("negativo"); devolucionCompra.setFechaAutorizacion(LocalDate.now());
        devolucionCompra.setUsuarioCreacion("10947788");
        DevolucionCompra creado = usuarioServicio.crearDevolucionCompra(devolucionCompra);
        assertNotNull(creado);
    }

    @Test
    void actualizarDevolucionCompra() {
        DevolucionCompra devolucionCompra = usuarioServicio.obtenerDevolucionCompra(1);
        devolucionCompra.setEstado("inactivo");
        DevolucionCompra actualizar = usuarioServicio.actualizarDevolucionCompra(devolucionCompra);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarDevolucionCompra() {
        DevolucionCompra devolucionCompra = usuarioServicio.obtenerDevolucionCompra(1);
        usuarioServicio.eliminarDevolucionCompra(devolucionCompra);
        Exception exception = Assertions.assertThrows(Exception.class, () -> usuarioServicio.eliminarDevolucionCompra(devolucionCompra));
        String mensajeEsperado = "La devolucion de la compra no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void listarDevolucionesCompra() {
        List<DevolucionCompra> devolucionCompras = usuarioServicio.listarDevolucionesCompra();
        assertNotNull(devolucionCompras);
        assertFalse(devolucionCompras.isEmpty());
    }

    @Test
    void crearDetalleOrdenCompra() {
        Medicamento medicamento = usuarioServicio.obtenerMedicamento(1);
        OrdenCompra ordenCompra = usuarioServicio.obtenerOrdenCompra(1);
        DetalleOrdenCompra detalleOrdenCompra = new DetalleOrdenCompra();
        detalleOrdenCompra.setOrdenCompra(ordenCompra); detalleOrdenCompra.setMedicamento(medicamento);
        detalleOrdenCompra.setTipoActividad("nuevo"); detalleOrdenCompra.setCantidadSolicitada(1);
        detalleOrdenCompra.setValorUnitario(0.0); detalleOrdenCompra.setTotal(0.0);
        DetalleOrdenCompra creado = usuarioServicio.crearDetalleOrdenCompra(detalleOrdenCompra);
        assertNotNull(creado);
    }

    @Test
    void actualizarDetalleOrdenCompra() {
        DetalleOrdenCompra detalleOrdenCompra = usuarioServicio.obtenerDetalleOrdenCompra(1);
        detalleOrdenCompra.setTipoActividad("inactivo");
        DetalleOrdenCompra actualizar = usuarioServicio.actualizarOrdenCompra(detalleOrdenCompra);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarDetalleOrdenCompra() {
        DetalleOrdenCompra detalleOrdenCompra = usuarioServicio.obtenerDetalleOrdenCompra(1);
        usuarioServicio.eliminarOrdenCompra(detalleOrdenCompra);
        Exception exception = Assertions.assertThrows(Exception.class, () -> usuarioServicio.eliminarOrdenCompra(detalleOrdenCompra));
        String mensajeEsperado = "El detalle de la orden de compra no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void listarDetallesOrdenCompra() {
        List<DetalleOrdenCompra> detalleOrdenCompras = usuarioServicio.listarDetallesOrdenesCompra(1);
        assertNotNull(detalleOrdenCompras);
        assertFalse(detalleOrdenCompras.isEmpty());
    }

    @Test
    void crearDetalleDevolucionCompra() {
        Medicamento medicamento = usuarioServicio.obtenerMedicamento(1);
        DevolucionCompra devolucionCompra = usuarioServicio.obtenerDevolucionCompra(1);
        DetalleDevolucionCompra detalleDevolucionCompra = new DetalleDevolucionCompra();
        detalleDevolucionCompra.setDevolucionCompra(devolucionCompra); detalleDevolucionCompra.setMedicamento(medicamento);
        detalleDevolucionCompra.setCantidad(2); detalleDevolucionCompra.setLote("lote");
        detalleDevolucionCompra.setValorUnitario(0.0); detalleDevolucionCompra.setTotal(0.0);
        DetalleDevolucionCompra creado = usuarioServicio.crearDetalleDevolucionCompra(detalleDevolucionCompra);
        assertNotNull(creado);
    }

    @Test
    void actualizarDetalleDevolucionCompra() {
        DetalleDevolucionCompra detalleDevolucionCompra = usuarioServicio.obtenerDetalleDevolucionCompra(1);
        detalleDevolucionCompra.setTipoActividad("inactivo");
        DetalleDevolucionCompra actualizar = usuarioServicio.actualizarDetalleDevolucionCompra(detalleDevolucionCompra);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarDetalleDevolucionCompra() {
        DetalleDevolucionCompra detalleDevolucionCompra = usuarioServicio.obtenerDetalleDevolucionCompra(1);
        usuarioServicio.eliminarDetalleDevolucionCompra(detalleDevolucionCompra);
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.eliminarDetalleDevolucionCompra(detalleDevolucionCompra));
        String mensajeEsperado = "El detalle de la devolucion de la compra no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void listarDetallesDevolucionCompra() {
        List<DetalleDevolucionCompra> detalleDevolucionCompras = usuarioServicio.listarDetallesDevolucionesCompra(1);
        assertNotNull(detalleDevolucionCompras);
        assertFalse(detalleDevolucionCompras.isEmpty());
    }

    @Test
    void obtenerTipoIdentificacion() {
        TiposIdentificacion tiposIdentificacion = usuarioServicio.obtenerTipoIdentificacion(1);
        assertNotNull(tiposIdentificacion);
    }

    @Test
    void obtenerBodega() {
        Bodega bodega = usuarioServicio.obtenerBodega(2);
        assertNotNull(bodega);
    }

    @Test
    void obtenerUsuario() {
        Usuario usuario = usuarioServicio.obtenerUsuario("1094973943");
        assertNotNull(usuario);
    }

    @Test
    void obtenerInsumo() {
        Insumo insumo = usuarioServicio.obtenerInsumo(1);
        assertNotNull(insumo);
    }

    @Test
    void obtenerMedicamento() {
        Medicamento medicamento = usuarioServicio.obtenerMedicamento(1);
        assertNotNull(medicamento);
    }

    @Test
    void obtenerProveedor() {
        Proveedor proveedor = usuarioServicio.obtenerProveedor("111222333");
        assertNotNull(proveedor);
    }

    @Test
    void obtenerOrdenCompra() {
        OrdenCompra ordenCompra = usuarioServicio.obtenerOrdenCompra(1);
        assertNotNull(ordenCompra);
    }

    @Test
    void obtenerDevolucionCompra() {
        DevolucionCompra devolucionCompra = usuarioServicio.obtenerDevolucionCompra(1);
        assertNotNull(devolucionCompra);
    }

    @Test
    void obtenerDetalleOrdenCompra() {
        DetalleOrdenCompra detalleOrdenCompra = usuarioServicio.obtenerDetalleOrdenCompra(1);
        assertNotNull(detalleOrdenCompra);
    }

    @Test
    void obtenerDetalleDevolucionCompra() {
        DetalleDevolucionCompra detalleDevolucionCompra = usuarioServicio.obtenerDetalleDevolucionCompra(1);
        assertNotNull(detalleDevolucionCompra);
    }

    @Test
    void bodegaBeanSeleccionada() {
        Bodega bodega = usuarioServicio.obtenerBodega(2);
        List<Bodega> bodegasSeleccionadas = new ArrayList<>();
        bodegasSeleccionadas.add(bodega);
        assertNotNull(bodegasSeleccionadas);

        List<Bodega> bodegas = usuarioServicio.listarBodegas();
        assertNotNull(bodegas);
    }

    @Test
    void login() {
        Usuario usuario = usuarioServicio.login("juan@hotmail.com","123");
        assertNotNull(usuario);
    }

    @Test
    void bodegaNoRegistradaException() {
        String mensaje = "La bodega no está registrada";
        BodegaNoRegistradaException exception = new BodegaNoRegistradaException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void converterException() {
        String mensaje = "La bodega no está registrada";
        ConverterException exception = new ConverterException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void detalleCompraException() {
        String mensaje = "Mensaje prueba";
        DetalleCompraException exception = new DetalleCompraException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void detalleDevolucionException() {
        String mensaje = "Mensaje prueba";
        DetalleDevolucionException exception = new DetalleDevolucionException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void devolucionCompraException() {
        String mensaje = "Mensaje prueba";
        DevolucionCompraException exception = new DevolucionCompraException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void eliminarBodegaException() {
        String mensaje = "Mensaje prueba";
        EliminarBodegaException exception = new EliminarBodegaException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void eliminarDetalleCompraException() {
        String mensaje = "Mensaje prueba";
        EliminarDetalleCompraException exception = new EliminarDetalleCompraException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void eliminarDetalleDevolucionException() {
        String mensaje = "Mensaje prueba";
        EliminarDetalleDevolucionException exception = new EliminarDetalleDevolucionException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void insumoException() {
        String mensaje = "Mensaje prueba";
        InsumoException exception = new InsumoException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void medicamentoException() {
        String mensaje = "Mensaje prueba";
        MedicamentoException exception = new MedicamentoException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void ordenCompraException() {
        String mensaje = "Mensaje prueba";
        OrdenCompraException exception = new OrdenCompraException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void proveedorException() {
        String mensaje = "Mensaje prueba";
        ProveedorException exception = new ProveedorException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void proveedorNoRegistradoException() {
        String mensaje = "Mensaje prueba";
        ProveedorNoRegistradoException exception = new ProveedorNoRegistradoException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void usuarioException() {
        String mensaje = "Mensaje prueba";
        UsuarioException exception = new UsuarioException(mensaje);
        assertEquals(mensaje, exception.getMessage());
    }

    @Test
    void loginFailed(){
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.login("juan@hotmail.com","6969"));
        String mensajeEsperado = "El correo o la contraseña incorrectos";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void crearUsuarioFailed(){
        Usuario usuario = usuarioServicio.obtenerUsuario("1094973943");
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.crearUsuario(usuario));
        String mensajeEsperado = "El correo o la cédula se encuentran registrados";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void actualizarUsuarioFailed(){
        Usuario usuario = new Usuario();
        usuario.setNombre("9"); usuario.setApellido("9"); usuario.setEmail("9");
        usuario.setContrasena("9"); usuario.setTelefono("9"); usuario.setCedula("9");

        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.actualizarUsuario(usuario));
        String mensajeEsperado = "El usuario no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void crearInsumoFailed(){
        Insumo insumo = usuarioServicio.obtenerInsumo(1);
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.crearInsumo(insumo));
        String mensajeEsperado = "El nombre ya esta registrado";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void actualizarInsumoFailed(){
        Insumo insumo = new Insumo();
        insumo.setNombre("9"); insumo.setTipoInsumo("9"); insumo.setEstado("9");
        insumo.setFecha(LocalDate.now()); insumo.setPresentacion("9"); insumo.setUsuarioCreacion("9");
        insumo.setVidaUtil(9); insumo.setIdInsumo(9999);

        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.actualizarInsumo(insumo));
        String mensajeEsperado = "El insumo no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void crearMedicamentoFailed(){
        Medicamento medicamento = usuarioServicio.obtenerMedicamento(1);
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.crearMedicamento(medicamento));
        String mensajeEsperado = "El nombre ya esta registrado";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void actualizarMedicamentoFailed(){
        Medicamento medicamento = new Medicamento();
        medicamento.setPrincipioActivo("9"); medicamento.setConcentracion("9"); medicamento.setUnidad("9");
        medicamento.setPresentacion("9"); medicamento.setViaAdministracion("9"); medicamento.setFecha(LocalDate.now());
        medicamento.setIdMedicamento(9999);

        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.actualizarMedicamento(medicamento));
        String mensajeEsperado = "El medicamento no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void crearBodegaFailed(){
        Bodega bodega = usuarioServicio.obtenerBodega(2);
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.crearBodega(bodega));
        String mensajeEsperado = "El nombre o la abreviacion ya esta registrado";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void actualizarBodegaFailed(){
        ArrayList<String> tel = new ArrayList<>();
        tel.add("9");
        Bodega bodega = new Bodega();
        bodega.setNombre("9"); bodega.setDireccion("9"); bodega.setTelefono(tel);
        bodega.setEstado("9"); bodega.setUsuarioCreacion("9"); bodega.setIdBodega(9999);

        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.actualizarBodega(bodega));
        String mensajeEsperado = "La bodega no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void crearProveedorFailed(){
        Proveedor proveedor = usuarioServicio.obtenerProveedor("111222333");
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.crearProveedor(proveedor));
        String mensajeEsperado = "El proveedor ya se encuentra registrado";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void actualizarProveedorFailed(){
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("9"); proveedor.setNumeroIdentificacion("9"); proveedor.setRazonSocial("9");
        proveedor.setDireccion("9"); proveedor.setCorreo("9"); proveedor.setTelefono("9");
        proveedor.setUsuarioCreacion("9");

        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.actualizarProveedor(proveedor));
        String mensajeEsperado = "El proveedor no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void actualizarActualizarOrdenCompraFailed(){
        OrdenCompra ordenCompra = new OrdenCompra();
        ordenCompra.setDetalleOrdenCompras(null); ordenCompra.setFecha(LocalDate.now()); ordenCompra.setNumeroAutorizacion("9");
        ordenCompra.setTipoMovimiento("9"); ordenCompra.setTotal(0.0); ordenCompra.setFechaAutorizacion(LocalDate.now());
        ordenCompra.setUsuarioCreacion("9"); ordenCompra.setIdCompra(99999);

        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.actualizarOrdenCompra(ordenCompra));
        String mensajeEsperado = "La orden de compra no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void listarTiposIdentificacion(){
        List<TiposIdentificacion> tiposIdentificacions = usuarioServicio.listarTiposIdentificacion();
        assertNotNull(tiposIdentificacions);
        assertFalse(tiposIdentificacions.isEmpty());
    }

    @Test
    void obtenerDetalleDevolucionCompraFailed(){
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.obtenerDetalleDevolucionCompra(99999));
        String mensajeEsperado = "El detalle de la devolucion de compra no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void obtenerDetalleOrdenCompraFailed(){
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.obtenerDetalleOrdenCompra(99999));
        String mensajeEsperado = "El detalle de la orden de compra no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void obtenerDevolucionCompraFailed(){
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.obtenerDevolucionCompra(99999));
        String mensajeEsperado = "La devolucion de compra no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void obtenerOrdenCompraFailed(){
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.obtenerOrdenCompra(99999));
        String mensajeEsperado = "La orden de compra no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }

    @Test
    void obtenerProveedorFailed(){
        Exception exception = Assertions.assertThrows(UsuarioServicioException.class, () -> usuarioServicio.obtenerProveedor("9999999999"));
        String mensajeEsperado = "El proveedor no existe";
        String mensajeObtenido = exception.getMessage();
        Assertions.assertEquals(mensajeEsperado, mensajeObtenido);
    }
}
