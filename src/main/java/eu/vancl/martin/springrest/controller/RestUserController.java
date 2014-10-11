package eu.vancl.martin.springrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import eu.vancl.martin.springrest.entity.User;
import eu.vancl.martin.springrest.service.UserManager;

@RestController // http://goo.gl/Lo974a
@RequestMapping("/users")
public class RestUserController {
	private static final Logger logger = LoggerFactory.getLogger(RestUserController.class);
	
	@Autowired
	private UserManager userManager;
	
	@ResponseBody
	@RequestMapping(value="", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userManager.findAll();		
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody User getUserById(@PathVariable int id) {
		logger.info("_ID_ " + id);
		return userManager.findById(id);
	}
}
