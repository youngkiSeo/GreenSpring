package com.green.todoapp2;

import com.google.gson.Gson;
import com.green.todoapp2.model.TodoFinishYnDto;
import com.green.todoapp2.model.TodoInsDto;
import com.green.todoapp2.model.TodoVo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TodoController.class)
class TodoControllerTest {
    @Autowired
    private MockMvc mvc; // controller 한테 요청 보내는 역할

    @MockBean //가짜빈 등록
    private TodoService service;

    @Test
    @DisplayName("Todo - 등록")
    void postTodo() throws Exception {
        //given
        given(service.insTodo(any(TodoInsDto.class))).willReturn(1);
        TodoInsDto dto = new TodoInsDto();
        dto.setCtnt("빨래");

        Gson gson = new Gson();
        String json = gson.toJson(dto);

        ResultActions ra = mvc.perform(post("/api/todo2")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then

        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());

        //status() : http 상태확인
        //andExpect: 실행결과 검증
        // content
        verify(service).insTodo(any());
    }

    @Test
    @DisplayName("Todo - 리스트")
    void getTodo() throws Exception {
        List<TodoVo>  mockList = new ArrayList<>();
        mockList.add(new TodoVo(1,"테스트","2023-06-16",null,0,null));
        mockList.add(new TodoVo(2,"테스트","2023-06-16",null,0,null));
        mockList.add(new TodoVo(3,"테스트","2023-06-16",null,0,null));

        given(service.selTodo()).willReturn(mockList);

        //when
        ResultActions ra = mvc.perform(get("/api/todo2"));

        //then

        ra.andExpect(status().isOk()) //http 상태확인 isOk 200 이면 성공
                .andExpect(jsonPath("$",hasSize(mockList.size())))  //andExpect: 실행결과 검증
                .andExpect(jsonPath("$[*].itodo").exists())
                .andExpect(jsonPath("$[0].itodo").value(1))
                .andExpect(jsonPath("$[0].ctnt").value("테스트"))
                .andDo(print());

        verify(service).selTodo();
    }

    @Test
    @DisplayName("Todo - 완료처리 토글")
    void patchTodo() throws Exception {
        //given

        given(service.updFinish(any())).willReturn(1);

        //when
        TodoFinishYnDto dto = new TodoFinishYnDto();
        dto.setItodo(1);

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        ResultActions ra = mvc.perform(patch("/api/todo2")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));

        //then
        ra.andExpect(status().isOk())
                .andExpect(content().string("1"))
                .andDo(print());
        verify(service).updFinish(any());
    }

    @Test
    @DisplayName("Todo - 삭제인척")
    void delTodo() throws Exception{
        int itodo = 10;
        given(service.delyn(anyInt())).willReturn(itodo);

        //when

        ResultActions ra = mvc.perform(delete("/api/todo2")
                .param("itodo",String.valueOf(itodo)));

        //then
        ra.andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(itodo)))
                .andDo(print());

        verify(service).delyn(anyInt());
    }
}