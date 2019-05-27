package pe.edu.hr.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.hr.model.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	List<Department> findByName( String name );

}
