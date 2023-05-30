package com.management.category.controller;

import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {

    private CategoryService categoryService;
    private CategoryPrint categoryPrint;

    public CategoryController() {
        categoryService = new CategoryService();
        categoryPrint = new CategoryPrint();
    }

    public void selectCategoryList(Map<String, String> parameter) {
        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if (!categoryList.isEmpty()) {
            categoryPrint.printTeamList(categoryList, parameter);
        } else {
            categoryPrint.printErrorMessage("조회 결과가 없습니다.");
        }
    }

    public void registNewCategory(CategoryDTO category) {
        boolean success = categoryService.registNewCategory(category);

        if (success) {
            categoryPrint.printSuccessMessage("제품분류 등록이 완료되었습니다.");
        } else {
            categoryPrint.printErrorMessage("제품분류 등록에 실패하였습니다.");
        }
    }

    public void modifyCategoryName(CategoryDTO category) {
        boolean success = categoryService.modifyCategoryName(category);

        if (success) {
            categoryPrint.printSuccessMessage("제품분류명 수정이 완료되었습니다.");
        } else {
            categoryPrint.printErrorMessage("제품분류명 수정에 실패하였습니다.");
        }
    }

    public void deleteCategory(Map<String, String> parameter) {
        boolean success = categoryService.deleteCategory(parameter);

        if (success) {
            categoryPrint.printSuccessMessage("제품분류 삭제가 완료되었습니다.");
        } else {
            categoryPrint.printErrorMessage("제품분류 삭제에 실패하였습니다.");
        }
    }
}
