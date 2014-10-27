package eu.vancl.martin.springrest.controller.restAPIv1;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eu.vancl.martin.springrest.entity.User;
import eu.vancl.martin.springrest.service.UserManager;

// rucni prace s JSONem
@Controller
@RequestMapping("/api/v1/users")
public class JSONUserController {
	private static final Logger logger = LoggerFactory.getLogger(JSONUserController.class);
	
	@Autowired
	UserManager userManager;
	
	@RequestMapping(value="", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<List<JSONObject>> getAll() {
		
		List<User> usersList = userManager.findAll();
		
		List<JSONObject> users = new ArrayList<JSONObject>();
		for (User user : usersList) {
			JSONObject u = new JSONObject();
			u.put("id", user.getId());
			u.put("username", user.getUsername());
			u.put("password", user.getPassword());
			u.put("enabled", user.isEnabled());
			u.put("roleName", user.getRole().getName());
		}
		
		return new ResponseEntity<List<JSONObject>>(users, HttpStatus.OK);		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<JSONObject> getById(@PathVariable("id") int id) {
		User user = userManager.findById(id);
		JSONObject o = new JSONObject();
		
		if (user == null) {
			logger.error("Uzivatel ID " + id + " neexistuje!");
			o.put("error", "Uzivatel ID " + id + " neexistuje!");
			return new ResponseEntity<JSONObject>(o, HttpStatus.NOT_FOUND); // 404			
		}
		
		o.put("id", user.getId());
		o.put("username", user.getUsername());
		o.put("password", user.getPassword());
		o.put("enabled", user.isEnabled());
		o.put("roleName", user.getRole().getName());
		
		return new ResponseEntity<JSONObject>(o, HttpStatus.OK); // 200
	}
	
	
	

}
