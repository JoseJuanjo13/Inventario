package co.edu.uniquindio.inventario.test;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.entidades.DetalleOrdenCompra;
import co.edu.uniquindio.inventario.entidades.Usuario;
import co.edu.uniquindio.inventario.repo.BodegaRepo;
import co.edu.uniquindio.inventario.repo.DetalleOrdenCompraRepo;
import co.edu.uniquindio.inventario.repo.UsuarioRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PruebasTest {

    @Autowired
    private BodegaRepo bodegaRepo;

    @Autowired
    private DetalleOrdenCompraRepo detalleOrdenCompraRepo;

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Test
    public void registrar(){
        ArrayList<String> tel = new ArrayList<>();
        tel.add("3137708899");
        Bodega bodega = new Bodega("Bodega 1", "Bod1", "Centro", tel, "Activo");
        Bodega guardado = bodegaRepo.save(bodega);
        Assertions.assertEquals("Bod1",guardado.getAbreviacion());
    }

    @Test
    public void registrarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setApellido("cardenas"); usuario.setCedula("1094567");
        usuario.setContrasena("123"); usuario.setEmail("correo@correo.com");
        usuario.setNombre("mario"); usuario.setTelefono("13131");
        Usuario guardado = usuarioRepo.save(usuario);
        Assertions.assertEquals(usuario.getNombre(), guardado.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

    }

    @Test
    public void pruebaConsulta(){
        List<DetalleOrdenCompra> detalles = detalleOrdenCompraRepo.detallesCompra(2);
        for (DetalleOrdenCompra detalle : detalles) {
            System.out.println(detalle);
        }
    }
}
