package de.unklick.RestClient.repositories;

import de.unklick.RestClient.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
