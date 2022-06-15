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

import pe.edu.upc.guife.entities.Administrador;
import pe.edu.upc.guife.serviceinterface.IAdministradorService;
import pe.edu.upc.guife.serviceinterface.IPersonService;

@Controller
@RequestMapping("/administradores")
public class AdministradorController {
	@Autowired
	private IAdministradorService adService;
	
	@Autowired
	private IPersonService pService;
	
	@GetMapping("/new")
	public String newAdmin(Model model) {
		model.addAttribute("a", new Administrador());
		model.addAttribute("listaPersonas", pService.list());
		return "administrador/frmRegistro";
	}
	
	@PostMapping("/save")
	public String saveAdmin(@Valid Administrador admin, BindingResult binRes, Model model) {
		if(binRes.hasErrors()) {
			return "administrador/frmRegistro";
		}else {
			adService.insert(admin);
			return "redirect:/administradores/new";
		}
	}
	
	@GetMapping("/list")
	public String listAdmin(Model model) {
		try {
			model.addAttribute("listaAdministradores", adService.lista());
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/administrador/frmLista";
	}
	
	@RequestMapping("/delete")
	public String deleteAdmin(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				adService.delete(id);
				model.put("listaAdministradores", adService.lista());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}
		return "/administrador/frmLista";
	}
	
}
