package pe.edu.hr.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table( name = "regions" )
public class Region {
	@Id
	@Column( name = "region_id", columnDefinition = "TINYINT" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column( name = "region_name", length = 25, nullable = false )
	@NotEmpty( message = "Enter the Region Name")
	private String name;

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
	
}
