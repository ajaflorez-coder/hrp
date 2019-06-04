package pe.edu.hr.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pe.edu.hr.model.entity.Country;
import pe.edu.hr.model.entity.Language;
import pe.edu.hr.model.entity.Location;
import pe.edu.hr.service.CountryService;

@RestController
@RequestMapping("/countries")
@Api( value = "REST for Countries" )
public class CountryRestController {

	@Autowired
	private CountryService countryService;
	
	// EndPoints
	//-------------------------------------------------------
	@ApiOperation("Fetch all countries")
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Country> > fetchAll() {
		try {
			List<Country> Countrys = countryService.findAll();
			return new ResponseEntity< List<Country> >(Countrys, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Country> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Save country")
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> save( @Valid @RequestBody Country country ) {
		try {
			Country tmp = countryService.save(country);
			if( tmp != null ) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update country")
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Country country ) {
		try {
			Optional<Country> searched = countryService.findById(country.getId());
			if(searched.isPresent()) {
				countryService.update(country);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove all countries")
	@DeleteMapping( produces = "text/plain" )
	public ResponseEntity< String > deleteAll() {
		try {
			countryService.deleteAll();
			return new ResponseEntity< String >("Entities removed", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< String >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	//--------------------------------------------------------------------------
	@ApiOperation("Fetch country by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Country > fetchById(@PathVariable("id") String id) {
		try {
			Optional<Country> country = countryService.findById(id);
			if(country.isPresent()) {
				return new ResponseEntity< Country >(country.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity< Country >(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< Country >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove country by id")
	@DeleteMapping( value = "/{id}", produces = "text/plain")
	public ResponseEntity< String > deleteById( @PathVariable("id") String id ) {
		try {
			Optional<Country> searched = countryService.findById(id);			
			if(searched.isPresent()) {
				countryService.deleteById(id);
				return new ResponseEntity< String >("Entity removed", HttpStatus.OK);
			} else {
				return new ResponseEntity< String >(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< String >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//----------------------------------------------------------------------------
	@ApiOperation("Fetch all Locations from country")
	@GetMapping( path = "/{id}/locations", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Location> > fetchAllLocations( @PathVariable("id") String id ) {
		try {
			Optional<Country> searched = countryService.findById(id);			
			if(searched.isPresent()) {
				List<Location> locations = searched.get().fetchLocations();
				return new ResponseEntity< List<Location> >(locations, HttpStatus.OK);
			} else {
				return new ResponseEntity< List<Location> >(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< List<Location> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save Location in country")
	@PostMapping( path = "/{id}/location",  consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> saveCountry( @PathVariable("id") String id, @Valid @RequestBody Location location ) {
		try {
			Optional<Country> searched = countryService.findById(id);			
			if(searched.isPresent()) {
				searched.get().addLocation(location);
				countryService.save( searched.get() );
				return new ResponseEntity< Object >(HttpStatus.OK);
			} else {
				return new ResponseEntity< Object >(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Save language in country")
	@PostMapping( path = "/{id}/language",  consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> saveLanguage( @PathVariable("id") String id, @Valid @RequestBody Language language ) {
		try {
			// Ubicamos el country
			Optional<Country> searched = countryService.findById(id);			
			if(searched.isPresent()) {
				searched.get().addLanguage(language);
				countryService.save( searched.get() );
				return new ResponseEntity< Object >(HttpStatus.OK);
			} else {
				return new ResponseEntity< Object >(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch Location from country by id")
	@GetMapping( path = "/{id}/location/{idLocation}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< Location > fetchCountry( @PathVariable("id") String id, @PathVariable("idLocation") Integer idLocation ) {
		try {
			Optional<Country> searched = countryService.findById(id);
			if(searched.isPresent()) {
				Optional<Location> searchedLocation = searched.get().fetchLocationById(idLocation);
				if(searchedLocation.isPresent()) {
					return new ResponseEntity< Location >(searchedLocation.get(), HttpStatus.OK);
				}
			}
			return new ResponseEntity< Location >(HttpStatus.NOT_FOUND); 

		} catch (Exception e) {
			return new ResponseEntity< Location >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
