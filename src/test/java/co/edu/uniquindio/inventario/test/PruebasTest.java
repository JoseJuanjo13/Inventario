package co.edu.uniquindio.inventario.test;

import co.edu.uniquindio.inventario.entidades.*;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class PruebasTest {
    @Autowired
    UsuarioServicio usuarioServicio;

    @Test
    void crearBodega() throws Exception {
        Bodega bodega = new Bodega("bodega", "bod", "direccion", null, "activo");
        Bodega creada = usuarioServicio.crearBodega(bodega);
        assertNotNull(creada);
    }

    @Test
    void actualizarBodega() throws Exception {
        Bodega bodega = usuarioServicio.obtenerBodega(2);
        bodega.setEstado("inactivo");
        Bodega actualizar = usuarioServicio.actualizarBodega(bodega);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarBodega() throws Exception {
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
    void crearUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("jessica"); usuario.setApellido("ospiba"); usuario.setEmail("corrreo@correo.com");
        usuario.setContrasena("123"); usuario.setTelefono("313"); usuario.setCedula("1094");
        Usuario creado = usuarioServicio.crearUsuario(usuario);
        assertNotNull(creado);
    }

    @Test
    void actualizarUsuario() throws Exception {
        Usuario usuario = usuarioServicio.obtenerUsuario("1094973943");
        usuario.setNombre("prueba");
        Usuario actualizar = usuarioServicio.actualizarUsuario(usuario);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarUsuario() throws Exception {
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
    void crearInsumo() throws Exception {
        Insumo insumo = new Insumo();
        insumo.setNombre("insumopru"); insumo.setTipoInsumo("tipo"); insumo.setEstado("activo");
        insumo.setFecha(LocalDate.now()); insumo.setPresentacion("presentacion"); insumo.setUsuarioCreacion("1094");
        insumo.setVidaUtil(2);
        Insumo creado = usuarioServicio.crearInsumo(insumo);
        assertNotNull(creado);
    }

    @Test
    void actualizarInsumo() throws Exception {
        Insumo insumo = usuarioServicio.obtenerInsumo(1);
        insumo.setNombre("prueba");
        Insumo actualizar = usuarioServicio.actualizarInsumo(insumo);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarInsumo() throws Exception {
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
    void crearMedicamento() throws Exception {
        Medicamento medicamento = new Medicamento();
        medicamento.setPrincipioActivo("principioMedi"); medicamento.setConcentracion("concent"); medicamento.setUnidad("unidapru");
        medicamento.setPresentacion("presenMed"); medicamento.setViaAdministracion("presentacionMed"); medicamento.setFecha(LocalDate.now());
        Medicamento creado = usuarioServicio.crearMedicamento(medicamento);
        assertNotNull(creado);
    }

    @Test
    void actualizarMedicamento() throws Exception {
        Medicamento medicamento = usuarioServicio.obtenerMedicamento(1);
        medicamento.setPrincipioActivo("prueba");
        Medicamento actualizar = usuarioServicio.actualizarMedicamento(medicamento);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarMedicamento() throws Exception {
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
    void crearProveedor() throws Exception {
        Proveedor proveedor = new Proveedor();
        proveedor.setNombre("nombreProv"); proveedor.setNumeroIdentificacion("1094973"); proveedor.setRazonSocial("razonPrueba");
        proveedor.setDireccion("carrera prueba"); proveedor.setCorreo("correo@correo.com"); proveedor.setTelefono("313774");
        proveedor.setUsuarioCreacion("10947788");
        Proveedor creado = usuarioServicio.crearProveedor(proveedor);
        assertNotNull(creado);
    }

    @Test
    void actualizarProveedor() throws Exception {
        Proveedor proveedor = usuarioServicio.obtenerProveedor("111222333");
        proveedor.setNombre("prueba");
        Proveedor actualizar = usuarioServicio.actualizarProveedor(proveedor);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarProveedor() throws Exception {
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
    void crearOrdenCompra() throws Exception {
        OrdenCompra ordenCompra = new OrdenCompra();
        ordenCompra.setDetalleOrdenCompras(null); ordenCompra.setFecha(LocalDate.now()); ordenCompra.setNumeroAutorizacion("12345");
        ordenCompra.setTipoMovimiento("positivo"); ordenCompra.setTotal(0.0); ordenCompra.setFechaAutorizacion(LocalDate.now());
        ordenCompra.setUsuarioCreacion("10947788");
        OrdenCompra creado = usuarioServicio.crearOrdenCompra(ordenCompra);
        assertNotNull(creado);
    }

    @Test
    void actualizarOrdenCompra() throws Exception {
        OrdenCompra ordenCompra = usuarioServicio.obtenerOrdenCompra(1);
        ordenCompra.setEstado("inactivo");
        OrdenCompra actualizar = usuarioServicio.actualizarOrdenCompra(ordenCompra);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarOrdenCompra() throws Exception {
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
    void crearDevolucionCompra() throws Exception {
        DevolucionCompra devolucionCompra = new DevolucionCompra();
        devolucionCompra.setDetalleOrdenCompras(null); devolucionCompra.setFecha(LocalDate.now()); devolucionCompra.setNumeroAutorizacion("12345");
        devolucionCompra.setTipoMovimiento("negativo"); devolucionCompra.setFechaAutorizacion(LocalDate.now());
        devolucionCompra.setUsuarioCreacion("10947788");
        DevolucionCompra creado = usuarioServicio.crearDevolucionCompra(devolucionCompra);
        assertNotNull(creado);
    }

    @Test
    void actualizarDevolucionCompra() throws Exception {
        DevolucionCompra devolucionCompra = usuarioServicio.obtenerDevolucionCompra(1);
        devolucionCompra.setEstado("inactivo");
        DevolucionCompra actualizar = usuarioServicio.actualizarDevolucionCompra(devolucionCompra);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarDevolucionCompra() throws Exception {
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
    void crearDetalleOrdenCompra() throws Exception {
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
    void actualizarDetalleOrdenCompra() throws Exception {
        DetalleOrdenCompra detalleOrdenCompra = usuarioServicio.obtenerDetalleOrdenCompra(1);
        detalleOrdenCompra.setTipoActividad("inactivo");
        DetalleOrdenCompra actualizar = usuarioServicio.actualizarOrdenCompra(detalleOrdenCompra);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarDetalleOrdenCompra() throws Exception {
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
    void crearDetalleDevolucionCompra() throws Exception {
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
    void actualizarDetalleDevolucionCompra() throws Exception {
        DetalleDevolucionCompra detalleDevolucionCompra = usuarioServicio.obtenerDetalleDevolucionCompra(1);
        detalleDevolucionCompra.setTipoActividad("inactivo");
        DetalleDevolucionCompra actualizar = usuarioServicio.actualizarDetalleDevolucionCompra(detalleDevolucionCompra);
        assertNotNull(actualizar);
    }

    @Test
    void eliminarDetalleDevolucionCompra() throws Exception {
        DetalleDevolucionCompra detalleDevolucionCompra = usuarioServicio.obtenerDetalleDevolucionCompra(1);
        usuarioServicio.eliminarDetalleDevolucionCompra(detalleDevolucionCompra);
        Exception exception = Assertions.assertThrows(Exception.class, () -> usuarioServicio.eliminarDetalleDevolucionCompra(detalleDevolucionCompra));
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
}
