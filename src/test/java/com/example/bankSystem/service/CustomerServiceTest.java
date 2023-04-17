package com.example.bankSystem.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import com.example.bankSystem.dto.CustomerDTO;
import com.example.bankSystem.dto.CustomerMapperImpl;
import com.example.bankSystem.entity.Currencies;
import com.example.bankSystem.entity.Customer;
import com.example.bankSystem.util.CustomerMapper;
import org.apache.catalina.mapper.Mapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServiceTests {

    @Mock
    private CustomerMapper customerMapper;

    @Mock
    private CustomerMapperImpl mapper;

    @InjectMocks
    private CustomerService customerService;

    @Test
    public void testInsert() {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setName("John Doe");
        customerDTO.setCountry("US");
        customerDTO.setCurrencies(Arrays.asList(Currencies.USD, Currencies.EUR));

        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("John Doe");
        customer.setCountry("US");
        List<Currencies> currencies = Arrays.asList(Currencies.USD, Currencies.EUR);
        customer.setCurrency(currencies);

        // Mock the behavior of the mapper and customer mapper
        when(mapper.toCustomer(customerDTO)).thenReturn(customer);

        // Call the function being tested
        Customer result = customerService.insert(customerDTO);

        // Verify that the customer was created and saved correctly
        assertNotNull(result);
        assertEquals(customer.getName(), result.getName());
        assertEquals(customer.getCountry(), result.getCountry());
        assertEquals(customer.getCurrency().size(), result.getCurrency().size());
        verify(customerMapper).insert(customer);
        verify(customerMapper, times(2)).insertCurrency(eq(1), any(Currencies.class));
    }
}

