package co.edu.uniquindio.inventario.entidades;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String cedula;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = true)
    private String apellido;

    @Column(nullable = true)
    private String email;

    @Column(nullable = true)
    private String contrasena;

    @ElementCollection
    @Column(nullable = true)
    private List<String> telefono;

    public Usuario() {

    }
}
