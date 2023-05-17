package co.edu.uniquindio.inventario.test;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.entidades.DetalleOrdenCompra;
import co.edu.uniquindio.inventario.repo.BodegaRepo;
import co.edu.uniquindio.inventario.repo.DetalleOrdenCompraRepo;
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

    @Test
    public void registrar(){
        ArrayList<String> tel = new ArrayList<>();
        tel.add("3137708899");
        Bodega bodega = new Bodega("Bodega 1", "Bod1", "Centro", tel, "Activo");
        Bodega guardado = bodegaRepo.save(bodega);
        Assertions.assertEquals(bodega.getNombre(), guardado.getNombre());
    }

    @Test
    //@Sql("classpath:dataset.sql")
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
