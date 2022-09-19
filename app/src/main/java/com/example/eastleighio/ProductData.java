package com.example.eastleighio;

public class ProductData {
    private static String ProductName;
    private String ProductData;
    private Integer ProductImage;

    public ProductData(String productName, String productData, Integer productImage) {
        ProductName = productName;
        ProductData = productData;
        ProductImage = productImage;
    }

    public static String getProductName() {
        return ProductName;
    }



    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductData() {
        return ProductData;
    }

    public void setProductData(String productData) {
        ProductData = productData;
    }

    public Integer getProductImage() {
        return ProductImage;
    }

    public void setProductImage(Integer productImage) {
        ProductImage = productImage;
    }
}
