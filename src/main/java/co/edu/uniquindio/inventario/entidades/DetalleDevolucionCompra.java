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
public class DetalleDevolucionCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idDetalleDevolucionCompra;

    @Column(nullable = true)
    private String tipoActividad;

    @Column(nullable = true)
    private Integer cantidad;

    @Column(nullable = true)
    private String lote;

    @Column(nullable = true)
    private LocalDate fechaVencimiento;

    @Column(nullable = true)
    private Double valorUnitario;

    @Column(nullable = true)
    private Double subtotal;

    @Column(nullable = true)
    private Double total;

    @Column(nullable = true)
    private String usuarioCreacion;

    // Si el detalle no guarda un medicamento se pone valor 0
    // Ese valor 0 lo podemos guardar como un registro inactivo
    @ManyToOne
    private Medicamento medicamento;

    // Si el detalle no guarda un insumo se pone valor 0
    // Ese valor 0 lo podemos guardar como un registro inactivo
    @ManyToOne
    private Insumo insumo;

    @ManyToOne
    private DevolucionCompra devolucionCompra;

    @ToString.Exclude
    @OneToMany(mappedBy = "detalleDevolucionCompra")
    private List<Historial> historialdetalleDevolucionCompra;
}
