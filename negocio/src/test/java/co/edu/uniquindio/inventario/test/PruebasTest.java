package co.edu.uniquindio.inventario.test;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.repo.BodegaRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PruebasTest {

    @Autowired
    private BodegaRepo bodegaRepo;

    @Test
    public void registrar(){
        ArrayList<String> tel = new ArrayList<>();
        tel.add("3137708899");
        Bodega bodega = new Bodega("Bodega 1", "Bod1", "Centro", tel);
        Bodega guardado = bodegaRepo.save(bodega);
        Assertions.assertEquals(bodega.getNombre(), guardado.getNombre());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

    }

    public void actualizar(){

    }
}
