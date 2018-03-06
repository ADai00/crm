package edu.hnie.crm.customer.dao.Impl;

import edu.hnie.crm.common.dao.Impl.BaseDaoImpl;
import edu.hnie.crm.customer.dao.CustomerDao;
import edu.hnie.crm.customer.domain.Customer;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {
    @Override
    public List<Customer> findCondition(Customer customer) {
            // 第一种方式
//        SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
//        Session session = sessionFactory.openSession();
//        Query query = session.createQuery(hql);
//        query.setParameter(0,"%"+customer.getCustName()+"%");
//        List<Customer> customerList = query.list();

        //第二种方式
//        List<Customer> customerList = (List<Customer>) this.getHibernateTemplate().find(hql,"%"+customer.getCustName()+"%");

        //第三种方式
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        detachedCriteria.add(Restrictions.like("custName","%"+customer.getCustName()+"%"));
        List<Customer> customerList = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return customerList;
    }

    @Override
    public List<Customer> findMoreCondition(String hql,Customer customer) {
        List<Object> params = new ArrayList<>();
        if(StringUtils.isNotBlank(customer.getCustName())){
            hql += "and custName=?";
            params.add(customer.getCustName());
        }
        /*if(StringUtils.isNotBlank(customer.getCustLevel())){
            hql += "and custLevel=?";
            params.add(customer.getCustLevel());
        }*/
        if(StringUtils.isNotBlank(customer.getCustSource())){
            hql += "and custSource=?";
            params.add(customer.getCustSource());
        }
        List<Customer> customerList = (List<Customer>) this.getHibernateTemplate().find(hql,params.toArray());
        return customerList;
    }

    @Override
    public List<Customer> findMoreCondition(Customer customer) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        if(StringUtils.isNotBlank(customer.getCustName())) {
            detachedCriteria.add(Restrictions.eq("custName", customer.getCustName()));
        }
        /*if(StringUtils.isNotBlank(customer.getCustLevel())) {
            detachedCriteria.add(Restrictions.eq("custLevel", customer.getCustLevel()));
        }*/
        if(StringUtils.isNotBlank(customer.getCustSource())) {
            detachedCriteria.add(Restrictions.eq("custSource", customer.getCustSource()));
        }
        List<Customer> customerList = (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return customerList;
    }

    @Override
    public List findCountSource() {
        SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        String sql = "SELECT count(*) AS count,custSource FROM t_customer GROUP BY t_customer.custSource";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
        List list = sqlQuery.list();

        return list;
    }

    @Override
    public List findCountLevel() {
        Session session = this.getHibernateTemplate().getSessionFactory().getCurrentSession();
        String sql = "SELECT count(*) AS count,rs.dname FROM (SELECT  * FROM t_customer c INNER  JOIN t_dict d WHERE c.dictCustLevel = d.did) AS rs GROUP BY rs.dictCustLevel";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
        List list = sqlQuery.list();
        return list;
    }
}
