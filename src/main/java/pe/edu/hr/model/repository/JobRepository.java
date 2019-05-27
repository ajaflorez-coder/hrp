package pe.edu.hr.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.hr.model.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
	List<Job> findByJobTitle( String jobTitle);
}
