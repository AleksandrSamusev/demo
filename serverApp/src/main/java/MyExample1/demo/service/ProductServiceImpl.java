package MyExample1.demo.service;

import MyExample1.demo.dto.ProductDto;
import MyExample1.demo.exception.ProductNotFoundException;
import MyExample1.demo.mapper.ProductMapper;
import MyExample1.demo.model.Product;
import MyExample1.demo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        return ProductMapper.toProductDto(productRepository.save(ProductMapper.toProduct(productDto)));
    }

    @Override
    public Iterable<ProductDto> getAllProducts() {
        return ProductMapper.toProductDtos(productRepository.findAll());
    }

    @Override
    public void deleteProductById(Long productId) {
        validateProductId(productId);
        log.info("Product with id = {} deleted", productId);
        productRepository.deleteById(productId);
    }

    @Override
    public ResponseEntity<ProductDto> putProduct(ProductDto productDto, Long productId) {
        return (!productRepository.existsById(productId))
                ? new ResponseEntity<>(ProductMapper.toProductDto(productRepository
                .save(ProductMapper.toProduct(productDto))), HttpStatus.CREATED)
                : new ResponseEntity<>(ProductMapper.toProductDto(productRepository
                .save(ProductMapper.toProduct(productDto))), HttpStatus.OK);
    }

    @Override
    public ProductDto updateProduct(ProductDto productDto, Long productId) {
        if (productRepository.existsById(productId)) {
            Product product = productRepository.getReferenceById(productId);
            if (productDto.getName() != null) {
                product.setName(productDto.getName());
            }
            if (productDto.getDescription() != null) {
                product.setDescription(productDto.getDescription());
            }
            if (productDto.getPrice() != null) {
                product.setPrice(productDto.getPrice());
            }
            if (productDto.getOrderLines() != null) {
                product.setOrderLines(productDto.getOrderLines());
            }
            return ProductMapper.toProductDto(productRepository.save(product));
        }
        return ProductMapper.toProductDto(productRepository.save(ProductMapper.toProduct(productDto)));
    }

    @Override
    public ProductDto getProductById(Long productId) {
        validateProductId(productId);
        return ProductMapper.toProductDto(productRepository.getReferenceById(productId));
    }

    private void validateProductId(Long productId) {
        if (!productRepository.existsById(productId)) {
            log.info("Product with id = {} not found", productId);
            throw new ProductNotFoundException("Product not found");
        }
    }


}
