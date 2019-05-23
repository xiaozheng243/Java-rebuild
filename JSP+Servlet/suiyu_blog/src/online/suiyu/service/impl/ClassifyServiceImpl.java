package online.suiyu.service.impl;

import online.suiyu.dao.ClassifyDao;
import online.suiyu.dao.impl.ClassifyDaoImpl;
import online.suiyu.domain.Classify;
import online.suiyu.service.ClassifyService;

import java.util.List;

public class ClassifyServiceImpl implements ClassifyService {
    private ClassifyDao classifyDao = new ClassifyDaoImpl();

    @Override
    public List<Classify> getAllClassify() {
        return classifyDao.getAllClassify();
    }

    @Override
    public boolean addClassify(Classify classify) {
        return classifyDao.addClassify(classify);
    }

    @Override
    public boolean deleteClassify(Classify classify) {
        return classifyDao.deleteClassify(classify);
    }

    @Override
    public boolean updateClassify(Classify classify) {
        return classifyDao.updateClassify(classify);
    }
}
