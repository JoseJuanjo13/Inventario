package co.edu.uniquindio.inventario.test;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
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
}
