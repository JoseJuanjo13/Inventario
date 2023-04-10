package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Bodega;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Component
@ViewScoped
public class BodegaBean implements Serializable {

    @Getter @Setter
    private Bodega bodega;

    @Getter @Setter
    private List<Bodega> bodegas;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @PostConstruct
    public void init() {
        bodega = new Bodega();
        bodegas = usuarioServicio.listarBodegas();

    }

    public void crearBodega() {
        try {
            usuarioServicio.crearBodega(bodega);

            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión Bodega", "¡Se ha registrado la bodega con éxito!");
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);

        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Gestión Bodega", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }

    }


}
