package ua.goit.entity;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import ua.goit.configuration.ModelConfiguration;
import ua.goit.controllers.ShowUsersController;
import ua.goit.services.UserDetailsServiceImpl;
import ua.goit.services.UserService;

import javax.servlet.http.HttpSession;

/**
 * Created by Guillaume Gingembre on 22/09/2017.
 */
public class ProjectRegistrationForm {

    private Project project;
    private Address address;
    //private User user;

    //@Autowired
    //private ModelConfiguration modelConfiguration;
//
    //@Autowired
    //private UserService userService;
//
    //@Autowired
    //UserDetailsServiceImpl userDetailsServiceImpl;

    public ProjectRegistrationForm() {

        //ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        //HttpSession session = attr.getRequest().getSession();

        //String username = modelConfiguration.getDataSource().getUsername();
        // this.user = userService.findOne(username);

        //this.userDetailsService = (UserDetailsServiceImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //this.user =
    }

    public ProjectRegistrationForm(Project project, Address address) {
        this.project = project;
        this.address = address;
        //this.user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    //public User getUser() {
    //    return user;
    //}

    //public void setUser(User user) {
    //    this.user = user;
    //}
}
