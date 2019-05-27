package pe.edu.hr.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.hr.model.entity.Job;
import pe.edu.hr.model.repository.JobRepository;
import pe.edu.hr.service.JobService;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobRepository jobRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Job> findAll() throws Exception {
		// TODO Auto-generated method stub
		return jobRepository.findAll();
	}

	@Transactional
	@Override
	public Job save(Job t) throws Exception {
		// TODO Auto-generated method stub
		return jobRepository.save(t);
	}

	@Transactional
	@Override
	public Job update(Job t) throws Exception {
		// TODO Auto-generated method stub
		return jobRepository.save(t);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Job> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return jobRepository.findById(id);
	}

	@Transactional
	@Override
	public void deleteById(String id) throws Exception {
		jobRepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		jobRepository.deleteAll();
		
	}

	@Transactional(readOnly = true)
	@Override
	public List<Job> findByJobTitle(String jobTitle) throws Exception {
		// TODO Auto-generated method stub
		return jobRepository.findByJobTitle(jobTitle);
	}

}
