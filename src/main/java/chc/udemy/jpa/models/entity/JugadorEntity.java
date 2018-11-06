package chc.udemy.jpa.models.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * Clase modelo para la creación de  la tabla en la base de datos.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jugadores")
public class JugadorEntity implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //Validaciones de que no venga vacio el string
    @NotEmpty
    @Column(name = "nombre")
    private String nombre;

    @NotEmpty
    @Column(name = "apellido")
    private String apellido;
    @NotEmpty
    @Email
    @Pattern(regexp=".+@.+\\..+", message = "Formato invalido.")
    private String email;
    //Anotación para transformar la fecha para base de datos.
    @NotNull
    @Column(name = "inscripcion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inscripcion;

    /**
     * Metodo que se invoca justo antes de hacer la inserción en base de datos para generar la fecha.
     */
//    @PrePersist
//    public void prePersist(){
//        inscripcion = new Date();
//    }
}
