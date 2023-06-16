package com.green.todoapp2;

import com.green.todoapp2.model.TodoFinishYnDto;
import com.green.todoapp2.model.TodoInsDto;
import com.green.todoapp2.model.TodoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo2")
public class TodoController {
    private final TodoService service;
    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public int postTodo(@RequestBody TodoInsDto dto){
        return service.insTodo(dto);
    }

    @GetMapping
    public List<TodoVo> getTodo(){
        return service.selTodo();
    }

    @PatchMapping
    public int patchTodo(@RequestBody TodoFinishYnDto dto){
        return service.updFinish(dto);
    }
    @DeleteMapping
    public int delTodo(@RequestBody int itodo){
        return service.delyn(itodo);
    }

}
