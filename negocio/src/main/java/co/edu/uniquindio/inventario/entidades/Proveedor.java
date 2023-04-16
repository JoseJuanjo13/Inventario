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
public class Proveedor implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String numeroIdentificacion;

    @Column(nullable = true)
    private String tipoIdentificacion;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = true)
    private String razonSocial;

    @Column(nullable = true)
    private String direccion;

    @Column(nullable = true)
    private String usuarioCreacion;

    @ElementCollection
    @Column(nullable = true)
    private List<String> telefono;

    @Column(nullable = true)
    private String correo;

    @ToString.Exclude
    @OneToMany(mappedBy = "proveedor")
    private List<OrdenCompra> ordenCompras;

    @ToString.Exclude
    @OneToMany(mappedBy = "bodega")
    private List<OrdenCompra> bodega;
}
