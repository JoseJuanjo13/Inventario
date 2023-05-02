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
public class OrdenCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer idCompra;

    @Column(nullable = true)
    private String tipoMovimiento;

    @Column(nullable = true)
    private String numeroAutorizacion;

    @Column(nullable = true)
    private LocalDate fechaAutorizacion;

    @Column(nullable = true)
    private String estado;

    @Column(nullable = true)
    private LocalDate fecha;

    @Column(nullable = true)
    private Double total;

    @Column(nullable = true)
    private String usuarioCreacion;

    @ManyToOne
    private Proveedor proveedor;

    @ManyToOne
    private Bodega bodega;

    @ToString.Exclude
    @OneToMany(mappedBy = "ordenCompra")
    private List<DetalleOrdenCompra> detalleOrdenCompras;
}
