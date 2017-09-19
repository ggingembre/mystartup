package ua.goit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.goit.entity.Project;


/**
 * Created by Guillaume Gingembre on 13/09/2017.
 */

/**
 * Data access object for {@link Project}
 */

public interface ProjectDao extends JpaRepository<Project, Long>{

    /*Project findByName(String name);
    List<Project> findByIndustry(String industry);
    List<Project> findByRegion(String region);
    List<Project> findByInvSize(long invSize);
    List<Project> findByMinIrr(long minIrr);
    List<Project> findActive();*/

}
