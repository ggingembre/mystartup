package ua.goit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.entity.Address;

/**
 * Created by Guillaume Gingembre on 21/09/2017.
 */

public interface AddressDao extends JpaRepository<Address, Long> {
}
