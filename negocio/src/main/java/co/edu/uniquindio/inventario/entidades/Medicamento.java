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
public class Medicamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idMedicamento;

    @Column(nullable = true)
    private String principioActivo;

    @Column(nullable = true)
    private String concentracion;

    @Column(nullable = true)
    private String unidad;

    @Column(nullable = true)
    private String presentacion;

    @Column(nullable = true)
    private String viaAdministracion;

    @Column(nullable = true)
    private LocalDate fechaVencimiento;

    @Column(nullable = true)
    private String estado;

    @Column(nullable = true)
    private LocalDate fecha;

    @Column(nullable = true)
    private String usuarioCreacion;

    @OneToMany(mappedBy = "medicamento")
    private List<DetalleOrdenCompra> detalleOrdenCompras;

}
