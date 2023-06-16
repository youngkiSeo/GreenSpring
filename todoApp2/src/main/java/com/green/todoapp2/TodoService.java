package com.green.todoapp2;

import com.green.todoapp2.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoMapper mapper;
    @Autowired
    public TodoService(TodoMapper mapper) {
        this.mapper = mapper;
    }
    public int insTodo(TodoInsDto dto){
        TodoEntity entity = new TodoEntity();
        entity.setCtnt(dto.getCtnt());
        int result = mapper.insTodo(entity);
        if (result == 1 ){
            return entity.getItodo();
        }
        return result;
    }

    public List<TodoVo> selTodo(){
        return mapper.selTodo();
    }

    public int updFinish(TodoFinishYnDto dto) {
        TodoEntity entity = new TodoEntity();
        entity.setItodo(dto.getItodo());

        int result= mapper.updFinish(entity);
        if (result==0){
            return -1;
        }
        return entity.getFinishYn();
    }

    public int delyn(int itodo){
        TodoEntity entity = new TodoEntity();
        entity.setItodo(itodo);
        int result = mapper.delyn(entity);

        return result;
    }

}
