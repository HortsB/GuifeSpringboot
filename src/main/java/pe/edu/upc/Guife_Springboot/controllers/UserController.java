package pe.edu.upc.guife.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.upc.guife.entities.Users;
import pe.edu.upc.guife.serviceinterface.IUserService;

@Controller
@RequestMapping("/usuarios")
public class UserController {

	@Autowired
	private IUserService uService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/nuevo")
	public String NewUser(Model model) {
		model.addAttribute("u", new Users());
		return "user/usuario";
	}
	
	@PostMapping("/guardar")
	public String saveUser(@Valid Users objUser, BindingResult binRes, Model model ) {
		if(binRes.hasErrors()) {
			return "user/usuario";
		} else {
			String p=objUser.getPassword();
			String pE= passwordEncoder.encode(p);
			Users us=new Users();
			us.setUsername(objUser.getUsername());
			us.setEnabled(objUser.getEnabled());
			us.setPassword(pE);
			uService.insertar(us);
			model.addAttribute("mensaje", "Se guardo correctamente");
			return "redirect:/usuarios/listar";
		}
	}
	
	@GetMapping("/listar")
	public String listUsuarios(Model model) {
		try {
			model.addAttribute("listaUsuarios", uService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/user/listaUsuario";
	}
}
