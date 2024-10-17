package prueba.products.Controllers;

import org.springframework.web.bind.annotation.*;
import prueba.products.Entity.Product;
import prueba.products.Repository.ProductRepository;
import prueba.products.Services.MercadoPagoService;

import java.util.List;

@CrossOrigin
@RestController
public class ProductController {

    private final ProductRepository repository;

    private final MercadoPagoService mercadoPagoService;


    public ProductController(MercadoPagoService mercadoPagoService, ProductRepository repository){
        this.repository = repository;
        this.mercadoPagoService = mercadoPagoService;
    }


    @PostMapping("/add")
    public Product product(@RequestBody Product newProduct){
        return repository.save(newProduct);
    }

    @GetMapping("/product")
    public List<Product> all(){
        return repository.findAll();
    }

    @GetMapping("/crear-preferencia")
    public String crearPreferencia() {
        return mercadoPagoService.crearPreferencia();
    }
}
