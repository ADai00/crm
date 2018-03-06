package edu.hnie.crm.customer.service.Impl;

import edu.hnie.crm.customer.dao.DictDao;
import edu.hnie.crm.customer.domain.Dict;
import edu.hnie.crm.customer.service.DictService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DictServiceImpl implements DictService {

    private DictDao dictDao;

    public void setDictDao(DictDao dictDao) {
        this.dictDao = dictDao;
    }

    @Override
    public List<Dict> findAllDict() {
        String hql="from Dict";
        List<Dict> dictList = dictDao.findAll(hql);
        return dictList;
    }
}
