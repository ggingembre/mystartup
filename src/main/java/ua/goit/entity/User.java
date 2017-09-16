package ua.goit.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Maryna Kontar on 23.08.2017.
 * @KontarMaryna
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    private String username;
    private String password;

    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    private String profileFotoLink;
    private String personalPageFotoLink;

    private String youtubeLink;
    private String aboutMe;

    private String skills;

    @ElementCollection(targetClass=Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="user_roles")
    @Column(name="role") // Column name in user_roles
    private Collection<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getProfileFotoLink() {
        return profileFotoLink;
    }

    public void setProfileFotoLink(String profileFotoLink) {
        this.profileFotoLink = profileFotoLink;
    }

    public String getPersonalPageFotoLink() {
        return personalPageFotoLink;
    }

    public void setPersonalPageFotoLink(String personalPageFotoLink) {
        this.personalPageFotoLink = personalPageFotoLink;
    }

    public String getYoutubeLink() {
        return youtubeLink;
    }

    public void setYoutubeLink(String youtubeLink) {
        this.youtubeLink = youtubeLink;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", contact=" + contact +
                ", profileFotoLink='" + profileFotoLink + '\'' +
                ", personalPageFotoLink='" + personalPageFotoLink + '\'' +
                ", youtubeLink='" + youtubeLink + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                ", skills='" + skills + '\'' +
                ", roles=" + roles +
                '}';
    }
}
