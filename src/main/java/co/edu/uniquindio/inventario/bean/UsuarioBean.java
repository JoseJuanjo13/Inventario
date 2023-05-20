package co.edu.uniquindio.inventario.bean;

import co.edu.uniquindio.inventario.entidades.Usuario;
import co.edu.uniquindio.inventario.excepciones.UsuarioException;
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
import java.util.ArrayList;
import java.util.List;

@Component
@ViewScoped
public class UsuarioBean implements Serializable {

    @Getter @Setter
    private Usuario usuario;

    @Getter @Setter
    private List<Usuario> usuarios;

    @Getter @Setter
    private List<Usuario> usuariosSeleccionados;

    private boolean editarUsuario;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @Getter @Setter
    private String confirmarContrasena;

    String registroUsuario = "Registro usuario";
    String mensajeBean = "Mensaje Bean";


    @PostConstruct
    public void init() {
        usuario = new Usuario();
        editarUsuario = false;
        usuariosSeleccionados = new ArrayList<>();
        usuarios = usuarioServicio.listarUsuario();
    }

    public void gestionUsuario() {
        try {
            if(!editarUsuario) {
                if(usuario.getContrasena().equals(confirmarContrasena)) {
                    Usuario nuevoUsuario = usuarioServicio.crearUsuario(usuario);
                    usuarios.add(nuevoUsuario);

                    usuario = new Usuario();

                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, registroUsuario, "¡Registro Exitoso!");
                    FacesContext.getCurrentInstance().addMessage(mensajeBean, fm);

                } else {
                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, registroUsuario, "Las Contraseñas no coinciden.");
                    FacesContext.getCurrentInstance().addMessage(mensajeBean, fm);
                }

            } else {
                usuarioServicio.actualizarUsuario(usuario);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión usuario", "¡Se ha actualizado el usuario con éxito!");
                FacesContext.getCurrentInstance().addMessage(mensajeBean, fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, registroUsuario, e.getMessage());
            FacesContext.getCurrentInstance().addMessage(mensajeBean, fm);
        }
    }

    public void eliminarUsuarios() {
        usuariosSeleccionados.forEach(u -> {
            try {
                usuarioServicio.eliminarUsuario(u);
                usuarios.remove(u);
            } catch (Exception e) {
                throw new UsuarioException(e.getMessage());
            }
        });
        usuariosSeleccionados.clear();
    }

    public String getMensajeEliminar() {
        if(usuariosSeleccionados.isEmpty()) {
            return "Eliminar";
        } else {
            return usuariosSeleccionados.size() == 1
                    ? "Eliminar 1 usuario"
                    : "Eliminar " + usuariosSeleccionados.size() + " usuarios";
        }
    }

    public String getTextoDialogo() { return editarUsuario ? "Editar Usuario" : "Registrar Usuario";}

    public void dialogoSeleccionUsuario(Usuario usuarioSeleccionado) {
        if(usuarioSeleccionado != null) {
            this.usuario = usuarioSeleccionado;
            editarUsuario = true;
        } else {
            this.usuario = new Usuario();
            editarUsuario = false;
        }
    }
}
