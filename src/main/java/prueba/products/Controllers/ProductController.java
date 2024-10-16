package prueba.products.Controllers;

import org.springframework.web.bind.annotation.*;
import prueba.products.Entity.Product;
import prueba.products.Repository.ProductRepository;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository){
        this.repository = repository;
    }


    @PostMapping("/add")
    public Product product(@RequestBody Product newProduct){
        return repository.save(newProduct);
    }

    @GetMapping("/product")
    public List<Product> all(){
        return repository.findAll();
    }
}
