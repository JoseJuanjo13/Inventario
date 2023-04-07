package co.edu.uniquindio.inventario.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Insumo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idInsumo;

    @Column(nullable = true)
    private String nombre;

    @Column(nullable = true)
    private String presentacion;

    @Column(nullable = true)
    private String tipoInsumo;

    @Column(nullable = true)
    private Integer vidaUtil;

    @Column(nullable = true)
    private String estado;

    @Column(nullable = true)
    private LocalDate fecha;

    @Column(nullable = true)
    private String usuarioCreacion;

    @OneToMany(mappedBy = "insumo")
    private List<DetalleOrdenCompra> detalleOrdenCompras;
}
