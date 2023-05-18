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

                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro Usuario", "¡Registro Exitoso!");
                    FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);

                } else {
                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro Usuario", "Las Contraseñas no coinciden.");
                    FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
                }

            } else {
                usuarioServicio.actualizarUsuario(usuario);

                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Gestión usuario", "¡Se ha actualizado el usuario con éxito!");
                FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
            }
        } catch (Exception e) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registro Usuario", e.getMessage());
            FacesContext.getCurrentInstance().addMessage("mensaje_bean", fm);
        }
    }

    public void eliminarUsuarios() {
        usuariosSeleccionados.forEach(u -> {
            try {
                usuarioServicio.eliminarUsuario(u);
                usuarios.remove(u);
            } catch (Exception e) {
                throw new RuntimeException(e);
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
            System.out.print(editarUsuario);
            this.usuario = usuarioSeleccionado;
            editarUsuario = true;
        } else {
            this.usuario = new Usuario();
            editarUsuario = false;
        }
    }
}
