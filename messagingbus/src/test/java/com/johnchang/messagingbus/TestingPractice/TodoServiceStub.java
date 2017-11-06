package com.johnchang.messagingbus.TestingPractice;

import com.johnchang.messagingbus.TestingPractice.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Spring",
                                "Mocks and Stubs in Spring",
                                "Learn Breakdancing");
    }
}
