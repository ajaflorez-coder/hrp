package pe.edu.hr.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.hr.model.entity.Department;
import pe.edu.hr.service.DepartmentService;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Department> > fetchAll() {
		try {
			List<Department> departments = departmentService.findAll();
			return new ResponseEntity< List<Department> >(departments, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Department> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping( path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< Department > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Department> department =  departmentService.findById(id);
			if(department.isPresent()) {
				return new ResponseEntity< Department >(department.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity< Department >(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			return new ResponseEntity< Department >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> save(@RequestBody @Valid Department department) {
		try {
			departmentService.save(department);
			return new ResponseEntity< Object >(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< Object >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody @Valid Department department) {
		try {
			Optional<Department> buscado = departmentService.findById(department.getId());
			if(buscado.isPresent()) {
				departmentService.update(department);
				return new ResponseEntity< Object >(HttpStatus.OK);
			} else {
				return new ResponseEntity< Object >(HttpStatus.NOT_FOUND);
			}		
		} catch (Exception e) {
			return new ResponseEntity< Object >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping( path = "/{id}", produces = "text/plain" )
	public ResponseEntity< String > deleteById(@PathVariable("id") Integer id) {
		try {
			Optional<Department> department =  departmentService.findById(id);
			if(department.isPresent()) {
				departmentService.deleteById(id);
				return new ResponseEntity< String >("Delete OK", HttpStatus.OK);
			} else {
				return new ResponseEntity< String >(HttpStatus.NOT_FOUND);
			}			
		} catch (Exception e) {
			return new ResponseEntity< String >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}










