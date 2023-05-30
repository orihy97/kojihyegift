package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;

import java.util.List;
import java.util.Map;

public class CategoryPrint {

    // * 모든 출력은 System.out.println()을 통해 콘솔에 출력하는 것을 의미합니다.
    // * 주석을 지우고 다음 세 가지 메소드를 작성하세요.

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        // 1. 조회한 목록 출력하는 메소드
        //    (조건 1) HashMap 타입의 매개변수로 받아온 값을 기준으로 전체 목록 조회인지, 순위별 제품분류 조회인지 구분하여 출력하세요.
        //    (조건 2) List<CategoryDTO>로 받아온 데이터 목록을 전체 출력하세요.
        System.out.println("===================================");
        System.out.println("제품분류 정보 목록");
        System.out.println("===================================");

        // 조회 조건에 따라 출력 메시지 설정
        String option = parameter.get("option");
        if ("allList".equals(option)) {
            System.out.println("전체 제품분류 정보 목록");
        } else if ("orderList".equals(option)) {
            System.out.println("주력 제품분류 순위 조회");
        }
        System.out.println(option);
        System.out.println(categoryList.size());

        // 카테고리 정보 출력
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
