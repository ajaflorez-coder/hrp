package pe.edu.hr.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

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
	
}
