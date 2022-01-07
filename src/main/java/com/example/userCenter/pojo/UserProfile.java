package com.example.userCenter.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="user_profile")
public class UserProfile implements Serializable {

    @Id
    @Column(name = "user_id", nullable = false, length = 48)
    private String userId;

    @Column(name = "photo", length = 32)
    private String photo;

    @Column(name = "personal_profile", length = 1024)
    private String personalProfile;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }

    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }
}
