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
public class TiposIdentificacion implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idTipoIdentificacion;


    @Column(nullable = true)
    private String descripcion;

    @ToString.Exclude
    @OneToMany(mappedBy = "tipoIdentificacion")
    private List<Proveedor> proveedor;

}
