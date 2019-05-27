package pe.edu.hr.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table( name = "departments" )
@SequenceGenerator( name = "seqDepartment", initialValue = 280 )
public class Department {
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seqDepartment" )
	@Column( name = "department_id", columnDefinition = "INTEGER(4)" )	
	private Integer id;
	
	@Column( name = "department_name", length = 30, nullable = false )
	private String name;
	
	@Column( name = "manager_id", columnDefinition = "INTEGER(6)" )
	private Integer manager_id;
	
	@ManyToOne
	@JoinColumn( name = "location_id", nullable = false )
	private Location location;

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

	public Integer getManager_id() {
		return manager_id;
	}

	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}
