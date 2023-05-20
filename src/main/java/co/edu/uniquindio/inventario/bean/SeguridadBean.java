package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Usuario;
import co.edu.uniquindio.inventario.servicios.UsuarioServicio;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;

@Component
@Scope("session")
public class SeguridadBean implements Serializable {

    @Getter @Setter
    private boolean autenticado;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String password;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private Usuario usuario;

    @PostConstruct
    public void inicializar(){
        autenticado = false;
    }

    public String iniciarSesion(){
        if (!email.isEmpty() && !password.isEmpty()){
            try {
                usuario = usuarioServicio.login(email, password);
                autenticado = true;
                return "/index?faces-redirect=true";
            } catch (Exception e) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", e.getMessage());
                FacesContext.getCurrentInstance().addMessage("login-bean", fm);
            }
        }else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Alerta", "El correo y la contraseña son requeridos");
            FacesContext.getCurrentInstance().addMessage("login-bean", fm);
        }
        return null;
    }

    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index?faces-redirect=true";
    }


}
