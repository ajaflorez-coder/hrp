package pe.edu.hr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.hr.model.entity.Language;
import pe.edu.hr.model.repository.LanguageRepository;
import pe.edu.hr.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository languageRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Language> findAll() throws Exception {
		return languageRepository.findAll();
	}

	@Transactional
	@Override
	public Language save(Language t) throws Exception {
		return languageRepository.save(t);
	}

	@Transactional
	@Override
	public Language update(Language t) throws Exception {
		return languageRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Language> findById(Integer id) throws Exception {
		return languageRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		languageRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		languageRepository.deleteAll();		
	}
	
	
}
