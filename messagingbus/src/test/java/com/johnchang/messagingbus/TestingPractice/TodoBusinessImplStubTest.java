package com.johnchang.messagingbus.TestingPractice;
import com.johnchang.messagingbus.TestingPractice.TodoBusinessImpl;
import com.johnchang.messagingbus.TestingPractice.TodoService;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class TodoBusinessImplStubTest {

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAStub() {
        TodoService todoServiceStub = new TodoServiceStub();
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2, filteredTodos.size());
    }
}
