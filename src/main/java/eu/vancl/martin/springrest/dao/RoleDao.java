package eu.vancl.martin.springrest.dao;

import java.util.List;

import eu.vancl.martin.springrest.entity.Role;

public interface RoleDao {
	
	public void save(Role role);

	public void delete(Role role);

	public void update(Role role);

    public List<Role> findAll();

    public Role findById(int id);
    
    public Role findByName(String name);

}
