package com.johnchang.messagingbus.TestingPractice;

import com.johnchang.messagingbus.TestingPractice.TodoBusinessImpl;
import com.johnchang.messagingbus.TestingPractice.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMockTest {

    @Mock
    TodoService todoServiceMock;

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {

        List<String> todos = Arrays.asList("Spring",
                "Mocks and Stubs in Spring",
                "Learn Breakdancing");
        when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(todos);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");
        assertEquals(2, filteredTodos.size());
    }
}
