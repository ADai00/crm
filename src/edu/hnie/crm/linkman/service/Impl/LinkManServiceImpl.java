package edu.hnie.crm.linkman.service.Impl;

import edu.hnie.crm.linkman.dao.LinkManDao;
import edu.hnie.crm.linkman.domain.LinkMan;
import edu.hnie.crm.linkman.service.LinkManService;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public class LinkManServiceImpl implements LinkManService {

    private LinkManDao linkManDao;

    public void setLinkManDao(LinkManDao linkManDao) {
        this.linkManDao = linkManDao;
    }

    @Override
    public void add(LinkMan linkMan) {
        linkManDao.add(linkMan);
    }

    @Override
    public void update(LinkMan linkMan) {
        linkManDao.update(linkMan);
    }

    @Override
    public void delete(LinkMan linkMan) {
        linkManDao.delete(linkMan);
    }

    @Override
    public LinkMan findLinkManById(Serializable id) {
        LinkMan linkMan = linkManDao.findById(LinkMan.class, id);
        return linkMan;
    }

    @Override
    public List<LinkMan> findAllLinkMan() {
        String hql = "from LinkMan";
        List<LinkMan> linkManList = linkManDao.findAll(hql);
        return linkManList;
    }

    @Override
    public List<LinkMan> findMoreCondition(LinkMan linkMan) {
        List<LinkMan> linkManList = linkManDao.findMoreCondition(linkMan);
        return linkManList;
    }
}
