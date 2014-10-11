package eu.vancl.martin.springrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import eu.vancl.martin.springrest.entity.Role;
import eu.vancl.martin.springrest.service.RoleManager;

@RestController // http://goo.gl/Lo974a
@RequestMapping("/roles")
public class RestRoleController {
	private static final Logger logger = LoggerFactory.getLogger(RestRoleController.class);
	
	@Autowired
	private RoleManager roleManager;
	
	/**
	 * Vrati JSON se vsemi rolemi.
	 * Test:
	 * 	http://localhost:8080/springrest/role/all
	 * 	$ curl http://localhost:8080/springrest/role/all
	 */
	@ResponseBody
	@RequestMapping(value="", method = RequestMethod.GET)
	public List<Role> getAllRoles() {
		return roleManager.findAll();		
	}

	/**
	 * Vrati JSON pro pozadovanou roli. Zadava se ID role.
	 * Pokud role v DB neni, vrati se prazdna odpoved (ne json s null, nevrati se vubec nic).
	 * Test:
	 * 	http://localhost:8080/springrest/role/getById/1
	 * 	$ curl http://localhost:8080/springrest/role/getById/1
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody Role getRoleById(@PathVariable int id) {
		logger.info("_ID_ " + id);		
		return roleManager.findById(id);
	}
	
	/**
	 * Vytvori novou roli podle prijateho JSONu.
	 * Test:
	 * 	$ curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d '{"id":5,"name":"JSON role 5"}' http://localhost:8080/springrest/role/create
	 * Derby databaze si sama resi auto-increment id, proto asi bude id v jsonu ignorovat.
	 */
	@ResponseBody
	@RequestMapping(value="/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createNewRole(@RequestBody Role input) {
		logger.info("_CREATE_ROLE_ " + input.toString());
		roleManager.save(input);		
	}
	
}
