package MyExample1.demo.service;

import MyExample1.demo.dto.ProductDto;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);

    Iterable<ProductDto> getAllProducts();

    void deleteProductById(Long productId);

    ResponseEntity<ProductDto> putProduct(ProductDto productDto, Long productId);

    ProductDto updateProduct(ProductDto productDto, Long productId);

    ProductDto getProductById(Long productId);
}
