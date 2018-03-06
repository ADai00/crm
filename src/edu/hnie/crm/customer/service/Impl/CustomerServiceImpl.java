package edu.hnie.crm.customer.service.Impl;

import edu.hnie.crm.common.domain.PageBean;
import edu.hnie.crm.customer.dao.CustomerDao;
import edu.hnie.crm.customer.domain.Customer;
import edu.hnie.crm.customer.service.CustomerService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDao.add(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerDao.update(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        String hql = "from Customer";
        List<Customer> customerList = customerDao.findAll(hql);
        return customerList;
    }

    @Override
    public Customer findCustomerById(Serializable id) {
        Customer customer = customerDao.findById(Customer.class,id);
        return customer;
    }

    /**
     * 分页查找
     * @param pc
     * @param ps
     * @return
     */
    @Override
    public PageBean<Customer> findByLimit(int pc, int ps) {
       /* String hql = "select count(*) from Customer";
        PageBean pageBean = customerDao.findByLimit(hql,Customer.class,pc,ps);*/

        PageBean pageBean = customerDao.findByLimit(Customer.class,pc,ps);
        return pageBean;
    }

    @Override
    public List<Customer> findCondition(Customer customer) {

        List<Customer> customerList = customerDao.findCondition(customer);
        return customerList;
    }

    @Override
    public Customer findCustomerByName(String custName) {
        String hql = "from Customer where custName = ?";
        List<Customer> list = customerDao.find(hql,custName);
        if(list!=null && list.size()>0){
            Customer customer = list.get(0);
            return customer;
        }
        return null;
    }

    @Override
    public List<Customer> findMoreCondition(Customer customer) {
        /*String hql = "from Customer where 1=1";
        List<Customer> customerList = customerDao.findMoreCondition(hql,customer);*/
        List<Customer> customerList = customerDao.findMoreCondition(customer);
        return customerList;
    }

    @Override
    public List findCountSource() {
        List list = customerDao.findCountSource();
        return list;
    }

    @Override
    public List findCountLevel() {
        List list = customerDao.findCountLevel();
        return list;
    }
}
