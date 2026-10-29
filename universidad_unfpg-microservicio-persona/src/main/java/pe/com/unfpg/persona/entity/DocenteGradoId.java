package pe.com.unfpg.persona.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class DocenteGradoId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "coddoc")
    private Long coddoc;

    @Column(name = "codgrai")
    private Long codgrai;
}