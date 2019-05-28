package pe.edu.hr.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.hr.model.entity.Country;
import pe.edu.hr.service.CountryService;

@Controller
@RequestMapping("/country")
public class CountryController {
	@Autowired
	private CountryService countryService;
	
	@GetMapping
	public String fetchAll( Model model ) {
		try {
			List<Country> countries = countryService.findAll();
			model.addAttribute("countries", countries);
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/country/index";
	}
	
	@GetMapping(path = "/search")
	public String fetchById( @RequestParam("id") String id, Model model  ) {
		try {
			if( !id.isEmpty() ) {
				Optional<Country> country = countryService.findById(id);
				if( country.isPresent() ) {
					List<Country> countries  = new ArrayList<>();
					countries.add(country.get());
					model.addAttribute("countries", countries);
				} else {
					model.addAttribute("info", "No existe id en Country");
					List<Country> countries = countryService.findAll();
					model.addAttribute("countries", countries);
				}
			} else {
				model.addAttribute("info", "Ingrese id para buscar en Country");
				List<Country> countries = countryService.findAll();
				model.addAttribute("countries", countries);
			}
		} catch (Exception e) {
			model.addAttribute("info", e.getMessage());
		}
		return "/country/index";
	}


}
