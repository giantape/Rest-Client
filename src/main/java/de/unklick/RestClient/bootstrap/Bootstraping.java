package de.unklick.RestClient.bootstrap;

import de.unklick.RestClient.domain.Category;
import de.unklick.RestClient.repositories.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstraping implements CommandLineRunner {
    private CategoryRepository categoryRepository;

    public Bootstraping(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
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
}
