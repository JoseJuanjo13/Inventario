package co.edu.uniquindio.inventario.test;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.repo.BodegaRepo;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PruebasTest {

    @Autowired
    private BodegaRepo bodegaRepo;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Test
    void registrar(){
        ArrayList<String> tel = new ArrayList<>();
        tel.add("3137708899");
        Bodega bodega = new Bodega("Bodega 1", "Bod1", "Centro", tel, "Activo");
        Bodega guardado = bodegaRepo.save(bodega);
        Assertions.assertEquals(bodega.getNombre(), guardado.getNombre());
    }

    @Test
    void crearBodega(){

        try {
            ArrayList<String> tel = new ArrayList<>();
            tel.add("3137708899");
            Bodega bodega = new Bodega("Bodega 1", "Bod1", "Centro", tel, "Activo");
            Bodega guardo = usuarioServicio.crearBodega(bodega);
            Assertions.assertEquals(bodega.getNombre(), guardo.getNombre());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}
