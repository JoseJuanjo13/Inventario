package co.edu.uniquindio.inventario.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class BusquedaBean implements Serializable {

    @Getter @Setter
    private String query;

    public void buscar() {

    }
}
