package lucas.projects.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lucas.projects.auth.domain.product.Product;

public interface ProductRepository extends JpaRepository<Product, String> {
    
}
