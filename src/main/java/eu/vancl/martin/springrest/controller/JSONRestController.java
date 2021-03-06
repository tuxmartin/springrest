package eu.vancl.martin.springrest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eu.vancl.martin.springrest.entity.Role;
import eu.vancl.martin.springrest.service.RoleManager;

@RestController // http://goo.gl/Lo974a
@RequestMapping("/roles")
public class JSONRestController {
	// FIXME: nejak nefunguje :-(
	
	private static final Logger logger = LoggerFactory.getLogger(JSONRestController.class);
	
	@Autowired
	private RoleManager roleManager;

	/**
	 * Vrati JSON pro pozadovanou roli. Zadava se ID role.
	 * Pokud role v DB neni, vrati se prazdna odpoved (ne json s null, nevrati se vubec nic).
	 * Test:
	 * 	http://localhost:8080/springrest/roles/1
	 * 	$ curl http://localhost:8080/springrest/roles/1
	 */
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.ALL_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Role getRoleById(@PathVariable int id) {
		logger.info("_ID_ " + id);
		
		/* // Pokud neni db, zakomentovat return dole a odkomentovat: 
		Role r = new Role();
		r.setId(123);
		r.setName("XYZ");
		return r;
		*/
		
		return roleManager.findById(id);
	}
	
	/**
	 * Vytvori novou roli podle prijateho JSONu.
	 * Test:
	 * 	$ curl -X POST -H "Content-Type: application/json" -H "Accept: application/json" -d '{"id":5,"name":"JSON role 5"}' http://localhost:8080/springrest/roles
	 * Derby databaze si sama resi auto-increment id, proto asi bude id v jsonu ignorovat.
	 */
	@ResponseBody
	@RequestMapping(value="", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void createNewRole(@RequestBody Role input) {
		logger.info("_CREATE_ROLE_ " + input.toString());
		roleManager.save(input);		
	}
	
	/**
	 * Vrati JSON se vsemi rolemi.
	 * Test:
	 * 	http://localhost:8080/springrest/roles
	 * 	$ curl http://localhost:8080/springrest/roles
	 */
	@ResponseBody
	@RequestMapping(value="", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public List<Role> getAllRoles() {
		return roleManager.findAll();		
	}

}
