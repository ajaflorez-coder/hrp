package pe.edu.hr.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.hr.model.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
	List<Location> findByCity( String city );
	List<Location> findByStateProvince( String stateProvince );
	
}
