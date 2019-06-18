package pe.edu.hr.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "departments" )
@SequenceGenerator( name = "seqDepartment", initialValue = 280 )
public class Department {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seqDepartment" )
	@Column( name = "department_id", columnDefinition = "INTEGER(4)" )	
	private Integer id;
	
	@Column( name = "department_name", length = 30, nullable = false )
	@NotEmpty( message = "Enter the department Name")
	private String name;
	
	@ManyToOne
	@JoinColumn( name = "manager_id", columnDefinition = "INTEGER(6)", referencedColumnName = "employee_id", nullable = true )
	@JsonIgnoreProperties("departmentsManager")
	private Employee managerDepartment;
	
	@ManyToOne
	@JoinColumn( name = "location_id", nullable = false )
	@JsonIgnoreProperties("departments")
	private Location location;

	//-----------------------------------------------------------
	@OneToMany( mappedBy = "department", fetch = FetchType.LAZY )
	@OrderBy
	@JsonIgnoreProperties("department")
	private List<Employee> employees;
	
	@OneToMany( mappedBy = "department", fetch = FetchType.LAZY )
	@OrderBy
	@JsonIgnoreProperties("department")
	private List<JobHistory> jobHistories;
	
	public Department() {
		this.employees = new ArrayList<>();
		this.jobHistories = new ArrayList<>();
	}
	//------------------------------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getManagerDepartment() {
		return managerDepartment;
	}

	public void setManagerDepartment(Employee managerDepartment) {
		this.managerDepartment = managerDepartment;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<JobHistory> getJobHistories() {
		return jobHistories;
	}

	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}
	
	

	
	
}
