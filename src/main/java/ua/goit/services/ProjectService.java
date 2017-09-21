package ua.goit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.goit.dao.ProjectDao;
import ua.goit.entity.Project;

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
    public List<Project> findAll() {
        return dao.findAll();
    }

    @Transactional // (readOnly = true)
    public Project findOne(Long s) {
        return dao.findOne(s);
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

}
