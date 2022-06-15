package pe.edu.upc.guife.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.guife.entities.Role;
import pe.edu.upc.guife.serviceinterface.IRoleService;
import pe.edu.upc.guife.serviceinterface.IUserService;

@Controller
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private IRoleService rService;
	
	@Autowired 
	private IUserService uService;
	
	@GetMapping("/nuevo")
	public String NewRole(Model model) {
		model.addAttribute("r", new Role());
		model.addAttribute("listaUsuarios", uService.listar());
		return "role/role";
	}
	
	@PostMapping("/guardar")
	public String saveRole(@Valid Role objRol, BindingResult binRes, Model model ) {
		if(binRes.hasErrors()) {
			return "role/role";
		} else {
			rService.insertar(objRol);
			model.addAttribute("mensaje", "Se guardo correctamente");
			return "redirect:/roles/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listarRoles(Model model) {
		try {
			model.addAttribute("listaRoles", rService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/role/listaRole";
	}
	
}
