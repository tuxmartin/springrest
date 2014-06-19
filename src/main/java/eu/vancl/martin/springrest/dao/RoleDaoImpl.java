package eu.vancl.martin.springrest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eu.vancl.martin.springrest.entity.Role;


@Repository
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
    public Role findById(int id) {
        return (Role) this.sessionFactory.getCurrentSession().get(Role.class, id);
    }

    @Override
    public Role findByName(String name) {

        return (Role) this.sessionFactory.getCurrentSession()
                .createQuery("FROM Role WHERE name = :name")
                .setString("name", name).uniqueResult();
    }

	@Override
	public void save(Role role) {
		this.sessionFactory.getCurrentSession().save(role);
	}

	@Override
	public void delete(Role role) {
		this.sessionFactory.getCurrentSession().delete(role);
	}

	@Override
	public void update(Role role) {
		this.sessionFactory.getCurrentSession().update(role);
	}

	@Override
	public List<Role> findAll() {
		return this.sessionFactory.getCurrentSession().createQuery("FROM Role r ORDER BY r.id ASC").list();
	}


}
