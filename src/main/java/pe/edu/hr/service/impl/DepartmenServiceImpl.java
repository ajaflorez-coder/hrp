package pe.edu.hr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.hr.model.entity.Department;
import pe.edu.hr.model.repository.DepartmentRepository;
import pe.edu.hr.service.DepartmentService;

@Service
public class DepartmenServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Department> findAll() throws Exception {
		return departmentRepository.findAll();
	}

	@Transactional
	@Override
	public Department save(Department t) throws Exception {
		return departmentRepository.save(t);
	}

	@Transactional
	@Override
	public Department update(Department t) throws Exception {
		return departmentRepository.save(t);
	}

	@Transactional
	@Override
	public Optional<Department> findById(Integer id) throws Exception {
		return departmentRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		departmentRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		departmentRepository.deleteAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Department> findByName(String name) throws Exception {
		return departmentRepository.findByName(name);
	}

}
