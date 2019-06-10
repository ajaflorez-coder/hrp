package pe.edu.hr.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table( name = "regions" )
public class Region {
	@Id
	@Column( name = "region_id", columnDefinition = "TINYINT(1)" )
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column( name = "region_name", length = 25, nullable = false )
	@NotEmpty( message = "Enter the Region Name")
	private String name;
	
	//------------------------------------------------------
	@OneToMany( mappedBy = "region", fetch=FetchType.LAZY )
	@OrderBy( "name ASC" )
	private List<Country> countries;
	//------------------------------------------------------
	
	public Region() {
		this.countries = new ArrayList<>();
	}

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

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
	
}
