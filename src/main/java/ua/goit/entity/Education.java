package ua.goit.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by User on 13.09.2017.
 */
//@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String educationalInstitution;
    private String educationalStage;
    private String faculty;
    private String fieldOfStudy;

    @Enumerated(EnumType.STRING)
    private ModeOfStudy modeOfStudy;
    private Timestamp from;
    private Timestamp until;

    public long getId() {
        return id;
    }

    public String getEducationalInstitution() {
        return educationalInstitution;
    }

    public void setEducationalInstitution(String educationalInstitution) {
        this.educationalInstitution = educationalInstitution;
    }

    public String getEducationalStage() {
        return educationalStage;
    }

    public void setEducationalStage(String educationalStage) {
        this.educationalStage = educationalStage;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    public ModeOfStudy getModeOfStudy() {
        return modeOfStudy;
    }

    public void setModeOfStudy(ModeOfStudy modeOfStudy) {
        this.modeOfStudy = modeOfStudy;
    }

    public Timestamp getFrom() {
        return from;
    }

    public void setFrom(Timestamp from) {
        this.from = from;
    }

    public Timestamp getUntil() {
        return until;
    }

    public void setUntil(Timestamp until) {
        this.until = until;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", educationalInstitution='" + educationalInstitution + '\'' +
                ", educationaStage='" + educationalStage + '\'' +
                ", faculty='" + faculty + '\'' +
                ", fieldOfStudy='" + fieldOfStudy + '\'' +
                ", modeOfStudy=" + modeOfStudy +
                ", from=" + from +
                ", until=" + until +
                '}';
    }
}
