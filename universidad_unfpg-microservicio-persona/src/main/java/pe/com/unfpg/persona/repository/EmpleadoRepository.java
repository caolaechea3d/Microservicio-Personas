package pe.com.unfpg.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.unfpg.persona.entity.EmpleadoEntity;


public interface EmpleadoRepository extends JpaRepository<EmpleadoEntity, Long> {

    @Query("select e from EmpleadoEntity e where e.estado=true")
    List<EmpleadoEntity> findAllCustom();
}