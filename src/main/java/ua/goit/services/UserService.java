package ua.goit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.dao.ContactDao;
import ua.goit.dao.UserDao;
import ua.goit.entity.Contact;
import ua.goit.entity.User;

import java.util.Collection;
import java.util.List;

/**
 * Service for {@link ua.goit.entity.User} which will use
 * {@link ua.goit.dao.UserDao} and  {@link ua.goit.dao.ContactDao} as data access object
 * @KontarMaryna
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
        //TODO не надо проверять есть ли в бд такой contact  или experiences, потому что пока в приложении сделано так, что они индивидуальны
        Contact contact = entity.getContact();
        if (contact != null) {
            contactDao.save(contact);//нужно для случая @OneToOne Contact; в случае @Embeddable Contact - убрать
        }
//        Collection<Experience> experiences = entity.getExperiences();
//        if (experiences != null ) {
//            experienceDao.save(entity.getExperiences());
//        }
        return dao.save(entity);
    }

    @Transactional(readOnly = true)
    public User findOne(String s) {
        return dao.findOne(s);
    }

    @Transactional(readOnly = true)
    public User getOne(String s) {
        return dao.getOne(s);
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
