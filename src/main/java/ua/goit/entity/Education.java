package ua.goit.entity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Maryna Kontar on 23.08.2017.
 *
 * @KontarMaryna
 */
@Entity
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String educationalInstitution;
    private String educationalStage;
    private String faculty;
    private String fieldOfStudy;

    @Enumerated(EnumType.STRING)
    private ModeOfStudy modeOfStudy;
    private LocalDate fromDate;
    private LocalDate until;

    public Education() {
    }

    public Education(String educationalInstitution, String educationalStage, String faculty, String fieldOfStudy,
                     ModeOfStudy modeOfStudy, LocalDate from, LocalDate until) {
        this.educationalInstitution = educationalInstitution;
        this.educationalStage = educationalStage;
        this.faculty = faculty;
        this.fieldOfStudy = fieldOfStudy;
        this.modeOfStudy = modeOfStudy;
        this.fromDate = from;
        this.until = until;
    }

    public Long getId() {
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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getUntil() {
        return until;
    }

    public void setUntil(LocalDate until) {
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
                ", fromDate=" + fromDate +
                ", until=" + until +
                '}';
    }
}
