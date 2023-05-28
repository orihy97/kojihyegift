package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList() {
        return new SQL()
                .SELECT("*")
                .FROM("PRODUCT_CATEGORY")
                .toString();
    }

    public String insertCategory(CategoryDTO category) {
        return new SQL()
                .INSERT_INTO("PRODUCT_CATEGORY")
                .VALUES("CATEGORY_NAME", "#{category.categoryName}")
                .toString();
    }

    public String updateCategoryName(CategoryDTO category) {
        return new SQL()
                .UPDATE("PRODUCT_CATEGORY")
                .SET("CATEGORY_NAME = #{category.categoryName}")
                .WHERE("CATEGORY_CODE = #{category.categoryCode}")
                .toString();
    }

    public String deleteCategory(Map<String, String> parameter) {
        return new SQL()
                .DELETE_FROM("PRODUCT_CATEGORY")
                .WHERE("CATEGORY_CODE = #{parameter.categoryCode}")
                .toString();
    }
}
