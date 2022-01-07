package com.example.userCenter.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="address")
public class Address implements Serializable {
    @Id
    @Column(name = "user_id", nullable = false, length = 48)
    private String userId;

    @Column(name = "country", length = 8)
    private String country;

    @Column(name = "province", length = 8)
    private String province;

    @Column(name = "city", length = 8)
    private String city;

    @Column(name = "street_address", length = 16)
    private String streetAddress;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String street_address) {
        this.streetAddress = street_address;
    }
}
