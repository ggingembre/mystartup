package ua.goit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.entity.Contact;

/**
 * Data access object for {@link ua.goit.entity.Contact}
 * @KontarMaryna
 */
public interface ContactDao extends JpaRepository<Contact, Long> {
}
