    package com.common;

    public class SearchCondition {
        // * 주석을 지우고 검색 조건을 담은 객체를 생성할 java class를 작성하세요.
        // * 모든 필드는 String 타입으로 작성하시고, 필수로 작성해야 하는 필드는 option(검색 조건), value(검색어)입니다.
        // * DTO 객체에 대하여 기본적으로 작성해야 하는 사항 5가지 항목을 반드시 작성하세요.

        private String option;
        private String value;
        private String productName;
        private String salesStore;
        private String newProduct;

        @Override
        public String toString() {
            return "SearchCondition{" +
                    "option='" + option + '\'' +
                    ", value='" + value + '\'' +
                    ", productName='" + productName + '\'' +
                    ", salesStore='" + salesStore + '\'' +
                    ", newProduct='" + newProduct + '\'' +
                    '}';
        }

        public String getNewProduct() {
            return newProduct;
        }

        public void setNewProduct(String newProduct) {
            this.newProduct = newProduct;
        }

        public SearchCondition(String newProduct) {
            this.newProduct = newProduct;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getSalesStore() {
            return salesStore;
        }

        public void setSalesStore(String salesStore) {
            this.salesStore = salesStore;
        }

        public SearchCondition() {
        }

        public SearchCondition(String option, String value) {
            this.option = option;
            this.value = value;
        }

        public String getOption() {
            return option;
        }

        public void setOption(String option) {
            this.option = option;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public void setSearchOption(String searchOption) {
        }

        public void setSearchValue(String searchValue) {
        }
        public String getProductName() {
            return productName;
        }
    }


