package online.suiyu.dao.impl;

import online.suiyu.dao.StateDao;
import online.suiyu.domain.Astate;
import online.suiyu.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StateDaoImpl implements StateDao {
    private QueryRunner runner = new QueryRunner();
//    private DataSourceUtils dataSourceUtils = new DataSourceUtils();

    @Override
    public List<Astate> getAllState() {
        String sql = "select * from astate";
        List<Astate> list = new ArrayList<>();
        try {
            list = runner.query(DataSourceUtils.getConnection(), sql, new BeanListHandler<Astate>(Astate.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addState(Astate astate) {
        return false;
    }

    @Override
    public boolean deleteState(Astate astate) {
        return false;
    }

    @Override
    public boolean updateState(Astate astate) {
        return false;
    }
}
