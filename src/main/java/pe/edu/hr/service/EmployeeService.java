package pe.edu.hr.service;

import java.util.List;

import pe.edu.hr.model.entity.Employee;

public interface EmployeeService extends CrudService<Employee, Integer> {
	
	/*List<Employee> findByFirstName( String firstName ) throws Exception;	
	List<Employee> fetchByFirstName( String firstName ) throws Exception;
	
	List<Employee> findByLastName( String lastName ) throws Exception;		
	List<Employee> fetchByLastName( String lastName ) throws Exception;*/
	List<Employee> fetchByLastFirst( String lastName, String firstName ) throws Exception;
}
