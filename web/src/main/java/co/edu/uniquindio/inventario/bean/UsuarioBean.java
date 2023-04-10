package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Usuario;
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

@Component
@ViewScoped
public class UsuarioBean implements Serializable {

    @Getter @Setter
    private Usuario usuario;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private String confirmarContrasena;


    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public void registrarUsuario() {
        try {

            if(usuario.getContrasena().equals(confirmarContrasena)) {
                usuarioServicio.crearUsuario(usuario);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Usuario", "¡Registro Exitoso!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            } else {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro Usuario", "Las Contraseñas no coinciden.");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro Usuario", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }

    }
}
