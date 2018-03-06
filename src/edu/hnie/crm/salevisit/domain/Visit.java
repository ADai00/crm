package edu.hnie.crm.salevisit.domain;

import edu.hnie.crm.customer.domain.Customer;
import edu.hnie.crm.user.domain.User;

import java.io.Serializable;

/**
 * 拜访实体类
 */
public class Visit implements Serializable{
    private Integer vid;
    private String vaddress;
    private String vcontent;

    private User user;

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getVid() {
        return vid;
    }

    public void setVid(Integer vid) {
        this.vid = vid;
    }

    public String getVaddress() {
        return vaddress;
    }

    public void setVaddress(String vaddress) {
        this.vaddress = vaddress;
    }

    public String getVcontent() {
        return vcontent;
    }

    public void setVcontent(String vcontent) {
        this.vcontent = vcontent;
    }
}
