package ua.goit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.goit.entity.Experience;

/**
 * Created by User on 16.09.2017.
 */
public interface ExperienceDao extends JpaRepository<Experience, Long> {
}
