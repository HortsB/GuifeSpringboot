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

import pe.edu.upc.Guife_Springboot.entities.Appointment;
import pe.edu.upc.Guife_Springboot.serviceinterface.IAppointmentService;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	private IAppointmentService aService;
	
	@GetMapping("/new")
	public String newPerson(Model model) {
		model.addAttribute("a", new Appointment());
		return "appointment/frmRegistroCitas";
	}
	
	@PostMapping("/save")
	public String savePerson(@Valid Appointment app, BindingResult binRes, Model model) {
		if(binRes.hasErrors()) {
			return "person/frmRegistro";
		}else {
			aService.insert(app);
			return "redirect:/appointments/new";
		}
	}
	
	@GetMapping("/list")
	public String listPerson(Model model) {
		try {
			model.addAttribute("listaCitas", aService.list());
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/appointment/frmLista";
	}
	
	@RequestMapping("/delete")
	public String deleteAppointment(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				aService.delete(id);
				model.put("listaCitas", aService.list());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}
		return "/appointment/frmLista";
	}
	
	@RequestMapping("/goupdate/{id}")
	public String goUpdatePerson(@PathVariable int id, Model model) {
		Optional<Appointment> objPer = aService.listId(id);
		model.addAttribute("app", objPer.get());
		return "appointment/frmActualizar";
	}
	
	@PostMapping("/update")
	public String updatePerson(Appointment appointment) {
		aService.update(appointment);
		return "redirect:/appointments/list";
	}
}
