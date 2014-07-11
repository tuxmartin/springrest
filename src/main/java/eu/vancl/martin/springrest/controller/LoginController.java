package eu.vancl.martin.springrest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import eu.vancl.martin.springrest.entity.User;

/**
 * metody prihlasovani a odhlasovani
 */
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.addAttribute("user", new User()); // kvuli registracnimu formulari
        return "login";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
    	logger.info("LOGIN: neuspesne prihlaseni");
        model.addAttribute("error", "true");
        return "login";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
    	logger.info("LOGIN: uzivatel byl odhlasen");
        return "redirect:/j_spring_security_logout";
    }

}
