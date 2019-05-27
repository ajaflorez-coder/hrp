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
import pe.edu.hr.model.entity.Location;
import pe.edu.hr.service.LocationService;

@RestController
@RequestMapping("/locations")
@Api( value = "REST for Locations" )
public class LocationRestController {

	@Autowired
	private LocationService locationService;
	
	// EndPoints
	@ApiOperation("Fetch all entities")
	@GetMapping( produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< List<Location> > fetchAll() {
		try {
			List<Location> locations = locationService.findAll();
			return new ResponseEntity< List<Location> >(locations, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< List<Location> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation("Save entity")
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> save( @Valid @RequestBody Location location ) {
		try {
			Location tmp = locationService.save(location);
			if( tmp != null ) {
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Update entity")
	@PutMapping( consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Object> update( @Valid @RequestBody Location location ) {
		try {
			Optional<Location> buscado = locationService.findById(location.getId());
			if(buscado.isPresent()) {
				locationService.update(location);
				return new ResponseEntity<Object>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove all entities")
	@DeleteMapping( produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< String > deleteAll() {
		try {
			locationService.deleteAll();
			return new ResponseEntity< String >("Entities removed", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity< String >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch entity by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Location > fetchById(@PathVariable("id") Integer id) {
		try {
			Optional<Location> location = locationService.findById(id);
			if(location.isPresent()) {
				return new ResponseEntity< Location >(location.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity< Location >(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< Location >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Remove entity by id")
	@DeleteMapping( value = "/{id}", produces=MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity< String > deleteById( @PathVariable("id") Integer id ) {
		try {
			Optional<Location> buscado = locationService.findById(id);			
			if(buscado.isPresent()) {
				locationService.deleteById(id);
				return new ResponseEntity< String >("Entity removed", HttpStatus.OK);
			} else {
				return new ResponseEntity< String >(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< String >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch entity by city")
	@GetMapping(value = "/city/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Location> > fetchByCity(@PathVariable("city") String city) {
		try {
			List<Location> locations = locationService.findByCity(city);
			if( !locations.isEmpty() ) {
				return new ResponseEntity< List<Location> >(locations, HttpStatus.OK);
			} else {
				return new ResponseEntity< List<Location> >(HttpStatus.NOT_FOUND);
			}
			
		} catch (Exception e) {
			return new ResponseEntity< List<Location> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation("Fetch entity by state Province")
	@GetMapping(value = "/stateProvince/{stateProvince}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Location> > fetchByStateProvince(@PathVariable("stateProvince") String stateProvince) {
		try {
			List<Location> locations = locationService.findByStateProvince(stateProvince);
			if( !locations.isEmpty() ) {
				return new ResponseEntity< List<Location> >(locations, HttpStatus.OK);
			} else {
				return new ResponseEntity< List<Location> >(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< List<Location> >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}















	
	
	
	