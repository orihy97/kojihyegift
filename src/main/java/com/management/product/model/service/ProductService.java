package com.management.product.model.service;

import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import com.common.SearchCondition;

import java.util.List;
import java.util.Map;

public class ProductService {

    private ProductDAO productDAO;

    public ProductService() {
        this.productDAO = productDAO;
    }

    public List<ProductDTO> selectAllProductList() {
        return productDAO.selectAllProductList();
    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {
        return productDAO.selectProductByCondition(searchCondition);
    }

    public boolean registNewProduct(ProductDTO product) {
        return productDAO.insertProduct(product);
    }

    public boolean modifyProductInfo(ProductDTO product) {
        return productDAO.updateProductInfo(product);
    }

    public boolean deleteProduct(Map<String, String> parameter) {
        return productDAO.deleteProduct(parameter.toString());
    }
}
