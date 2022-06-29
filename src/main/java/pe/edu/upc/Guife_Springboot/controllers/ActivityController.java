package pe.edu.upc.Guife_Springboot.controllers;

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

import pe.edu.upc.Guife_Springboot.entities.Activity;
import pe.edu.upc.Guife_Springboot.serviceinterface.IActivityService;

@Controller
@RequestMapping("/activity")
public class ActivityController {
	@Autowired
	private IActivityService acService;

	@GetMapping("/new")
	public String newActivity(Model model) {
		model.addAttribute("ac", new Activity());
		return "activity/frmRegistro";
	}

	@PostMapping("/save")
	public String saveActivity(@Valid Activity activity, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "activity/frmRegistro";
		} else {
			acService.insert(activity);
			return "redirect:/activity/list";
		}
	}

	@RequestMapping("/list")
	public String listActivity(Model model) {
		try {
			model.addAttribute("listActivity", acService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/activity/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteActivity(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if(id!=null&&id>0) {
				acService.delete(id);
				model.put("listActivity", acService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "activity/frmLista";
	}
	@RequestMapping("/report")
	public String NTaskPerActivity(Map<String,Object>model) {
		model.put("lista", acService.NTaskPerActivity());
		return "activity/report";
	}
	
}
