package de.unklick.RestClient.api.v1.mapper;

import de.unklick.RestClient.api.v1.model.CustomerDTO;
import de.unklick.RestClient.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
