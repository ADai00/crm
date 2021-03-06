package edu.hnie.crm.user.domain;


import edu.hnie.crm.salevisit.domain.Visit;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable{
    private Integer uid;
    private String username;
    private String password;
    private String address;

    private Set<Visit> visitSet = new HashSet<>();

    public Set<Visit> getVisitSet() {
        return visitSet;
    }

    public void setVisitSet(Set<Visit> visitSet) {
        this.visitSet = visitSet;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
