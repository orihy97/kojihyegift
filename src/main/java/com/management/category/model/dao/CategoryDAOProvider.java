package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class CategoryDAOProvider {

    public String selectCategoryList(Map<String, String> parameter) {
        return new SQL()
                .SELECT("CATEGORY_CODE, CATEGORY_NAME")
                .FROM("PRODUCT_CATEGORY")
                .ORDER_BY("(SELECT COUNT(*) FROM PRODUCT_INFO WHERE PRODUCT_CATEGORY.CATEGORY_CODE = PRODUCT_INFO.CATEGORY_CODE) DESC")
                .toString();
    }

    public String insertCategory(CategoryDTO category) {
        return new SQL()
                .INSERT_INTO("PRODUCT_CATEGORY")
                .VALUES("CATEGORY_NAME", "#{categoryName}")
                .toString();
    }

    public String updateCategoryName(CategoryDTO category) {
        return new SQL()
                .UPDATE("PRODUCT_CATEGORY")
                .SET("CATEGORY_NAME = #{categoryName}")
                .WHERE("CATEGORY_CODE = #{categoryCode}")
                .toString();
    }

    public String deleteCategory(Map<String, String> parameter) {
        return new SQL()
                .DELETE_FROM("PRODUCT_CATEGORY")
                .WHERE("CATEGORY_CODE = #{categoryCode}")
                .toString();
    }
}
