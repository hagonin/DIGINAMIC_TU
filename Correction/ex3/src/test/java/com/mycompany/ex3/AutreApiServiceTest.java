package com.mycompany.ex3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class) 
class AutreApiServiceTest  {

    @Mock
    private ApiClient mockClient;  

    @InjectMocks
    private ApiService service;     

    @Test
    void fetchUppercasedData_shouldReturnUppercaseData() {
        // Given
        when(mockClient.getData()).thenReturn("hello");

        // When
        String result = service.fetchUppercasedData();

        // Then
        assertEquals("HELLO", result);
        verify(mockClient, times(1)).getData();
    }

    @Test
    void fetchUppercasedData_shouldCallGetDataTwice_whenFetchCalledTwice() {
        // Given
        when(mockClient.getData()).thenReturn("hello");

        // When
        service.fetchUppercasedData();
        service.fetchUppercasedData();

        // Then
        verify(mockClient, times(2)).getData();
    }

    @Test
    void hasData_shouldReturnTrue_whenDataIsNotNull() {
        // Given
        when(mockClient.getData()).thenReturn("something");

        // When
        boolean result = service.hasData();

        // Then
        assertTrue(result);
        verify(mockClient, times(1)).getData();
    }

    @Test
    void hasData_shouldReturnFalse_whenDataIsNull() {
        // Given
        when(mockClient.getData()).thenReturn(null);

        // When
        boolean result = service.hasData();

        // Then
        assertFalse(result);
        verify(mockClient, times(1)).getData();
    }
}
