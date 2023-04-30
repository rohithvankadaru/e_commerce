package com.example.e.commerce.transformer;

import com.example.e.commerce.dto.RequestDto.ProductAddRequeat;
import com.example.e.commerce.dto.ResponseDto.ProductAddResponse;
import com.example.e.commerce.dto.ResponseDto.ProductResponse;
import com.example.e.commerce.entity.Product;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class ProductTransformer {
    public static Product productAddRequestToProduct(ProductAddRequeat productAddRequeat){
        return Product.builder()
                .productCategory(productAddRequeat.getProductCategory())
                .name(productAddRequeat.getName())
                .price(productAddRequeat.getPrice())
                .quantity(productAddRequeat.getQuantity())
                .build();
    }

    public static ProductAddResponse productToProductAddResponse(Product product){
        return ProductAddResponse.builder()
                .productName(product.getName())
                .message("product added")
                .quantity(product.getQuantity())
                .seller(product.getSeller().getName())
                .build();
    }
    public static ProductResponse productToProductResponse(Product product){
        return ProductResponse.builder()
                .sellerName(product.getSeller().getName())
                .name(product.getName())
                .price(product.getPrice())
                .productCategory(product.getProductCategory())
                .quantity(product.getQuantity())
                .build();
    }
}
