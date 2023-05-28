package com.management.category.model.dto;

public class CategoryDTO {
    private String categoryCode;
    private String categoryName;

    public CategoryDTO() {
        // 기본 생성자
    }

    public CategoryDTO(String categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryDTO)) return false;
        CategoryDTO that = (CategoryDTO) o;
        return getCategoryCode().equals(that.getCategoryCode());
    }

    @Override
    public int hashCode() {
        return getCategoryCode().hashCode();
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryCode='" + categoryCode + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
