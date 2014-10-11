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
import eu.vancl.martin.springrest.entity.User;
import eu.vancl.martin.springrest.service.RoleManager;
import eu.vancl.martin.springrest.service.UserManager;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private RoleManager roleManager;
	
	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		/* pro testovani */
		if (roleManager.findByName("Role 1") == null) {
			Role r1 = new Role();
			r1.setName("Role 1");
			roleManager.save(r1);
		}
		
		if (roleManager.findByName("Role 2") == null) {
			Role r2 = new Role();
			r2.setName("Role 2");
			roleManager.save(r2);
		}	
		
		if (userManager.findByUserName("admin@example.net") == null) {
			User admin = new User();
			admin.setUsername("admin@example.net");
			admin.setPassword("8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92"); // 123456
			admin.setEnabled(true);
			admin.setRole(roleManager.findByName("Role 1"));
			userManager.save(admin);
			logger.info("admin user created: " + admin.toString());
		}
		
		if (userManager.findByUserName("user") == null) {
			User user = new User();
			user.setUsername("user");
			user.setPassword("123456"); // 123456
			user.setEnabled(true);
			user.setRole(roleManager.findByName("Role 2"));
			userManager.save(user);
			logger.info("normal user created: " + user.toString());
		}				
		/* pro testovani */

		model.addAttribute("vsechnyRole", roleManager.findAll());
		
		model.addAttribute("vsichniUzivatele", userManager.findAll());
				
		return "home";
	}
	
}
