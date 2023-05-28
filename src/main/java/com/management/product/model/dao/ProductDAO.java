package com.management.product.model.dao;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductDAO {

    @Results(id = "productResultMap", value = {
            @Result(property = "productCode", column = "PRODUCT_CODE"),
            @Result(property = "productName", column = "PRODUCT_NAME"),
            @Result(property = "originCost", column = "ORIGIN_COST"),
            @Result(property = "releaseDate", column = "RELEASE_DATE"),
            @Result(property = "discountRate", column = "DISCOUNT_RATE"),
            @Result(property = "salesQuantity", column = "SALES_QUANTITY"),
            @Result(property = "stockQuantity", column = "STOCK_QUANTITY"),
            @Result(property = "categoryCode", column = "CATEGORY_CODE"),
            @Result(property = "productionStatus", column = "PRODUCTION_STATUS")
    })
    @Select("SELECT * FROM PRODUCT_INFO")
    List<ProductDTO> selectProductList();

    @ResultMap("productResultMap")
    @Select("SELECT * FROM PRODUCT_INFO WHERE PRODUCT_CODE = #{productCode}")
    ProductDTO selectProductDetail(String productCode);

    @Insert("INSERT INTO PRODUCT_INFO (PRODUCT_NAME, ORIGIN_COST, RELEASE_DATE, DISCOUNT_RATE, SALES_QUANTITY, STOCK_QUANTITY, CATEGORY_CODE, PRODUCTION_STATUS) " +
            "VALUES (#{product.productName}, #{product.originCost}, #{product.releaseDate}, #{product.discountRate}, #{product.salesQuantity}, #{product.stockQuantity}, " +
            "#{product.categoryCode}, #{product.productionStatus})")
    boolean insertProduct(@Param("product") ProductDTO product);

    @Update("UPDATE PRODUCT_INFO SET PRODUCT_NAME = #{product.productName}, ORIGIN_COST = #{product.originCost}, " +
            "RELEASE_DATE = #{product.releaseDate}, DISCOUNT_RATE = #{product.discountRate}, SALES_QUANTITY = #{product.salesQuantity}, " +
            "STOCK_QUANTITY = #{product.stockQuantity}, CATEGORY_CODE = #{product.categoryCode}, PRODUCTION_STATUS = #{product.productionStatus} " +
            "WHERE PRODUCT_CODE = #{product.productCode}")
    boolean updateProduct(@Param("product") ProductDTO product);

    @Delete("DELETE FROM PRODUCT_INFO WHERE PRODUCT_CODE = #{productCode}")
    boolean deleteProduct(String productCode);

    List<ProductDTO> selectAllProductList();

    List<ProductDTO> selectProductByCondition(SearchCondition searchCondition);

    boolean updateProductInfo(ProductDTO product);
}
