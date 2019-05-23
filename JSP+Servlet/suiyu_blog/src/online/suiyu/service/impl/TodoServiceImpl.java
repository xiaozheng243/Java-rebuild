package online.suiyu.service.impl;

import online.suiyu.dao.impl.TodoDaoImpl;
import online.suiyu.service.TodoService;

public class TodoServiceImpl implements TodoService {
    @Override
    public boolean updateTodo(String todo) {
        return new TodoDaoImpl().updateTodo(todo);
    }

    @Override
    public String getTodo() {
        return new TodoDaoImpl().getTodo();
    }
}
