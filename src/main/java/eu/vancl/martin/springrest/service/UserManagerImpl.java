package eu.vancl.martin.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import eu.vancl.martin.springrest.dao.UserDao;
import eu.vancl.martin.springrest.entity.User;

@Service
@Transactional
public class UserManagerImpl implements UserManager {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }   
 
}
