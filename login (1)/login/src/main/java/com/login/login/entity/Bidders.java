package com.login.login.entity;

import com.login.login.enums.Status;
import jakarta.persistence.*;

@Entity
public class Bidders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password=null;
    private String panCard;
    private String phone;
    private Integer isVerified;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPanCard() {
        return panCard;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Bidders(Long id, String name, String email, String password, String panCard, String phone, Integer isVerified, Status status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.panCard = panCard;
        this.phone = phone;
        this.isVerified = isVerified;
        this.status = status;
    }

    public Bidders() {
    }

    @Override
    public String toString() {
        return "Bidders{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", panCard='" + panCard + '\'' +
                ", phone='" + phone + '\'' +
                ", isVerified=" + isVerified +
                ", Status='" + status + '\'' +
                '}';
    }
}
