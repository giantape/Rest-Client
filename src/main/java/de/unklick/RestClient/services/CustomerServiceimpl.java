package de.unklick.RestClient.services;

import de.unklick.RestClient.api.v1.mapper.CustomerMapper;
import de.unklick.RestClient.api.v1.model.CustomerDTO;
import de.unklick.RestClient.domain.Customer;
import de.unklick.RestClient.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceimpl implements CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerServiceimpl(CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                    CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                    customerDTO.setCustomerUrl("/api/v1/customer/" + customer.getId());
                    return customerDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::customerToCustomerDTO)
                .orElseThrow(RuntimeException::new); // TODO impl Exception
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDtoToCustomer(customerDTO);
        Customer saveCustomer = customerRepository.save(customer);
        CustomerDTO returnDTO = customerMapper.customerToCustomerDTO(saveCustomer);
        returnDTO.setCustomerUrl("/api/v1/customer/" + saveCustomer.getId());
        return returnDTO;
    }
}
