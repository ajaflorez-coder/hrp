package pe.edu.hr.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.hr.model.entity.Department;
import pe.edu.hr.model.entity.Employee;
import pe.edu.hr.model.entity.Job;
import pe.edu.hr.model.entity.Location;
import pe.edu.hr.service.DepartmentService;
import pe.edu.hr.service.EmployeeService;
import pe.edu.hr.service.JobService;
import pe.edu.hr.service.LocationService;

@Controller
@RequestMapping("/department")
@SessionAttributes({"department", "employee"})
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JobService jobService;
	
	@GetMapping
	public String listado(Model model) {
		try {
			List<Department> departments = departmentService.findAll();
			model.addAttribute("departamentos", departments);
		} catch (Exception e) {
			model.addAttribute("error", "Error en obtener la lista");
		}
		return "/department/lista";
	}

	@GetMapping("/buscar")
	public String buscar(@RequestParam("txtId") Integer id, Model model) {
		try {
			Optional<Department> buscado =  departmentService.findById(id);
			List<Department> departments = new ArrayList<>();
			if (buscado.isPresent()) {
				departments.add(buscado.get());				
			} 
			model.addAttribute("departamentos", departments);
			
		} catch (Exception e) {
			model.addAttribute("error", "Error en obtener la lista");
		}
		return "/department/lista";		
	}
	@GetMapping("/edit/{id}")
	public String editar( @PathVariable("id") Integer id, Model model) {
		try {
			Optional<Department> buscado =  departmentService.findById(id);
			if (buscado.isPresent()) {
				model.addAttribute("department", buscado.get());	
				List<Location> locations = locationService.findAll();
				model.addAttribute("locations", locations);
			} else {
				model.addAttribute("error", "Department no encontrado");
			}
		} catch (Exception e) {
			model.addAttribute("error", "Department no encontrado");
		}
		return "/department/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("department") Department department, Model model, SessionStatus status) {
		try {
			
			departmentService.save(department);
			status.setComplete();
			model.addAttribute("success", "Department saved");
		} catch (Exception e) {
			model.addAttribute("error", "Department not saved");
		} 
		return "redirect:/department";
	}
	
	@GetMapping("/new")
	public String nuevo(Model model) {
		try {
			Department department = new Department();
			Optional<Location> location = locationService.findById(1000);
			department.setLocation(location.get());			
			model.addAttribute("department", department);
			
			List<Location> locations = locationService.findAll();
			model.addAttribute("locations", locations);
		} catch (Exception e) {
			model.addAttribute("error", "Department not saved");
		}
		
		return "/department/edit"; 
	}
	
	@GetMapping("/del/{id}")
	public String del( @PathVariable("id") Integer id, Model model  ) {
		try {
			Optional<Department> buscado = departmentService.findById(id);
			if(buscado.isPresent()) {
				departmentService.deleteById(id);
			}
		} catch (Exception e) {
			model.addAttribute("error", "Department not delete");
		}
		return "redirect:/department";
	}
	
	@GetMapping("/{id}/employees")
	public String viewEmployees( @PathVariable("id") Integer id, Model model  ) {
		try {
			Optional<Department> buscado = departmentService.findById(id);
			if(buscado.isPresent()) {
				Department department = buscado.get();
				List<Employee> employees = department.getEmployees();
				model.addAttribute("department", department);
				model.addAttribute("employees", employees);
			}
		} catch (Exception e) {
			model.addAttribute("error", "Department error");
		}
		return "/department/viewemp";
	}
	
	@GetMapping("/employee/edit/{id}")
	public String editEmployee( @PathVariable("id") Integer id, Model model) {
		try {
			Optional<Employee> buscado =  employeeService.findById(id);
			
			if (buscado.isPresent()) {
				model.addAttribute("employee", buscado.get());
				
				List<Job> jobs = jobService.findAll();
				model.addAttribute("jobs", jobs);
				
				List<Department> departments = departmentService.findAll();
				model.addAttribute("departments", departments);
				
			} else {
				model.addAttribute("error", "Employee no encontrado");
			}
		} catch (Exception e) {
			model.addAttribute("error", "Employee no encontrado");
		}
		return "/department/editemp";
	}
	
	@PostMapping("/employee/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee, Model model, SessionStatus status) {
		try {
			
			employeeService.save(employee);
			status.setComplete();
			
			model.addAttribute("success", "Employee saved");
		} catch (Exception e) {
			model.addAttribute("error", "Employee not saved");
		} 
		return "redirect:/department/" + employee.getDepartment().getId() + "/employees" ;
	}
	
}