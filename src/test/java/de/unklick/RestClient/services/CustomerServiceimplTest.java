package de.unklick.RestClient.services;

import de.unklick.RestClient.api.v1.mapper.CustomerMapper;
import de.unklick.RestClient.api.v1.model.CustomerDTO;
import de.unklick.RestClient.controllers.v1.CustomerController;
import de.unklick.RestClient.domain.Customer;
import de.unklick.RestClient.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class CustomerServiceimplTest {

    @Mock
    CustomerRepository customerRepository;

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    CustomerService customerService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(customerRepository, customerMapper);
    }

    @Test
    public void getAllCustomers() throws Exception {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Bob");
        customer1.setLastname("Burger");

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstname("Jimmy");
        customer2.setLastname("Pesto");

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //then
        assertEquals(2, customerDTOS.size());

    }

    @Test
    public void getCustomerById() throws Exception {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Jimmy");
        customer1.setLastname("Pesto");

        when(customerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(customer1));

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(1L);

        assertEquals("Jimmy", customerDTO.getFirstname());
    }

    @Test
    public void createNewCustomer() throws Exception {
        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname("Giant");

        Customer saveCustomer = new Customer();
        saveCustomer.setFirstname(customerDTO.getFirstname());
        saveCustomer.setLastname(customerDTO.getLastname());
        saveCustomer.setId(1l);
        when(customerRepository.save(any(Customer.class))).thenReturn(saveCustomer);
        //when
        CustomerDTO savedDto = customerService.createNewCustomer(customerDTO);

        //then
        assertEquals(customerDTO.getFirstname(), savedDto.getFirstname());
        assertEquals(CustomerController.BASE_URL +  "/1", savedDto.getCustomerUrl());
    }

    @Test
    public void saveCustomerByDTO() throws Exception {

        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstname("Giant");

        Customer saveCustomer = new Customer();
        saveCustomer.setFirstname(customerDTO.getFirstname());
        saveCustomer.setLastname(customerDTO.getLastname());
        saveCustomer.setId(1l);
        when(customerRepository.save(any(Customer.class))).thenReturn(saveCustomer);

        //when
        CustomerDTO savedDto = customerService.saveCustomerByDTO(1L, customerDTO);

        //then
        assertEquals(customerDTO.getFirstname(), savedDto.getFirstname());
        assertEquals(CustomerController.BASE_URL +  "/1", savedDto.getCustomerUrl());
    }

    @Test
    public void deleteCustomerById() throws Exception {
        Long id = 1l;
        customerRepository.deleteById(id);
        verify(customerRepository, times(1)).deleteById(anyLong());
    }

}