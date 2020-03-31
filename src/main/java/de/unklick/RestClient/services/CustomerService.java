package de.unklick.RestClient.services;

import de.unklick.RestClient.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id);
    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

}
