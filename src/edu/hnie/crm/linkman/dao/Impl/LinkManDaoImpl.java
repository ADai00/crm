package edu.hnie.crm.linkman.dao.Impl;

import edu.hnie.crm.common.dao.Impl.BaseDaoImpl;
import edu.hnie.crm.linkman.dao.LinkManDao;
import edu.hnie.crm.linkman.domain.LinkMan;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class LinkManDaoImpl extends BaseDaoImpl<LinkMan> implements LinkManDao {
    @Override
    public List<LinkMan> findMoreCondition(LinkMan linkMan) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
        if (linkMan.getCustomer().getCid() != null && linkMan.getCustomer().getCid() > 0) {
            detachedCriteria.add(Restrictions.eq("customer.cid",linkMan.getCustomer().getCid()));
        }
        if (StringUtils.isNotBlank(linkMan.getLkmName())) {
            detachedCriteria.add(Restrictions.eq("lkmName", linkMan.getLkmName()));
        }
        List<LinkMan> linkManList = (List<LinkMan>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        return linkManList;
    }
}
