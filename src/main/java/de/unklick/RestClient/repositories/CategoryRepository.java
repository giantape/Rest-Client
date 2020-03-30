package de.unklick.RestClient.repositories;

import de.unklick.RestClient.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
