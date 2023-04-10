package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Insumo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

@Component
@ViewScoped
public class InsumoBean implements Serializable {

    @Getter @Setter
    private Insumo insumo;

    @PostConstruct
    public void init() { insumo = new Insumo(); }


}
