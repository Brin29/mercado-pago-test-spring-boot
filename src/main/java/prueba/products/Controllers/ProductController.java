package prueba.products.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import prueba.products.Repository.ProductRepository;

public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository){
        this.repository = repository;
    }


    @PostMapping("/add")
    public
}
