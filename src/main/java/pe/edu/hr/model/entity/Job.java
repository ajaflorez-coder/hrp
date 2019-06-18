package pe.edu.hr.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table( name = "jobs" )
public class Job {
	@Id
	@Column( name = "job_id", columnDefinition = "VARCHAR(10)" )	
	private String id;
	
	@Column( name = "job_title", length = 35, nullable = false )
	private String jobTitle;
	
	@Min(value = 0)
	@Column( name = "min_salary", columnDefinition = "INTEGER(6)" )
	private Integer minSalary;
	
	@Min(value = 0)
	@Column( name = "max_salary", columnDefinition = "INTEGER(6)" )
	private Integer maxSalary;

	//------------------------------------------------------
	@OneToMany( mappedBy = "job", fetch = FetchType.LAZY )
	@OrderBy
	@JsonIgnoreProperties("job")
	private List<Employee> employees;
	
	@OneToMany( mappedBy = "job", fetch = FetchType.LAZY )
	@OrderBy
	@JsonIgnoreProperties("job")
	private List<JobHistory> jobHistories;
	
	public Job() {
		this.employees = new ArrayList<>();
		this.jobHistories = new ArrayList<>();
	}
	//------------------------------------------------------

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Integer minSalary) {
		this.minSalary = minSalary;
	}

	public Integer getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Integer maxSalary) {
		this.maxSalary = maxSalary;
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
