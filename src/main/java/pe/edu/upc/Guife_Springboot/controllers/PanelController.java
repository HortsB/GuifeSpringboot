package pe.edu.upc.Guife_Springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/panel")
public class PanelController {
	@GetMapping("/inicio")
	public String inicio() {
		return "master/inicio";
	}
	@GetMapping("/about")
	public String about() {
		return "master/about";
	}
}
