package ua.goit.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.dao.BusinessPlanDao;
import ua.goit.entity.BusinessPlan;

import java.util.List;

/**
 * Created by Guillaume Gingembre on 15/09/2017.
 */

@Service
public class BusinessPlanService {

    private final BusinessPlanDao dao;

    @Autowired
    public BusinessPlanService(BusinessPlanDao dao) {
        this.dao = dao;
    }

    @Transactional
    public <S extends BusinessPlan> S save(S s) {
        return dao.save(s);
    }

    @Transactional(readOnly = true)
    public List<BusinessPlan> findAll() {
        return dao.findAll();
    }

    @Transactional(readOnly = true)
    public BusinessPlan findOne(Long s) {
        return dao.findOne(s);
    }

    @Transactional(readOnly = true)
    public boolean exists(Long s) {
        return dao.exists(s);
    }

    @Transactional
    public void delete(long s) {
        BusinessPlan entity = dao.findById(s);
            dao.delete(entity);
    }

    @Transactional
    public void delete(BusinessPlan entity) {
        dao.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<BusinessPlan> findAllExample (BusinessPlan businessPlan) {

        if (businessPlan.getAddress().getTown().isEmpty()) {
            businessPlan.getAddress().setTown(null);
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase()
                .withIgnorePaths("businessplan_id", "projectId", "projects", "address.addressId", "businessPlanLastChange", "isActive")
                .withIgnorePaths("businessPlanExpectedRaise", "businessPlanAmountRaised", "businessPlanMinInv", "businessPlanReturn");
        //    .withMatcher("projectAmountRaised", IsMoreThan(Long.parseLong()));
        // ignore numbers, because I did not find how to deal with ExampleMatcher and numbers
        // I will write my own logic about numbers in the controller, but it is an area of improvement for this code

        Example<BusinessPlan> example = Example.of(businessPlan, matcher);

        return dao.findAll(example);
    }

}
