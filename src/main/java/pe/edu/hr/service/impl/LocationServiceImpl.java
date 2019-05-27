package pe.edu.hr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.hr.model.entity.Location;
import pe.edu.hr.model.repository.LocationRepository;
import pe.edu.hr.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Location> findAll() throws Exception {
		return locationRepository.findAll();
	}

	@Transactional
	@Override
	public Location save(Location t) throws Exception {
		return locationRepository.save( t );
	}

	@Transactional
	@Override
	public Location update(Location t) throws Exception {
		return locationRepository.save( t );
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Location> findById(Integer id) throws Exception {
		return locationRepository.findById( id );
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		locationRepository.deleteById( id );
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		locationRepository.deleteAll();
		
	}

	@Transactional(readOnly = true)
	@Override
	public List<Location> findByCity(String city) throws Exception {
		return locationRepository.findByCity( city );
	}

	@Transactional(readOnly = true)
	@Override
	public List<Location> findByStateProvince(String stateProvince) throws Exception {
		return locationRepository.findByStateProvince(stateProvince);
	}

}















