package de.unklick.RestClient.api.v1.mapper;

import de.unklick.RestClient.api.v1.model.CustomerDTO;
import de.unklick.RestClient.domain.Customer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-03-31T16:01:28+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_241 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setFirstname( customer.getFirstname() );
        customerDTO.setLastname( customer.getLastname() );

        return customerDTO;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setFirstname( customerDTO.getFirstname() );
        customer.setLastname( customerDTO.getLastname() );

        return customer;
    }
}
