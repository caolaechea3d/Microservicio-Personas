package pe.com.unfpg.persona.entity;

import java.io.Serializable;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity(name = "EmpleadoGradoEntity")
@Table(name = "empleadogrado")
public class EmpleadoGradoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EmpleadoGradoId id;

    @Column(name = "institucion", length = 150, nullable = false)
    private String institucion;

    @Column(name = "anioobtencion", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate anioobtencion;

    @Column(name = "nomesp", length = 100, nullable = false)
    private String nombreespecialidad;

    // Claves foráneas
    @ManyToOne
    @MapsId("codemp")
    @JoinColumn(name = "codemp", nullable = false)
    private EmpleadoEntity empleado;

    //GradoInstruccion
    //@Column(name="codgrai", nullable =false)
    @Column(name = "codgrai", nullable = false, insertable = false, updatable = false)
    private Long codgrai;
    
    @Transient
    private Object gradoinstruccion;
}