package online.suiyu.dao;

import online.suiyu.domain.Todo;

import java.util.List;

public interface TodoDao {

    public boolean updateTodo(String todo);

    public String getTodo();

}
