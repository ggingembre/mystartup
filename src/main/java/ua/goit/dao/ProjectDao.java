package ua.goit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.entity.Project;

import java.io.Serializable;
import java.lang.invoke.SerializedLambda;


/**
 * Created by Guillaume Gingembre on 13/09/2017.
 */

/**
 * Data access object for {@link Project}
 */

@EnableJpaRepositories(basePackages = "com.acme.repositories.jpa")
public interface ProjectDao extends JpaRepository<Project, Long> {

    /*Project findByName(String name);
    List<Project> findByIndustry(String industry);
    List<Project> findByRegion(String region);
    List<Project> findByInvSize(long invSize);
    List<Project> findByMinIrr(long minIrr);
    List<Project> findActive();*/

    Project findByProjectId(long id);


}
