package lucas.projects.auth.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lucas.projects.auth.domain.product.ProductRequestDTO;
import lucas.projects.auth.domain.product.ProductResponseDTO;
import lucas.projects.auth.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Void> postProduct(@RequestBody @Valid ProductRequestDTO body) {
        productService.postProduct(body);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
