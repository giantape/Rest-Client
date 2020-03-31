package de.unklick.RestClient.bootstrap;

import de.unklick.RestClient.domain.Category;
import de.unklick.RestClient.domain.Customer;
import de.unklick.RestClient.repositories.CategoryRepository;
import de.unklick.RestClient.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstraping implements CommandLineRunner {
    private CategoryRepository categoryRepository;
    private CustomerRepository customerRepository;

    public Bootstraping(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategories();
        loadCustomers();

    }

    private void loadCategories(){
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category nuts = new Category();
        nuts.setName("Nuts");

        Category exotic = new Category();
        exotic.setName("Exotic");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(nuts);
        categoryRepository.save(exotic);

        System.out.println("category count" + categoryRepository.count());
    }
    private void loadCustomers(){
        Customer cus1 = new Customer();
        cus1.setId(1l);
        cus1.setFirstname("Giant");
        cus1.setLastname("Ape");

        Customer cus2 = new Customer();
        cus2.setId(2l);
        cus2.setFirstname("Konstantin");
        cus2.setLastname("Diyachkov");

        Customer cus3 = new Customer();
        cus3.setId(3l);
        cus3.setFirstname("Denés");
        cus3.setLastname("Albrech");

        customerRepository.save(cus1);
        customerRepository.save(cus2);
        customerRepository.save(cus3);
        System.out.println("Customer count" +  customerRepository.count());
    }
}
