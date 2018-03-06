package edu.hnie.crm.salevisit.service;

import edu.hnie.crm.salevisit.domain.Visit;

import java.util.List;

public interface VisitService {
    public void addVisit(Visit visit);

    public List<Visit> findAllVisit();
}
