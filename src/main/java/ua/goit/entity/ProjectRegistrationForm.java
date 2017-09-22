package ua.goit.entity;

/**
 * Created by Guillaume Gingembre on 22/09/2017.
 */
public class ProjectRegistrationForm {

    private Project project;
    private Address address;

    public ProjectRegistrationForm() {
    }

    public ProjectRegistrationForm(Project project, Address address) {
        this.project = project;
        this.address = address;
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
}
