package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {
    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {
        System.out.println("===================================");
        System.out.println("제품분류 정보 목록");
        System.out.println("===================================");


        String option = parameter.get("option");
        if ("allList".equals(option)) {
            System.out.println("전체 제품분류 정보 목록");
        } else if ("orderList".equals(option)) {
            System.out.println("주력 제품분류 순위 조회");
        }
        System.out.println(option);
        System.out.println(categoryList.size());


        for (CategoryDTO category : categoryList) {
            System.out.println("카테고리 코드: " + category.getCategoryCode());
            System.out.println("카테고리명: " + category.getCategoryName());
            System.out.println("-------------------------------");
        }

    }

    public void printSuccessMessage(String successCode) {

        // 2. 성공메시지를 출력하는 메소드
        //    (조건) 성공코드를 전달받아 각각의 요청에 대해 성공을 알리는 메시지를 출력하세요.
        System.out.println("===================================");
        System.out.println("요청이 성공적으로 처리되었습니다.");
        System.out.println("Success Code: " + successCode);
        System.out.println("===================================");
    }

    public void printErrorMessage(String errorCode) {

        // 3. 에러메시지를 출력하는 메소드
        //    (조건) 에러코드를 전달받아 각각의 요청에 대해 에러를 알리는 메시지를 출력하세요.
        System.out.println("===================================");
        System.out.println("요청 처리 중 에러가 발생하였습니다.");
        System.out.println("Error Code: " + errorCode);
        System.out.println("===================================");
    }

}
