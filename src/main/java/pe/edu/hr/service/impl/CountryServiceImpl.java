package pe.edu.hr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.hr.model.entity.Country;
import pe.edu.hr.model.repository.CountryRepository;
import pe.edu.hr.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Country> findAll() throws Exception {
		return countryRepository.findAll();
	}

	@Transactional
	@Override
	public Country save(Country t) throws Exception {
		return countryRepository.save(t);
	}

	@Transactional
	@Override
	public Country update(Country t) throws Exception {
		return countryRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Country> findById(String id) throws Exception {
		return countryRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(String id) throws Exception {
		countryRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		countryRepository.deleteAll();
		
	}

}
