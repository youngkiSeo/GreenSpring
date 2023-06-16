package com.green.todoapp2;

import com.green.todoapp2.model.TodoEntity;
import com.green.todoapp2.model.TodoVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    int insTodo(TodoEntity entity);
    List<TodoVo> selTodo();
    int updFinish(TodoEntity entity);
    int delyn(TodoEntity entity);
}
