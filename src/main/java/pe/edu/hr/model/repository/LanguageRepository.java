package pe.edu.hr.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.hr.model.entity.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
