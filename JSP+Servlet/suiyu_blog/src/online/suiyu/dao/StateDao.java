package online.suiyu.dao;

import online.suiyu.domain.Astate;

import java.util.List;

public interface StateDao {
    public List<Astate> getAllState();

    public boolean addState(Astate astate);

    public boolean deleteState(Astate astate);

    public boolean updateState(Astate astate);
}
