package pe.edu.hr.service;

import java.util.List;

import pe.edu.hr.model.entity.Department;

public interface DepartmentService extends CrudService<Department, Integer> {
	List<Department> findByName( String name ) throws Exception;
}
