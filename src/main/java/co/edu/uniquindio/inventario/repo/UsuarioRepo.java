package co.edu.uniquindio.inventario.repo;


import co.edu.uniquindio.inventario.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UsuarioRepo extends JpaRepository<Usuario, String>, Serializable {

    @Query("select u from Usuario u where u.email = :email and u.contrasena = :contrasena")
    Usuario comprobarUsuario(String email, String contrasena);

    @Query("select u from Usuario u where u.email = :email")
    Usuario comprobarEmail(String email);

    @Query("select u from Usuario u where u.cedula = :cedula")
    Usuario comprobarCedula(String cedula);

}
