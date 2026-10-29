package pe.com.unfpg.persona.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.com.unfpg.persona.entity.DocenteGradoEntity;
import pe.com.unfpg.persona.entity.DocenteGradoId;


public interface DocenteGradoRepository 
        extends JpaRepository<DocenteGradoEntity, DocenteGradoId> {

    @Query("select dg from DocenteGradoEntity dg")
    List<DocenteGradoEntity> findAllCustom();

    @Query("select dg from DocenteGradoEntity dg where dg.id.coddoc = :coddoc")
    List<DocenteGradoEntity> findAllCustom(@Param("coddoc") Long coddoc);
}