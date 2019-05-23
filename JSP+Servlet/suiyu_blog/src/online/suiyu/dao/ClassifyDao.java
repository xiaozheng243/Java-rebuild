package online.suiyu.dao;

import online.suiyu.domain.Astate;
import online.suiyu.domain.Classify;

import java.util.List;

public interface ClassifyDao {
    public List<Classify> getAllClassify();

    public boolean addClassify(Classify classify);

    public boolean deleteClassify(Classify classify);

    public boolean updateClassify(Classify classify);
}
