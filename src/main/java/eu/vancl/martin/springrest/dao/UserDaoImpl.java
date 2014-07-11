package eu.vancl.martin.springrest.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eu.vancl.martin.springrest.entity.User;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
        this.sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void delete(User user) {
        this.sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    public void update(User user) {
        this.sessionFactory.getCurrentSession().update(user);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<User> findAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public User findById(int id) {
        return (User) this.sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public User findByUserName(String username) {       
        return (User) sessionFactory.getCurrentSession()
                .createQuery("FROM User WHERE username = :username")
                .setString("username", username).uniqueResult();
    }
}
