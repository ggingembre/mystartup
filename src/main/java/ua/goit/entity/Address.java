package ua.goit.entity;

import javax.persistence.*;

/**
 * Created by Guillaume Gingembre on 14/09/2017.
 */

@Entity
@Table(name = "address")
public class Address {


    @Id
    @GeneratedValue
    @Column(name = "address_id", updatable=false, nullable=false)
    private long addressId;

    @Column(name = "town")
    private String town;

    @Column(name = "region")
    private Region region;

    @Column(name = "country")
    private Country country;


    public Address(){}

    public Address(String town, Region region, Country country) {
        this.town = town;
        this.region = region;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (addressId != address.addressId) return false;
        if (!town.equals(address.town)) return false;
        if (region != address.region) return false;
        return country == address.country;
    }

    @Override
    public int hashCode() {
        int result = (int) (addressId ^ (addressId >>> 32));
        result = 31 * result + town.hashCode();
        result = 31 * result + region.hashCode();
        result = 31 * result + country.hashCode();
        return result;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", town='" + town + '\'' +
                ", region=" + region +
                ", country=" + country +
                '}';
    }





}
