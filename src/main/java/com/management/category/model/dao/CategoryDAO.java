package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface CategoryDAO {

    @Results(id = "categoryResultMap", value = {
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "categoryName", column = "CATEGORY_NAME")
    })
    @SelectProvider(type = CategoryDAOProvider.class, method = "selectCategoryList")
    List<CategoryDTO> selectCategoryList(Map<String, String> parameter);

    @InsertProvider(type = CategoryDAOProvider.class, method = "insertCategory")
    boolean insertCategory(CategoryDTO category);

    @UpdateProvider(type = CategoryDAOProvider.class, method = "updateCategoryName")
    boolean updateCategoryName(CategoryDTO category);

    @DeleteProvider(type = CategoryDAOProvider.class, method = "deleteCategory")
    boolean deleteCategory(Map<String, String> parameter);
}
