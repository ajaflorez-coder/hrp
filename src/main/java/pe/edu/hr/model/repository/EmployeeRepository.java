package pe.edu.hr.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.hr.model.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// El indice es por last_name y first_name
	/*List<Employee> findByFirstName( String firstName );
	
	@Query("SELECT e FROM Employee e where e.firstName like %?1%")	
	List<Employee> fetchByFirstName( String firstName );
	
	List<Employee> findByLastName( String lastName );
	
	@Query("SELECT e FROM Employee e where e.lastName like %?1%")	
	List<Employee> fetchByLastName( String lastName );*/
	
	@Query("SELECT e FROM Employee e where e.lastName like %?1% and e.firstName like %?2%")	
	List<Employee> fetchByLastFirst( String lastName, String firstName );
}
