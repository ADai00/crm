package edu.hnie.crm.customer.domain;

import java.io.Serializable;

/**
 * 数据字典 用来保存客户级别
 */
public class Dict implements Serializable{
    private Integer did;
    private String dname;


    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
