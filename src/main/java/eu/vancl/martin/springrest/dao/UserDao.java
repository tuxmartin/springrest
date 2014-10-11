package eu.vancl.martin.springrest.dao;

import java.util.List;

import eu.vancl.martin.springrest.entity.User;

public interface UserDao {

    public void save(User user);

    public void delete(User user);

    public void update(User user);

    public List<User> findAll();

    public User findById(int id);
    
    public User findByUserName(String username);
    
}
