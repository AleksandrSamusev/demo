package MyExample1.demo.controller;

import MyExample1.demo.dto.ProductDto;
import MyExample1.demo.service.ProductServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceImpl productService;

    @Autowired
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping
    public Iterable<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable Long productId) {
        productService.deleteProductById(productId);
    }

    @PutMapping("/{productId}")
    ResponseEntity<ProductDto> putProduct(@RequestBody ProductDto productDto,
                                          @PathVariable Long productId) {
        return productService.putProduct(productDto, productId);
    }

    @PatchMapping("/{productId}")
    public ProductDto updateProduct(@RequestBody ProductDto productDto, @PathVariable Long productId) {
        return productService.updateProduct(productDto, productId);
    }

}
