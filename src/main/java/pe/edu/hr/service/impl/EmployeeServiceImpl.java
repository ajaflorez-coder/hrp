package pe.edu.hr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.hr.model.entity.Employee;
import pe.edu.hr.model.repository.EmployeeRepository;
import pe.edu.hr.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Employee> findAll() throws Exception {
		return employeeRepository.findAll();
	}

	@Transactional
	@Override
	public Employee save(Employee t) throws Exception {
		return employeeRepository.save(t);
	}

	@Transactional
	@Override
	public Employee update(Employee t) throws Exception {
		return employeeRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Employee> findById(Integer id) throws Exception {
		return employeeRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		employeeRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		employeeRepository.deleteAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Employee> fetchByLastFirst(String lastName, String firstName) throws Exception {
		return employeeRepository.fetchByLastFirst(lastName, firstName);
	}

	
	


}
