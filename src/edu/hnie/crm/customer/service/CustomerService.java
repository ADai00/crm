package edu.hnie.crm.customer.service;

import edu.hnie.crm.common.domain.PageBean;
import edu.hnie.crm.customer.domain.Customer;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import java.io.Serializable;
import java.util.List;

public interface CustomerService {
    public void addCustomer(Customer customer);

    public void updateCustomer(Customer customer);

    public void deleteCustomer(Customer customer);

    public List<Customer> findAllCustomer();

    public Customer findCustomerById(Serializable id);

    public PageBean<Customer> findByLimit(int pc,int ps);

    public List<Customer> findCondition(Customer customer);

    public Customer findCustomerByName(String custName);

    public List<Customer> findMoreCondition(Customer customer);

    public List findCountSource();

    public List findCountLevel();
}
