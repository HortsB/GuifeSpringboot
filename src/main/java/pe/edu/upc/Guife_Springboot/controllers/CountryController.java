package pe.edu.upc.Guife_Springboot.controllers;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.Guife_Springboot.entities.Country;
import pe.edu.upc.Guife_Springboot.serviceinterface.ICountryService;

@Controller
@RequestMapping("/country")
public class CountryController {

	@Autowired
	private ICountryService cService;
	
	@GetMapping("/new")
	public String NewCountry(Model model) {
		model.addAttribute("c", new Country());
		return "pais/frmRegistroPais";
	}
	
	@PostMapping("/save")
	public String saveCountry(@Valid Country co, BindingResult binRes, Model model ) {
		if(binRes.hasErrors()) {
			return "pais/frmRegistroPais";
		} else {
			cService.insert(co);
			return "redirect:/country/new";
		}
	}
	
	@GetMapping("/list")
	public String listCountry(Model model) {
		try {
			model.addAttribute("listaPaises", cService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/pais/frmListaPaises";
	}
	
	@GetMapping("/delete")
	public String deletePerson(Map<String, Object> model, @RequestParam(value="id")Integer id) {
		try {
			if(id!=null && id>0) {
				cService.delete(id);
				model.put("listaPersonas", cService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/pais/frmListaPaises";
	}
	
	@RequestMapping("/goupdate/{id}")
	public String goUpdateCountry(@PathVariable int id, Model model) {
		Optional<Country>objCou=cService.listId(id);
		model.addAttribute("co", objCou.get());
		return "pais/frmActualizarPais";
	}
	
	@PostMapping("/update")
	public String updateCountry(Country pais) {
		cService.update(pais);
		return "redirect:/country/list";
	}
}
