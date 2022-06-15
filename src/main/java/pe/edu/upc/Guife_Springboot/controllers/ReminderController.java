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

import pe.edu.upc.Guife_Springboot.entities.Reminder;
import pe.edu.upc.Guife_Springboot.serviceinterface.IReminderService;
import pe.edu.upc.Guife_Springboot.serviceinterface.ITaskService;

@Controller
@RequestMapping("/reminder")
public class ReminderController {
	@Autowired
	private IReminderService rService;
	@Autowired
	private ITaskService tService;

	@GetMapping("/new")
	public String newReminder(Model model) {
		model.addAttribute("r", new Reminder());
		model.addAttribute("listTask", tService.list());
		return "reminder/frmRegistro";
	}

	@PostMapping("/save")
	public String saveReminder(@Valid Reminder reminder,BindingResult binRes,Model model) {
		if(binRes.hasErrors()) {
			return "reminder/frmRegistro";
		}
		else {
			rService.insert(reminder);
			return "redirect:/reminder/list";
		}
	}
	@GetMapping("/list")
	public String listReminder (Model model) {
		try {
			model.addAttribute("listReminder",rService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		
		}
		return "/reminder/frmLista";
	}
	@RequestMapping("/delete")
	public String deleteReminder(Map<String, Object>model,@RequestParam(value="id")Integer id) {
		try {
			if(id!=null&&id>0) {
				rService.delete(id);
				model.put("listReminder", rService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/reminder/frmLista";
	}
}
