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

import pe.edu.upc.guife.entities.Customer;
import pe.edu.upc.guife.serviceinterface.ICustomerService;
import pe.edu.upc.guife.serviceinterface.IPersonService;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	
	@Autowired
	private ICustomerService cuService;
	
	@Autowired
	private IPersonService pService;
	
	@GetMapping("/new")
	public String newAdmin(Model model) {
		model.addAttribute("cu", new Customer());
		model.addAttribute("listaPersonas", pService.list());
		return "customer/frmRegistro";
	}
	
	@PostMapping("/save")
	public String saveAdmin(@Valid Customer customer, BindingResult binRes, Model model) {
		if(binRes.hasErrors()) {
			return "customer/frmRegistro";
		}else {
			cuService.insert(customer);
			return "redirect:/customers/new";
		}
	}
	
	@GetMapping("/list")
	public String listAdmin(Model model) {
		try {
			model.addAttribute("listaCustomers", cuService.lista());
		}catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/customer/frmLista";
	}
	
	@RequestMapping("/delete")
	public String deleteAdmin(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				cuService.delete(id);
				model.put("listaCustomers", cuService.lista());
			}
		} catch (Exception e) {
			// TODO: handle exception
			model.put("error", e.getMessage());
		}
		return "/customer/frmLista";
	}
	
}
