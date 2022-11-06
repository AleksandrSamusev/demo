package MyExample1.demo.service;

import MyExample1.demo.dto.ProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    void deleteProductById(Long productId);

    ResponseEntity<ProductDto> putProduct(ProductDto productDto, Long productId);
}
