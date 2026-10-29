package pe.com.unfpg.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.unfpg.persona.entity.EmpleadoGradoEntity;
import pe.com.unfpg.persona.entity.EmpleadoGradoId;


public interface EmpleadoGradoRepository
        extends JpaRepository<EmpleadoGradoEntity, EmpleadoGradoId> {

    @Query("select eg from EmpleadoGradoEntity eg")
    List<EmpleadoGradoEntity> findAllCustom();

    @Query("select eg from EmpleadoGradoEntity eg where eg.empleado.codigo = :codemp")
    List<EmpleadoGradoEntity> findByEmpleado(@Param("codemp") Long codemp);
}