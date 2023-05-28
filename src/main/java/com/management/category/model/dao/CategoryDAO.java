package com.management.category.model.dao;

import com.management.category.model.dto.CategoryDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.annotations.DeleteProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface CategoryDAO {

    @Results(id = "categoryResultMap", value = {
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "categoryName", column = "CATEGORY_NAME")
    })
    @SelectProvider(type = CategoryDAOProvider.class, method = "selectCategoryList")
    List<CategoryDTO> selectCategoryList();

    @InsertProvider(type = CategoryDAOProvider.class, method = "insertCategory")
    boolean insertCategory(@Param("category") CategoryDTO category);

    @UpdateProvider(type = CategoryDAOProvider.class, method = "updateCategoryName")
    boolean updateCategoryName(@Param("category") CategoryDTO category);

    @DeleteProvider(type = CategoryDAOProvider.class, method = "deleteCategory")
    boolean deleteCategory(@Param("parameter") Map<String, String> parameter);
}
