package online.suiyu.service;

import online.suiyu.domain.Astate;

import java.util.List;

public interface AstateService {
    public List<Astate> getAllState();

    public boolean addState(Astate astate);

    public boolean deleteState(Astate astate);

    public boolean updateState(Astate astate);
}
