package prueba.products;

import com.mercadopago.MercadoPagoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsApplication {

	public static void main(String[] args) {
		MercadoPagoConfig.setAccessToken("APP_USR-3886391836267917-101614-a0e7ae1a2de1359e27c9d101896242e8-2027648044");
		SpringApplication.run(ProductsApplication.class, args);
	}

}
