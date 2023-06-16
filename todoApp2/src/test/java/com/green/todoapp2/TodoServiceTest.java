package com.green.todoapp2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@Import({TodoService.class})
class TodoServiceTest {
    @MockBean
    private TodoMapper mapper;

    @Autowired
    private TodoService service;

    @Test
    void insTodo() {
    }

    @Test
    void selTodo() {
    }

    @Test
    void updFinish() {
    }

    @Test
    void delyn() {
    }
}