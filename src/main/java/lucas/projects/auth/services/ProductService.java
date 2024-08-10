package lucas.projects.auth.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lucas.projects.auth.domain.product.Product;
import lucas.projects.auth.domain.product.ProductRequestDTO;
import lucas.projects.auth.domain.product.ProductResponseDTO;
import lucas.projects.auth.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public void postProduct(ProductRequestDTO body) {
        Product newProduct = new Product(body);
        this.repository.save(newProduct);
    }

    public List<ProductResponseDTO> getAllProducts() {
        return repository.findAll().stream().map(ProductResponseDTO::new).toList();
    }

}
