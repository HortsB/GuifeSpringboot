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

import pe.edu.upc.Guife_Springboot.entities.Task;
import pe.edu.upc.Guife_Springboot.serviceinterface.IActivityService;
import pe.edu.upc.Guife_Springboot.serviceinterface.ITaskService;

@Controller
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private IActivityService aService;
	@Autowired
	private ITaskService tService;

	@GetMapping("/new")
	public String newTask(Model model) {
		model.addAttribute("t", new Task());
		model.addAttribute("listActivity", aService.list());
		return "task/frmRegistro";
	}

	@PostMapping("/save")
	public String saveTask(@Valid Task task, BindingResult binRes, Model model) {
		if (binRes.hasErrors()) {
			return "task/frmRegistro";
		} else {
			tService.insert(task);
			return "redirect:/task/list";
		}
	}

	@GetMapping("/list")
	public String listTask(Model model) {
		try {
			model.addAttribute("listTask", tService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/task/frmLista";
	}

	@RequestMapping("/delete")
	public String deleteTask(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.delete(id);
				model.put("listTask", tService.list());
			}
		} catch (Exception e) {
			model.put("error", e.getMessage());
		}
		return "/task/frmLista";
	}

}
