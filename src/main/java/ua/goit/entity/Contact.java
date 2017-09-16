package ua.goit.entity;

import javax.persistence.*;

/**
 * Created by Maryna Kontar on 13.09.2017.
 * @KontarMaryna
 */
//@Embeddable  ////можно сделать вложенную таблицу (убрать private long id)
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //    @Email
    private String email;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private City city;
    @Enumerated(EnumType.STRING)
    private Country country;

    public Contact() {
    }

    public Contact(String email, String phoneNumber, City city, Country country) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city=" + city +
                ", country=" + country +
                '}';
    }
}
