package com.green.todoapp;

import com.green.todoapp.model.TodoDelDto;
import com.green.todoapp.model.TodoEntity;
import com.green.todoapp.model.TodoVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@MybatisTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TodoMapperTest {

    @Autowired
    private TodoMapper mapper;

    @Test
    @DisplayName("TodoMapper- 입력처리 토글")
    void insTodo() {
        //given
        TodoEntity entity = new TodoEntity();
        entity.setCtnt("테스트");

        int result = mapper.insTodo(entity);
        System.out.println(entity.getItodo());

        assertEquals(2,entity.getItodo());
        assertEquals(1,result);

    }

    @Test
    @DisplayName("TodoMapper- 보기")
    void selTodo() {
        List<TodoVo> list = mapper.selTodo();
        //mapper.selTodo();
        assertEquals(1,list.size());
        TodoVo vo = list.get(0);
        assertEquals("연어초밥",vo.getCtnt());
    }

    @Test
    @DisplayName("TodoMapper- 완료처리 토글")
    void updFinish() {
        TodoEntity entity = new TodoEntity();
        entity.setItodo(2);
        int result = mapper.updFinish(entity);
        assertEquals(1,result);
    }


    @Test
    @DisplayName("TodoMapper- 삭제인척")
    void delyn() {
        int expectedResult = 1;
        TodoEntity entity = new TodoEntity();
        entity.setItodo(1);
        int result = mapper.delyn(entity);
        assertEquals(expectedResult,result);
    }
}