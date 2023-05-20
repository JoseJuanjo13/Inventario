package co.edu.uniquindio.inventario.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Length(max = 15)
    @Column(nullable = false)
    private String cedula;

    @Length(max = 100)
    @Column(nullable = true)
    private String nombre;

    @Length(max = 100)
    @Column(nullable = true)
    private String apellido;

    @Email
    @Length(max = 200)
    @Column(nullable = true)
    private String email;

    @Length(max = 200)
    @Column(nullable = true)
    private String contrasena;

    @Length(max = 15)
    @Column(nullable = true)
    private String telefono;
    public Usuario() {
        //
    }
}
