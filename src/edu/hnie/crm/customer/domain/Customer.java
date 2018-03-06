package edu.hnie.crm.customer.domain;

import edu.hnie.crm.linkman.domain.LinkMan;
import edu.hnie.crm.salevisit.domain.Visit;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Customer implements Serializable {
    private Integer cid;
    private String custName;
//    private String custLevel;
    private String custSource;
    private String custPhone;
    private String custMobile;

    private Set<Visit> visitSet = new HashSet<>();

    private Set<LinkMan> linkManSet = new HashSet<>();

    private Dict dictCustLevel;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustMobile() {
        return custMobile;
    }

    public void setCustMobile(String custMobile) {
        this.custMobile = custMobile;
    }

    public Set<Visit> getVisitSet() {
        return visitSet;
    }

    public void setVisitSet(Set<Visit> visitSet) {
        this.visitSet = visitSet;
    }

    public Set<LinkMan> getLinkManSet() {
        return linkManSet;
    }

    public void setLinkManSet(Set<LinkMan> linkManSet) {
        this.linkManSet = linkManSet;
    }

    public Dict getDictCustLevel() {
        return dictCustLevel;
    }

    public void setDictCustLevel(Dict dictCustLevel) {
        this.dictCustLevel = dictCustLevel;
    }
}
