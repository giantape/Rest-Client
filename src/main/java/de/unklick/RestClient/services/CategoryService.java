package de.unklick.RestClient.services;

import de.unklick.RestClient.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);
}