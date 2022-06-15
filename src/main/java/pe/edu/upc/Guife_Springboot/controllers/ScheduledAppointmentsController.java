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

import pe.edu.upc.guife.entities.ScheduledAppointments;
import pe.edu.upc.guife.serviceinterface.ICustomerService;
import pe.edu.upc.guife.serviceinterface.IScheduledAppointmentService;
import pe.edu.upc.guife.serviceinterface.ISpecialistService;

@Controller
@RequestMapping("/detalleCitas")
public class ScheduledAppointmentsController {
	@Autowired
	private IScheduledAppointmentService saService;
	
	@Autowired
	private ISpecialistService sService;
	
	@Autowired
	private ICustomerService cuService;
	
	@GetMapping("/new")
	public String newDetalleCita(Model model) {
		model.addAttribute("sa", new ScheduledAppointments());
		model.addAttribute("listaEspecialistas", sService.list());
		model.addAttribute("listaCustomers", cuService.lista());
		return "detalleCita/frmRegistro";
	}
	
	@PostMapping("/save")
	public String DetalleCita(@Valid ScheduledAppointments sAp, BindingResult binRes, Model model) {
		if(binRes.hasErrors()) {
			return "detalleCita/frmRegistro";
		}else {
			saService.insert(sAp);
			return "redirect:/detalleCitas/new";
		}
	}
	
	@GetMapping("/list")
	public String listDetalleCita(Model model) {
		try {
			model.addAttribute("listaDetallesCitas", saService.lista());
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/detalleCita/frmLista";
	}
	
	@RequestMapping("/delete")
	public String deleteDetalleCita(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				saService.delete(id);
				model.put("listaDetallesCitas", saService.lista());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}
		return "/detalleCita/frmLista";
	}
	
	
}
