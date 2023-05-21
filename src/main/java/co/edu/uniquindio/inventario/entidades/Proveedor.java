package co.edu.uniquindio.inventario.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Proveedor implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Length(max = 15)
    @Column(nullable = false)
    private String numeroIdentificacion;

    @ManyToOne
    private TiposIdentificacion tipoIdentificacion;

    @Length(max = 100)
    @Column(nullable = true)
    private String nombre;

    @Length(max = 150)
    @Column(nullable = true)
    private String razonSocial;

    @Length(max = 150)
    @Column(nullable = true)
    private String direccion;

    @Length(max = 15)
    @Column(nullable = true)
    private String usuarioCreacion;

    @Length(max = 15)
    @Column(nullable = true)
    private String telefono;

    @Email
    @Length(max = 150)
    @Column(nullable = true)
    private String correo;

    @ToString.Exclude
    @OneToMany(mappedBy = "proveedor")
    private List<OrdenCompra> ordenCompras;

    @ToString.Exclude
    @OneToMany(mappedBy = "bodega")
    private List<OrdenCompra> bodega;

    public Proveedor(){
        // Se implementa para crear un proveedor antes de agregar cierta información.
    }
}
