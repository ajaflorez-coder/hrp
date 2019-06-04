package pe.edu.hr.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="languages")
public class Language {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", columnDefinition="TINYINT")
	private Integer id;
	
	@Column(name = "name", length = 15) 
	@NotEmpty(message="Enter the name of language")
	private String name;
	
	@ManyToMany(mappedBy="languages")
	private List<Country> countries;
	
	public Language() {
		this.countries = new ArrayList<>();
	}
	//------
	public void addCountry( Country country ) {
		this.countries.add(country);
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
	
}






