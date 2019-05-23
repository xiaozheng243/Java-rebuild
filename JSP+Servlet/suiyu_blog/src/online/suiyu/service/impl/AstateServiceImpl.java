package online.suiyu.service.impl;

import online.suiyu.dao.StateDao;
import online.suiyu.dao.impl.StateDaoImpl;
import online.suiyu.domain.Astate;
import online.suiyu.service.AstateService;

import java.util.List;

public class AstateServiceImpl implements AstateService {
    private StateDao stateDao = new StateDaoImpl();

    @Override
    public List<Astate> getAllState() {
        return stateDao.getAllState();
    }

    @Override
    public boolean addState(Astate astate) {
        return stateDao.addState(astate);
    }

    @Override
    public boolean deleteState(Astate astate) {
        return stateDao.deleteState(astate);
    }

    @Override
    public boolean updateState(Astate astate) {
        return stateDao.updateState(astate);
    }
}
