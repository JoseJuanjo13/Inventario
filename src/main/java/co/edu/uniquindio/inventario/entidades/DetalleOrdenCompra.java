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
public class DetalleOrdenCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idDetalleOrdenCompra;

    @Column(nullable = true)
    private String tipoActividad;

    @Column(nullable = true)
    private Integer cantidadSolicitada;

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
    private OrdenCompra ordenCompra;

    @ToString.Exclude
    @OneToMany(mappedBy = "detalleOrdenCompra")
    private List<Historial> historialdetalleOrdenCompra;

    public DetalleOrdenCompra() {
        // Se implementa para crear un detalle de orden antes de agregar la información.
    }

}
