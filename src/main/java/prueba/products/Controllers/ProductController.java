package prueba.products.Controllers;

import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.web.bind.annotation.*;
import prueba.products.Dto.PreferenceDTO;
import prueba.products.Entity.Product;
import prueba.products.Repository.ProductRepository;
import prueba.products.Services.PaymentService;

import java.lang.reflect.Array;
import java.util.List;


@RestController
public class ProductController {

    private final ProductRepository repository;

    private final PaymentService paymentService;


    public ProductController(PaymentService paymentService, ProductRepository repository){
        this.repository = repository;
        this.paymentService = paymentService;
    }


    @PostMapping("/add")
    public Product product(@RequestBody Product newProduct){
        return repository.save(newProduct);
    }

    @GetMapping("/product")
    public List<Product> all(){
        return repository.findAll();
    }

    @CrossOrigin
    @PostMapping("/create-preference")
    public Preference createPreference(@RequestBody PreferenceDTO preferenceDTO) throws MPException, MPApiException {
        return paymentService.createPreference(
                preferenceDTO.getTitle(),
                preferenceDTO.getDescription(),
                preferenceDTO.getPictureUrl(),
                preferenceDTO.getCategoryId(),
                preferenceDTO.getQuantity(),
                preferenceDTO.getCurrencyId(),
                preferenceDTO.getUnitPrice()
        );
    }
}
