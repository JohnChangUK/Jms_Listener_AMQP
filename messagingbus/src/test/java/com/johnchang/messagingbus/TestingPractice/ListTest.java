package com.johnchang.messagingbus.TestingPractice;

import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ListTest {

    @Test
    public void mockListSize() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2);

        assertEquals(2, listMock.size());
    }

    @Test
    public void mockListSize_ReturnMultipleValues() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(4);

        assertEquals(2, listMock.size());
        assertEquals(4, listMock.size());
    }

    @Test
    public void mockListGETMethod() {
        List listMock = mock(List.class);
        when(listMock.get(0)).thenReturn("The 0th item in the List");

        assertEquals("The 0th item in the List", listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void mockListGETAnyInt_Matchers() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenReturn("Any Int - Any Index");

        assertEquals("Any Int - Any Index", listMock.get(0));
        assertEquals("Any Int - Any Index", listMock.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_throwAnException() {
        List listMock = mock(List.class);
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));

        listMock.get(2);
    }
}
