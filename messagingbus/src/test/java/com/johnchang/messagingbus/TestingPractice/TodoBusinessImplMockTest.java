//package messagingbus;
//
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.List;
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;
//
//public class TodoBusinessImplMockTest {
//
//    @Test
//    public void testRetrieveTodosRelatedToSpring_usingAMock() {
//
//        TodoService todoServiceMock = mock(TodoService.class);
//        List<String> todos = Arrays.asList("Spring",
//                "Mocks and Stubs in Spring",
//                "Learn Breakdancing");
//        when(todoServiceMock.retrieveTodos("DummyUser")).thenReturn(todos);
//
//        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
//        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("DummyUser");
//        assertEquals(2, filteredTodos.size());
//    }
//}
