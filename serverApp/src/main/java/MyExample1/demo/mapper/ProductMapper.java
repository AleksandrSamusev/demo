package MyExample1.demo.mapper;

import MyExample1.demo.dto.ProductDto;
import MyExample1.demo.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductMapper {
    public static Product toProduct(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setOrderLines(productDto.getOrderLines());
        return product;
    }

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setOrderLines(product.getOrderLines());
        return productDto;
    }

    public static List<Product> toProducts(List<ProductDto> productDtos) {
        List<Product> products = new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            products.add(toProduct(productDto));
        }
        return products;
    }

    public static List<ProductDto> toProductDtos(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(toProductDto(product));
        }
        return productDtos;
    }
}
