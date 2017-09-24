package ua.goit.services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.dao.ProjectDao;
import ua.goit.entity.Project;
import ua.goit.entity.Region;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Guillaume Gingembre on 13/09/2017.
 */
@Service
public class ProjectService {

    private final ProjectDao dao;

    @Autowired
    public ProjectService(ProjectDao dao) {
        this.dao = dao;
    }

    @Transactional
    public <S extends Project> S save(S s) {
        return dao.save(s);
    }

    @Transactional(readOnly = true)
    public List<Project> findAllExample (Project project) {

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withIgnoreCase();

        Example<Project> example = Example.of(project, matcher);

        return dao.findAll(example);
    }

    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return dao.findAll();
    }

    @Transactional // (readOnly = true)
    public Project findById(Long s) {
        return dao.findByProjectId( s);
    }

    @Transactional // (readOnly = true)
    public Project findOne(Long s) {
        return dao.findOne( s);
    }

    @Transactional(readOnly = true)
    public boolean exists(Long s) {
        return dao.exists(s);
    }

    @Transactional
    public void delete(Long s) {
        dao.delete(s);
    }

    @Transactional
    public void delete(Project entity) {
        dao.delete(entity);
    }

    /*@Transactional
    public List<Project> getProjects (boolean isActive, double projectReturn, BigDecimal projectMinInv){

        Project project = new Project();

        if(isActive){
            project.setActive(true);
        }
        if(projectReturn!=0.0){
            project.setProjectReturn(projectReturn);
        }
        if(projectMinInv!=null){
            project.setProjectMinInv(projectMinInv);
        }

        return findAllExample(project);

        //Session session = sessionFactory.getCurrentSession();

        // Create CriteriaBuilder
        //CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        //CriteriaQuery<YourClass> criteria = builder.createQuery(YourClass.class);


        //if(projectLastChange!=null){
        //    Specification<Project> dateSpec =
        //}
        //if(endDate!=null){
        //    criteria.add(Expression.le("date",endDate));
        //}
        //if(volume!=null){
        //    criteria.add(Expression.ge("volume",volume));
        //}
        //criteria.addOrder(Order.asc("date"));
//
        //return criteria.list();
    }*/
}
