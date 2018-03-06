package edu.hnie.crm.linkman.dao;

import edu.hnie.crm.common.dao.BaseDao;
import edu.hnie.crm.linkman.domain.LinkMan;

import java.util.List;

public interface LinkManDao extends BaseDao<LinkMan> {

    public List<LinkMan> findMoreCondition(LinkMan linkMan);
}
