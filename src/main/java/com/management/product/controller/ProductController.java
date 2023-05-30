package com.management.product.controller;

import com.management.product.model.dto.ProductDTO;
import com.common.SearchCondition;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;
import java.util.List;
import java.util.Map;

public class ProductController {


    private ProductService productService;
    private ProductPrint productPrint;

    public ProductController() {
        this.productService = new ProductService();
        this.productPrint = new ProductPrint();
    }

    public void selectAllProductList() {

        List<ProductDTO> productList = productService.selectAllProductList();

        if (!productList.isEmpty()) {
            productPrint.printAllProductList(productList);
        } else {
            productPrint.printErrorMessage("조회 결과가 없습니다.");
        }

    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);

        if (!productList.isEmpty()) {
            productPrint.printProductList(productList, searchCondition);
        } else {
            productPrint.printErrorMessage("ERROR_PRODUCT_NOT_FOUND");
        }
    }

    public void registNewProduct(ProductDTO product) {

        // 4. 제품 정보를 등록하는 메소드
        //    (조건 1) 화면에서 releaseDate를 0000-00-00 형태로 받아옵니다.
        //            해당 필드에 매핑되는 DB 컬럼 releaseDate가 8byte이므로 '-' 문자를 제거하여 product객체에 setting 하세요.
        //            또한 제품 최초 등록 시 생산여부는 무조건 '생산중(Y)'이고, 판매량은 0이므로 해당 값을 product객체에 setting 하세요.
        //　  (조건 2) Service 객체를 호출하여 등록을 수행하고, 결과를 boolean 값으로 return 받으세요.
        //    (조건 3) insert가 정상적으로 수행된 경우, Print 객체를 통해 등록 성공했다는 성공 메세지를 출력하세요.
        //    (조건 4) insert가 정상적으로 수행되지 않은 경우, Print 객체를 통해 등록 실패했다는 오류 메세지를 출력하세요.
        product.setReleaseDate(product.getReleaseDate().replace("-", "")); // releaseDate 형식 변환
        product.setProductionStatus("Y"); // 생산여부 초기값 설정
        product.setSalesQuantity(String.valueOf(0)); // 판매량 초기값 설정

        boolean result = productService.registNewProduct(product);

        if (result) {
            productPrint.printSuccessMessage("SUCCESS_REGISTRATION");
        } else {
            productPrint.printErrorMessage("ERROR_REGISTRATION_FAILED");
        }

    }

    public void modifyProductInfo(ProductDTO product) {


        product.setReleaseDate(product.getReleaseDate().replace("-", "")); // releaseDate 형식 변환

        boolean result = productService.modifyProductInfo(product);

        if (result) {
            productPrint.printSuccessMessage("SUCCESS_MODIFICATION");
        } else {
            productPrint.printErrorMessage("ERROR_MODIFICATION_FAILED");
        }

    }

    public void deleteProduct(Map<String, String> parameter) {


        boolean result = productService.deleteProduct(parameter);

        if (result) {
            productPrint.printSuccessMessage("SUCCESS_DELETION");
        } else {
            productPrint.printErrorMessage("ERROR_DELETION_FAILED");
        }
    }
}
