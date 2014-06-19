package eu.vancl.martin.springrest.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.vancl.martin.springrest.entity.Role;
import eu.vancl.martin.springrest.service.RoleManager;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private RoleManager roleManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		

		Role r = roleManager.findById(1);
		if (r != null) {
			logger.info("___" + r.getName());	
			model.addAttribute("role", r);
		}	

		model.addAttribute("vsechnyRole", roleManager.findAll());
				
		return "home";
	}
	
}
