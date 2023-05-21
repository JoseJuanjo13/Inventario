package co.edu.uniquindio.inventario.test;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.entidades.Insumo;
import co.edu.uniquindio.inventario.entidades.Medicamento;
import co.edu.uniquindio.inventario.entidades.Usuario;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
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
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            usuarioServicio.eliminarBodega(bodega);
        });
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
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            usuarioServicio.eliminarUsuario(usuario);
        });
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
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            usuarioServicio.eliminarInsumo(insumo);
        });
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
        Exception exception = Assertions.assertThrows(Exception.class, () -> {
            usuarioServicio.eliminarMedicamento(medicamento);
        });
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
}
