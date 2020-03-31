package de.unklick.RestClient.api.v1.mapper;

import de.unklick.RestClient.api.v1.model.CategoryDTO;
import de.unklick.RestClient.domain.Category;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {
    private static final String NAME = "Johnny";
    private static final long ID = 2L;

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    void categoryToCategoryDTO() throws Exception {
        //givin
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        //when
        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        //then
        assertEquals(Long.valueOf(ID), categoryDTO.getId());
        assertEquals(Long.valueOf(NAME), categoryDTO.getName());
    }
}