package com.green.todoapp;

import com.google.gson.Gson;
import com.green.todoapp.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.xml.transform.Result;
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
    private MockMvc mvc; //Controller 한테 요청보내는 역할

    @MockBean //  가짜빈 등록
    private TodoService service;


    @Test
    @DisplayName("Todo - 등록")
    void postTodo() throws Exception {
        // given - when - then

        //give - 테스트 세팅 단계
        // 가짜 TodoService 한테 업무를 주는
        given(service.insTodo(any(TodoInsDto.class))).willReturn(3); // TodoInsDto 객체 주소값이 넘어간다/

        // when - 실제 실행
        TodoInsDto dto = new TodoInsDto();
        dto.setCtnt("빨래개기");

        Gson gson = new Gson();
        String json = gson.toJson(dto);
        //String json = "{\"ctnt\": \"빨래 개기\" }";

        ResultActions ra = mvc.perform(post("/api/todo").
                content(json)
                .contentType(MediaType.APPLICATION_JSON)); // 미디어 타입의 json으로 날린다

    // then.
        ra.andExpect(status().isOk())// 200이 넘어오는지 확인
        .andExpect(content().string("3"))
        .andDo(print());
        verify(service).insTodo(any());
    }
    @Test
    @DisplayName("Todo - 리스트")
    void getTodo() throws Exception {
        List<TodoVo> mockList = new ArrayList<>();
        mockList.add(new TodoVo(1,"테스트","2023","null",1,"2023-05-11"));
        mockList.add(new TodoVo(2,"테스트2","2025","abc.jpg",0,null));
        mockList.add(new TodoVo(3,"테스트3","2024","null.jpg",0,null));

        given(service.selTodo()).willReturn(mockList);

        //when
        ResultActions ra = mvc.perform(get("/api/todo"));


        //then
                ra.andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(mockList.size()))) //사이즈두개체크
                .andExpect(jsonPath("$[*].itodo").exists())
                .andExpect(jsonPath("$[0].itodo").value(1))
                .andExpect(jsonPath("$[0].ctnt").value("테스트"))
                .andDo(print());

        verify(service).selTodo();
    }

    @Test
    @DisplayName("Todo- 완료처리 토글")
    void patchTodo() throws Exception{
        //given
        given(service.updTodo(any())).willReturn(1);

        //when
        TodoFinishDto fdto = new TodoFinishDto();
        fdto.setItodo(1);

        Gson gson = new Gson();
        String json = gson.toJson(fdto);

        ResultActions ra = mvc.perform(patch("/api/todo")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON));//mvc.perform 으로 apitodo patch 호출

        //then
         ra.andExpect(status().isOk())
                        .andExpect(content().string("1"))
                        .andDo(print());
        verify(service).updTodo(any());
    }

    @Test
    @DisplayName("Todo- 삭제인척")
    void delTodo() throws Exception{
        int itodo=10;
        //given
        given(service.delyn(anyInt())).willReturn(itodo);

        //when

        ResultActions ra = mvc.perform(delete("/api/todo")
                        .param("itodo",String.valueOf(itodo)));

        //then
        ra.andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(itodo)))
                .andDo(print());
        verify(service).delyn(anyInt());


    }
}