package pe.edu.hr.service;

import java.util.List;

import pe.edu.hr.model.entity.Location;

public interface LocationService extends CrudService< Location, Integer > {
	List<Location> findByCity( String city ) throws Exception;
	List<Location> findByStateProvince( String stateProvince ) throws Exception;
}
