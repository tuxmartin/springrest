package eu.vancl.martin.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.vancl.martin.springrest.dao.RoleDao;
import eu.vancl.martin.springrest.entity.Role;
import eu.vancl.martin.springrest.entity.User;

@Service
@Transactional
public class RoleManagerImpl implements RoleManager {

	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

	@Override
	public Role findById(int id) {
		return roleDao.findById(id);
	}

	@Override
	public Role findByName(String name) {
		return roleDao.findByName(name);
	}

	@Override
	public void save(Role role) {
		roleDao.save(role);
	}

	@Override
	public void delete(Role role) {
		roleDao.delete(role);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

}
