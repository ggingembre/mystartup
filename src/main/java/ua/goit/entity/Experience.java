package ua.goit.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

/**
 * Created by Maryna Kontar on 23.08.2017.
 *
 * @KontarMaryna
 */
@Entity
@Table(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String company;
    private String position;
    private String responsibility;
//    private LocalDate from;
//    private LocalDate until;

//for bidirectional mapping
//    @ManyToOne
//    private User user;

    public Experience() {
    }
//
//    public Experience(String company, String position, String responsibility, LocalDate from, LocalDate until) {
//        this.company = company;
//        this.position = position;
//        this.responsibility = responsibility;
//        this.from = from;
//        this.until = until;
//    }


    public Experience(String company, String position, String responsibility) {
        this.company = company;
        this.position = position;
        this.responsibility = responsibility;
    }

    public long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }

//    public LocalDate getFrom() {
//        return from;
//    }
//
//    public void setFrom(LocalDate from) {
//        this.from = from;
//    }
//
//    public LocalDate getUntil() {
//        return until;
//    }
//
//    public void setUntil(LocalDate until) {
//        this.until = until;
//    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", company='" + company + '\'' +
                ", position='" + position + '\'' +
                ", responsibility='" + responsibility + '\'' +
//                ", from=" + from +
//                ", until=" + until +
                '}';
    }
}
