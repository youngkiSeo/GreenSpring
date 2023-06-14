package com.green.todoapp;

import com.google.gson.Gson;
import com.green.todoapp.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@Import({TodoService.class})
class TodoServiceTest {

    @MockBean //가짜 생성
    private TodoMapper mapper;

    @Autowired
    private TodoService service;


    @Test
    @DisplayName("TodoService- Todo 등록")
    void insTodo() {
        TodoEntity entity = new TodoEntity();
        entity.setCtnt("내용 입력");

        when(mapper.insTodo(any(TodoEntity.class))).thenReturn(1);

        TodoInsDto dto = new TodoInsDto();
        dto.setCtnt("내용 입력");
        int result = service.insTodo(dto);

        assertEquals(0,result); // assertEquals 두 객체의 값이 같은지 비교

        verify(mapper).insTodo(any(TodoEntity.class)); //mapper.instodo 호출 되었는지 확인
        // any(객체)
    }

    @Test
    @DisplayName("TodoService- Todo 리스트 가져오기")
    void selTodo() {

        //given
        List<TodoVo> list = new ArrayList<>();
        list.add(new TodoVo(1,"테스트","2023","null",1,"2023-05-11"));
        list.add(new TodoVo(2,"테스트2","2025","abc.jpg",0,null));
        list.add(new TodoVo(3,"테스트3","2024","null.jpg",0,null));

        //when
        when(mapper.selTodo()).thenReturn(list);
        List<TodoVo> todoVos = service.selTodo();

        //then
        assertEquals(3,todoVos.size());
        assertEquals("테스트",todoVos.get(0).getCtnt());

        verify(mapper).selTodo();
    }

    @Test
    @DisplayName("TodoService- 완료처리 토글")
    void updTodo() throws Exception{

        //given

        TodoFinishDto dto = new TodoFinishDto();
        dto.setItodo(1);
        TodoEntity entity = new TodoEntity();
        entity.setFinishYn(1);
        entity.setItodo(dto.getItodo());

        //when
        when(mapper.updFinish(any(TodoEntity.class))).thenReturn(0);

        int result = service.updTodo(dto);
        assertEquals(-1,result);

        //then
        verify(mapper).updFinish(any(TodoEntity.class));

    }


    @Test
    @DisplayName("TodoService - 삭제인척")
    void delyn() throws Exception{
        //given
        int expectedResult = 1;

        //when
        when(mapper.delyn(any(TodoEntity.class))).thenReturn(1);

        int result = service.delyn(anyInt());
        assertEquals(expectedResult,result);

        //then
        verify(mapper).delyn(any(TodoEntity.class));
    }
}