package ua.goit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.entity.BusinessPlan;


/**
 * Created by Guillaume Gingembre on 15/09/2017.
 */

public interface BusinessPlanDao extends JpaRepository<BusinessPlan, Long> {

        /*Project findByName(String name);
    List<Project> findByIndustry(String industry);
    List<Project> findByRegion(String region);
    List<Project> findByInvSize(long invSize);
    List<Project> findByMinIrr(long minIrr);
    List<Project> findActive();*/
}
