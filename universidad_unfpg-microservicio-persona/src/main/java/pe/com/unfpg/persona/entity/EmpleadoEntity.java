package pe.com.unfpg.persona.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")
public class EmpleadoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codemp")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "nomemp", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apepemp", length = 40, nullable = false)
    private String apellidopaterno;

    @Column(name = "apememp", length = 40, nullable = false)
    private String apellidomaterno;

    @Column(name = "fecnac", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechanacimiento;

    @Column(name = "numdoc", length = 20, nullable = false, unique = true)
    private String numerodocumento;

    @Column(name = "nacemp", length = 20, nullable = false)
    private String nacionalidad;

    @Column(name = "diremp", nullable = false)
    private String direccion;

    @Column(name = "telemp", length = 15)
    private String telefono;

    @Column(name = "celemp", length = 15, nullable = false)
    private String celular;

    @Column(name = "coremp", length = 100, nullable = false, unique = true)
    private String correo;

    @Column(name = "estemp", nullable = false)
    private Boolean estado;

    @Column(name = "creemp", updatable = false)
    private LocalDateTime fechacreacion;

    @Column(name = "sueemp", nullable = false)
    private Double sueldo;

    public Boolean getEstado() {
        return estado;
    }
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

	@Column(name="codare", nullable = false)
	private Long codare;
	@Column(name="codcar", nullable = false)
	private Long codcar;
	@Column(name = "coddis",nullable = false)
	private Long coddis;
	@Column(name = "codsex",nullable = false)
	private Long codsex;
	@Column(name = "codtipd",nullable = false)
	private Long codtipd;
	@Column(name = "codestc",nullable = false)
	private Long codestc;


	
	//Generamos Campos Temporales de Jakarta
	@Transient
	private Object areaempleo;
	
	@Transient
	private Object cargo;
	
	@Transient
	private Object distrito;
	
	@Transient
	private Object estadocivil;
	
	@Transient
	private Object sexo;
	
	@Transient
	private Object tipodocumento;
	

	





}