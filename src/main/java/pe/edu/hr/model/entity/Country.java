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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	@JsonIgnoreProperties("countries")
	private Region region;
	
	//------------------------------------------------------
	@OneToMany( mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@OrderBy( "city ASC" )
	@JsonIgnoreProperties("country")
	private List< Location > locations;	
	
	@ManyToMany( fetch = FetchType.LAZY )
	@JoinTable(name="country_language", 
		joinColumns = { @JoinColumn(name = "country_id", referencedColumnName="country_id") },
		inverseJoinColumns = { @JoinColumn(name = "language_id", referencedColumnName="id") } )
	@JsonIgnoreProperties("countries")
	private List<Language> languages;

	public Country() {
		this.locations = new ArrayList<>();
		this.languages = new ArrayList<>();
	}
	//------------------------------------------------------
	//-- language
	public void addLanguage( Language language ) {
		this.languages.add(language);
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
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public List<Location> getLocations() {
		return locations;
	}
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	


}
