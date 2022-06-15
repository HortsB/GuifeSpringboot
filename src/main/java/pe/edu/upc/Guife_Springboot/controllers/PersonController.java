package pe.edu.upc.guife.controllers;

import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.edu.upc.guife.entities.Person;
import pe.edu.upc.guife.serviceinterface.ICountryService;
import pe.edu.upc.guife.serviceinterface.IPersonService;

@Controller
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	private IPersonService pService;
	
	@Autowired
	private ICountryService cService;
	
	@GetMapping("/new")
	public String newPerson(Model model) {
		model.addAttribute("p", new Person());
		model.addAttribute("listaPaises", cService.list());
		return "person/frmRegistro";
	}
	
	@PostMapping("/save")
	public String savePerson(@Valid Person per, BindingResult binRes, Model model) {
		if(binRes.hasErrors()) {
			return "person/frmRegistro";
		}else {
			pService.insert(per);
			return "redirect:/persons/new";
		}
	}
	
	@GetMapping("/list")
	public String listPerson(Model model) {
		try {
			model.addAttribute("listaPersonas", pService.list());
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/person/frmLista";
	}
	
	@RequestMapping("/delete")
	public String deletePerson(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				pService.delete(id);
				model.put("listaPersonas", pService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}
		return "/person/frmLista";
	}
	
	
	
}
