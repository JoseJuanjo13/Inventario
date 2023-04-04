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
public class Bodega implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private Integer idBodega;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = true)
    private String abreviacion;

    @Column(nullable = true)
    private String direccion;

    @ElementCollection
    @Column
    private List<String> telefono;

    @Column(nullable = true)
    private String estado;

    @OneToMany(mappedBy = "bodega")
    private List<DevolucionCompra> devolucionCompras;

    @OneToMany(mappedBy = "bodega")
    private List<OrdenCompra> ordenCompras;


}
