package prueba.products.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import prueba.products.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
