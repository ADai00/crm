package edu.hnie.crm.customer.dao;

import edu.hnie.crm.common.dao.BaseDao;
import edu.hnie.crm.customer.domain.Customer;

import java.util.List;

public interface CustomerDao extends BaseDao<Customer> {

    public List<Customer> findCondition(Customer customer);

    public List<Customer> findMoreCondition(String hql,Customer customer);

    public List<Customer> findMoreCondition(Customer customer);

    public List findCountSource();

    public List findCountLevel();
}
