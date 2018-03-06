package edu.hnie.crm.linkman.service;

import edu.hnie.crm.linkman.domain.LinkMan;
import sun.awt.image.ImageWatched;

import java.io.Serializable;
import java.util.List;

public interface LinkManService {
    public void add(LinkMan linkMan);

    public void update(LinkMan linkMan);

    public void delete(LinkMan linkMan);

    public LinkMan findLinkManById(Serializable id);

    public List<LinkMan> findAllLinkMan();

    public List<LinkMan> findMoreCondition(LinkMan linkMan);

}
