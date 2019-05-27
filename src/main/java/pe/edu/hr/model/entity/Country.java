package pe.edu.hr.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table( name = "countries" )
public class Country {
		
	@Id
	@Column( name = "country_id", columnDefinition = "CHAR(2)" )
	@NotEmpty( message = "Enter the id" )
	private String id;
	
	@Column( name = "country_name", length = 40 )
	@NotEmpty( message = "Enter the Country Name")
	private String name;
	
	@ManyToOne
	@JoinColumn( name = "region_id", nullable = false )
	@NotNull( message = "Enter the region" )
	private Region region;
	
	@OneToMany( mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List< Location > locations;

	public Country() {
		this.locations = new ArrayList<>();
	}
	//---------------------------------------
	public void addLocation( Location location) {
		location.setCountry( this );
		this.locations.add( location );
	}
	public List<Location> fetchLocations() {
		return locations;
	}
	public Optional<Location> fetchLocationById(Integer id) {
		for (Location location : locations) {
			if( location.getId().equals( id ) ) {
				return Optional.of(location);
			}
		}
		return Optional.empty();
	}
	//---------------------------------------
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Region getRegion() {
		return this.region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
