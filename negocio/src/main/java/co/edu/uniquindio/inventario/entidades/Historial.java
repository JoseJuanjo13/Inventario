package co.edu.uniquindio.inventario.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Historial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idHistorial;

    @Column
    private String tipoMovimiento;

    @ManyToOne
    private DetalleOrdenCompra detalleOrdenCompra;

    @ManyToOne
    private DetalleDevolucionCompra detalleDevolucionCompra;
}
