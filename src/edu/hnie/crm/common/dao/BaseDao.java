package edu.hnie.crm.common.dao;

import edu.hnie.crm.common.domain.PageBean;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T> {
    public void add(T t);
    public void update(T t);
    public void delete(T t);
    public T findById(Class<T> clazz, Serializable id);
    public List<T> findAll(String hql);
    public <P> List<T> find(String hql,P... params);

    /**
     * 分页查询
     * @param hql 用于查询总记录数的hql语句
     * @param clazz 要查询的领域对象的class
     * @param pc 当前页
     * @param ps 每页记录数
     * @return
    public PageBean<T> findByLimit(String hql,Class<T> clazz , int pc,int ps);

    *//**
     * 查询总记录数
     * @param hql
     * @return
     *//*
    public int findCount(String hql);*/


    /**
     * 查询总记录数  count(*)
     * @param clazz
     * @return
     */
    public int findCount(Class<T> clazz);

    /**
     * 分页查询
     * @param clazz 要查询的表所对应的领域对象
     * @param pc 当前页
     * @param ps 每页记录数
     * @return PageBean
     */
    public PageBean<T> findByLimit(Class<T> clazz , int pc,int ps);
}
