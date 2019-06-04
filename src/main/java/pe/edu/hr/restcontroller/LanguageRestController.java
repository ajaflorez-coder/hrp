package pe.edu.hr.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.hr.model.entity.Language;
import pe.edu.hr.service.LanguageService;

@RestController
@RequestMapping("/language")
public class LanguageRestController {
	
	@Autowired
	private LanguageService languageService;
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Language> save (@RequestBody @Valid Language language) {
		try {
			Language lang = languageService.save(language);
			return new ResponseEntity<Language>(lang, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Language>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}













