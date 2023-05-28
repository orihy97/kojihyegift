package com.management.category.model.service;

import com.management.category.model.dao.CategoryDAO;
import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryService {

    private CategoryDAO categoryDAO;

    // 1. 자주 사용할 DAO 객체를 선언하세요.
    public CategoryService() {
        this.categoryDAO = categoryDAO;
    }

    public List<CategoryDTO> selectCategoryList(Map<String, String> parameter) {
        // 2. 제품분류 목록을 조회하는 로직을 작성하세요.
        return categoryDAO.selectCategoryList();
    }

    public boolean registNewCategory(CategoryDTO category) {
        // 3. 제품분류 정보를 등록하는 로직을 작성하세요.
        return categoryDAO.insertCategory(category);
    }

    public boolean modifyCategoryName(CategoryDTO category) {
        // 4. 제품분류명을 수정하는 로직을 작성하세요.
        return categoryDAO.updateCategoryName(category);
    }

    public boolean deleteCategory(Map<String, String> parameter) {
        // 5. 제품분류 정보를 삭제하는 로직을 작성하세요.
        return categoryDAO.deleteCategory(parameter);
    }
}
