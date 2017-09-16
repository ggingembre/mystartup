package ua.goit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.dao.ContactDao;
import ua.goit.dao.UserDao;
import ua.goit.entity.User;

import java.util.List;

/**
 * Created by User on 23.08.2017.
 */
@Service
public class UserService {

    private final UserDao dao;
    private final ContactDao contactDao;
    @Autowired
    public UserService(UserDao dao, ContactDao contactDao) {
        this.dao = dao;
        this.contactDao = contactDao;
    }

    @Transactional(readOnly = true)
    public List<User> findAll() {
        return dao.findAll();
    }

    @Transactional
    public <S extends User> S save(S entity) {
        contactDao.save(entity.getContact());
        return dao.save(entity);
    }

    @Transactional(readOnly = true)
    public User findOne(String s) {
        return dao.findOne(s);
    }

    @Transactional(readOnly = true)
    public boolean exists(String s) {
        return dao.exists(s);
    }

    @Transactional
    public void delete(String s) {
        dao.delete(s);
    }

    @Transactional
    public void delete(User entity) {
        dao.delete(entity);
    }


}