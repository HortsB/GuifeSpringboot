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

import pe.edu.upc.Guife_Springboot.entities.Specialist;
import pe.edu.upc.Guife_Springboot.serviceinterface.ISpecialistService;

@Controller
@RequestMapping("/specialist")
public class SpecialistController {
	@Autowired
	private ISpecialistService sService;

	@GetMapping("/new")
	public String newSpecialist(Model model) {
		model.addAttribute("s", new Specialist());
		return "Specialist/frmRegistro";
	}

	@PostMapping("/save")
	public String saveSpecialist(@Valid Specialist specialist, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "Specialist/frmRegistro";
		} else {
			sService.insert(specialist);
			return "redirect:/specialist/frmLista";
		}
	}

	@GetMapping("/list")
	public String listSpecialist(Model model) {
		try {
			model.addAttribute("listSpecialists", sService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/Specialist/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteSpecialist(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				sService.delete(id);
				model.put("listSpecialists", sService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/specialist/frmLista";
	}

	@RequestMapping("/groupdate/{id}")
	public String goUpdateSpecialist(@PathVariable int id, Model model) {
		Optional<Specialist> objSpec = sService.listId(id);
		model.addAttribute("app", objSpec.get());
		return "specialist/frmActualizar";
	}

	@PostMapping("/update")
	public String updateSpecialist(Specialist specialist) {
		sService.update(specialist);
		return "redirect:/specialist/list";
	}

}
