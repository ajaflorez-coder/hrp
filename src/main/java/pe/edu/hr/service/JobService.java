package pe.edu.hr.service;

import java.util.List;

import pe.edu.hr.model.entity.Job;

public interface JobService extends CrudService<Job, String>{
	List<Job> findByJobTitle( String jobTitle) throws Exception;
}
