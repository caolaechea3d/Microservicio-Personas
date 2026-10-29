package pe.com.unfpg.persona.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.com.unfpg.persona.entity.DocenteEntity;

public interface DocenteRepository extends JpaRepository<DocenteEntity, Long> {
	
	@Query("select d from DocenteEntity d where d.estado=true")
	List<DocenteEntity> findAllCustom();
}
