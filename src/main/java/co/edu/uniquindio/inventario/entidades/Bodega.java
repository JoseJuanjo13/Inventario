package co.edu.uniquindio.inventario.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Bodega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private Integer idBodega;

    @Length(max = 150)
    @Column(nullable = true)
    private String nombre;

    @Length(max = 150)
    @Column(nullable = true)
    private String abreviacion;

    @Length(max = 150)
    @Column(nullable = true)
    private String direccion;

    @ElementCollection
    @Column
    private List<String> telefono;

    @Length(max = 150)
    @Column(nullable = true)
    private String estado;

    @Length(max = 15)
    @Column(nullable = true)
    private String usuarioCreacion;

    @ToString.Exclude
    @OneToMany(mappedBy = "bodega")
    private List<DevolucionCompra> devolucionCompras;

    @ToString.Exclude
    @OneToMany(mappedBy = "bodega")
    private List<OrdenCompra> ordenCompras;

    public Bodega(String nombre, String abreviacion, String direccion, List<String> telefono, String estado) {
        this.nombre = nombre;
        this.abreviacion = abreviacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
    }

    public Bodega() {

    }
}
