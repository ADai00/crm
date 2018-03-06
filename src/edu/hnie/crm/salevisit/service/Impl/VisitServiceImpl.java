package edu.hnie.crm.salevisit.service.Impl;

import edu.hnie.crm.salevisit.dao.VisitDao;
import edu.hnie.crm.salevisit.domain.Visit;
import edu.hnie.crm.salevisit.service.VisitService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class VisitServiceImpl implements VisitService{

    private VisitDao visitDao;

    public void setVisitDao(VisitDao visitDao) {
        this.visitDao = visitDao;
    }

    @Override
    public void addVisit(Visit visit) {
        visitDao.add(visit);
    }

    @Override
    public List<Visit> findAllVisit() {
        String hql = "from Visit";
        List<Visit> visitList = visitDao.findAll(hql);
        return visitList;
    }
}
