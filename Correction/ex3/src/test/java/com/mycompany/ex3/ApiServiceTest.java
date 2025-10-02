package com.mycompany.ex3;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ApiServiceTest {

    @Test
    void fetchUppercasedData_shouldReturnUppercaseData() {
        ApiClient mockClient = mock(ApiClient.class);
        // On force le comportement : return hello
        when(mockClient.getData()).thenReturn("hello");

        ApiService service = new ApiService(mockClient);

        assertEquals("HELLO", service.fetchUppercasedData());
        verify(mockClient, times(1)).getData();
    }

    @Test
    void fetchUppercasedData_shouldCallGetDataTwice_whenFetchCalledTwice() {
        ApiClient mockClient = mock(ApiClient.class);
        when(mockClient.getData()).thenReturn("hello");

        ApiService service = new ApiService(mockClient);

        service.fetchUppercasedData();
        service.fetchUppercasedData();

        verify(mockClient, times(2)).getData();
    }

    @Test
    void hasData_shouldReturnTrue_whenDataIsNotNull() {
        ApiClient mockClient = mock(ApiClient.class);
        when(mockClient.getData()).thenReturn("something");

        ApiService service = new ApiService(mockClient);

        assertTrue(service.hasData());
        verify(mockClient, times(1)).getData();
    }

    @Test
    void hasData_shouldReturnFalse_whenDataIsNull() {
        ApiClient mockClient = mock(ApiClient.class);
        when(mockClient.getData()).thenReturn(null);

        ApiService service = new ApiService(mockClient);

        assertFalse(service.hasData());
        verify(mockClient, times(1)).getData();
    }
}
