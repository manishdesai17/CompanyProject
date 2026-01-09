package com.login.login.dto;

public class BidderVerifiedDTO {
    private String email;
    private Integer isVerified;
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Integer isVerified) {
        this.isVerified = isVerified;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BidderVerifiedDTO(String email, Integer isVerified, String password) {
        this.email = email;
        this.isVerified = isVerified;
        this.password = password;
    }
}
