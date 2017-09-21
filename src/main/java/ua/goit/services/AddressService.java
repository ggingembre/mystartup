package ua.goit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.dao.AddressDao;
import ua.goit.entity.Address;

import java.util.List;

/**
 * Created by Guillaume Gingembre on 21/09/2017.
 */
@Service
public class AddressService {

    private final AddressDao dao;

    @Autowired
    public AddressService(AddressDao dao) {
        this.dao = dao;
    }

    @Transactional
    public <S extends Address> S save(S s) {
        return dao.save(s);
    }

    @Transactional(readOnly = true)
    public List<Address> findAll() {return dao.findAll();}

    @Transactional // (readOnly = true)
    public Address findOne(Long s) {
        return dao.findOne(s);
    }

}
