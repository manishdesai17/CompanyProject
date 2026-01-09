package com.login.login.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class BidderDTO {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String panCard;
    private String phone;
    private Integer isVerified;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BidderDTO(Long id, String name, String email, String password, String panCard, String phone, Integer isVerified, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.panCard = panCard;
        this.phone = phone;
        this.isVerified = isVerified;
        this.status = status;
    }

    public BidderDTO() {
    }

    @Override
    public String toString() {
        return "BidderDTO{" +
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
