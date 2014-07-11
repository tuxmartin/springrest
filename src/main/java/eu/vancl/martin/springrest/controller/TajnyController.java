package eu.vancl.martin.springrest.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.vancl.martin.springrest.service.RoleManager;

@Controller
public class TajnyController {
	
	private static final Logger logger = LoggerFactory.getLogger(TajnyController.class);
		
	@Autowired
	private RoleManager roleManager;

	@PreAuthorize("isFullyAuthenticated()")
	@RequestMapping(value = "/tajny", method = RequestMethod.GET)
	public String tajny(Model model, Principal principal) {	
		model.addAttribute("text", "pouze pro prihlaseneho uzivatele i admina");
		
		String name = principal.getName(); //get logged in username
		logger.info("username = " + name);
	      
		return "tajny";
	}
	
	// http://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html
	
	@PreAuthorize("hasRole('ROLE_ADMIN')") // pouze pro admina
	@RequestMapping(value = "/tajny/admin", method = RequestMethod.GET)
	public String tajnyAdmin(Model model) {		
		model.addAttribute("text", "pouze pro prihlaseneho admina");
		return "tajny";
	}
	
}
