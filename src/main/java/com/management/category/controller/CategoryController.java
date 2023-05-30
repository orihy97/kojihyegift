package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private CategoryService categoryService;

    public List<CategoryDTO> selectCategoryList(Map<String, String> parameter) {
        categoryService = new CategoryService();
        return categoryService.selectCategoryList(parameter);
    }

    public boolean registNewCategory(CategoryDTO category) {
        categoryService = new CategoryService();
        return categoryService.registNewCategory(category);
    }

    public boolean modifyCategoryName(CategoryDTO category) {
        categoryService = new CategoryService();
        return categoryService.modifyCategoryName(category);
    }

    public boolean deleteCategory(Map<String, String> parameter) {
        categoryService = new CategoryService();
        return categoryService.deleteCategory(parameter);
    }
}
