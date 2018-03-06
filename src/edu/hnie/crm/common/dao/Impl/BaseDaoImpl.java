package edu.hnie.crm.common.dao.Impl;

import edu.hnie.crm.common.dao.BaseDao;
import edu.hnie.crm.common.domain.PageBean;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;

import java.io.Serializable;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
    private HibernateTemplate hibernateTemplate;

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Override
    public void add(T t) {
        hibernateTemplate.save(t);
    }

    @Override
    public void update(T t) {
        hibernateTemplate.update(t);
    }

    @Override
    public void delete(T t) {
        hibernateTemplate.delete(t);
    }

    @Override
    public T findById(Class<T> clazz, Serializable id) {
        T t = hibernateTemplate.get(clazz, id);
        return t;
    }

    @Override
    public List<T> findAll(String hql) {
        List<T> list = (List<T>) hibernateTemplate.find(hql);
        return list;
    }

    @Override
    public <P> List<T> find(String hql, P... params) {
        List<T> list = (List<T>) hibernateTemplate.find(hql, params);
        return list;
    }

    /*@Override
    public PageBean<T> findByLimit(String hql,Class<T> clazz,int pc, int ps) {
        PageBean<T> pageBean = new PageBean<>();
        pageBean.setPc(pc);
        pageBean.setPs(ps);
        int tr = findCount(hql);
        pageBean.setTr(tr);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(clazz);
        List<T> list = (List<T>) hibernateTemplate.findByCriteria(detachedCriteria,(pc-1)*ps,ps);
        pageBean.setBeanList(list);
        return pageBean;
    }

    @Override
    public int findCount(String hql) {
        List<Object> list = (List<Object>) hibernateTemplate.find(hql);
        int count = 0;
        if(list != null && list.size() > 0){
            Object obj = list.get(0);
            Long lobj = (Long) obj;
            count = lobj.intValue();
        }

        return count;
    }*/

    @Override
    public int findCount(Class<T> clazz) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(clazz);
        detachedCriteria.setProjection(Projections.rowCount());
        List<Object> list = (List<Object>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if(CollectionUtils.isNotEmpty(list)){
            Object obj = list.get(0);
            Long lobj = (Long) obj;
            int count = lobj.intValue();
            return count;
        }
        return 0;
    }

    @Override
    public PageBean<T> findByLimit(Class<T> clazz, int pc, int ps) {
        PageBean<T> pageBean = new PageBean<>();
        pageBean.setPc(pc);
        pageBean.setPs(ps);
        int count = findCount(clazz);
        pageBean.setTr(count);
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(clazz);
        List<T> list = (List<T>) hibernateTemplate.findByCriteria(detachedCriteria,(pc-1)*ps,ps);
        pageBean.setBeanList(list);
        return pageBean;
    }
}
