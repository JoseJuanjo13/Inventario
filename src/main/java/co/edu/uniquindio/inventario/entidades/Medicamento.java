package co.edu.uniquindio.inventario.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

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

    @Length(max = 150)
    @Column(nullable = true)
    private String principioActivo;

    @Length(max = 150)
    @Column(nullable = true)
    private String concentracion;

    @Length(max = 150)
    @Column(nullable = true)
    private String unidad;

    @Length(max = 150)
    @Column(nullable = true)
    private String presentacion;

    @Length(max = 150)
    @Column(nullable = true)
    private String viaAdministracion;

    @Column(nullable = true)
    private LocalDate fechaVencimiento;

    @Column(nullable = true)
    private String estado;

    @Column(nullable = true)
    private LocalDate fecha;

    @Length(max = 15)
    @Column(nullable = true)
    private String usuarioCreacion;

    @ToString.Exclude
    @OneToMany(mappedBy = "medicamento")
    private List<DetalleOrdenCompra> detalleOrdenCompras;

    public Medicamento() {
        //
    }

}
