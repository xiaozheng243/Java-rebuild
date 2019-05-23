package online.suiyu.service;

import online.suiyu.domain.Classify;

import java.util.List;

public interface ClassifyService {
    public List<Classify> getAllClassify();

    public boolean addClassify(Classify classify);

    public boolean deleteClassify(Classify classify);

    public boolean updateClassify(Classify classify);
}
