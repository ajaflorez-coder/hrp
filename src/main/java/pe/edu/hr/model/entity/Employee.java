package pe.edu.hr.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table( name = "employees", 
		indexes = { @Index( name = "employees_indx_0", columnList = "last_name, first_name" ) }, 
		uniqueConstraints = @UniqueConstraint( columnNames = { "email" } ) 
	)
@SequenceGenerator( name = "seqEmployee", initialValue = 207 )
public class Employee {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seqEmployee" )
	@Column( name = "employee_id", columnDefinition = "INTEGER(6)" )	
	private Integer id;
	
	@Column( name = "first_name", length = 20 )
	private String firstName;
	
	@Column( name = "last_name", length = 25, nullable = false )
	@NotEmpty( message = "Enter the last name")
	private String lastName;
	
	@Email( message = "Not is a email valid" )
	@Column( name = "email", length = 25, nullable = false )
	@NotEmpty( message = "Enter the email")
	private String email;
	
	@Column( name = "phone_number", length = 20 )
	private String phoneNumber;
	
	@Column( name = "hire_date" )
	@Temporal( TemporalType.DATE )
	private Date hireDate;
	
	@ManyToOne
	@JoinColumn( name = "job_id", nullable = false )
	private Job job;
	
	@Min(value = 0)
	@Column( name = "salary", columnDefinition = "DECIMAL(8,2)" )
	private Double salary;
	
	@Column( name = "commission_pct", columnDefinition = "DECIMAL(2,2)" )
	private Integer commissionPct;
	
	@ManyToOne
	@JoinColumn( name = "manager_id", nullable = true )
	private Employee managerEmployee;
	
	@ManyToOne
	@JoinColumn( name = "department_id", nullable = true )
	private Department department;
	
	//------------------------------------------------------
	@OneToMany( mappedBy = "managerDepartment", fetch = FetchType.LAZY )
	@OrderBy
	private List<Department> departmentsManager;
	
	@OneToMany( mappedBy = "managerEmployee", fetch = FetchType.LAZY )
	@OrderBy
	private List<Employee> employeesManager;
	
	@OneToMany( mappedBy = "employee", fetch = FetchType.LAZY )
	@OrderBy
	private List<JobHistory> jobHistories;	
	
	public Employee() {
		this.departmentsManager = new ArrayList<>();
		this.employeesManager = new ArrayList<>();
		this.jobHistories = new ArrayList<>();
	}
	//------------------------------------------------------

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(Integer commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Employee getManagerEmployee() {
		return managerEmployee;
	}

	public void setManagerEmployee(Employee managerEmployee) {
		this.managerEmployee = managerEmployee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Department> getDepartmentsManager() {
		return departmentsManager;
	}

	public void setDepartmentsManager(List<Department> departmentsManager) {
		this.departmentsManager = departmentsManager;
	}

	public List<Employee> getEmployeesManager() {
		return employeesManager;
	}

	public void setEmployeesManager(List<Employee> employeesManager) {
		this.employeesManager = employeesManager;
	}

	public List<JobHistory> getJobHistories() {
		return jobHistories;
	}

	public void setJobHistories(List<JobHistory> jobHistories) {
		this.jobHistories = jobHistories;
	}
	
	
	
	
}











