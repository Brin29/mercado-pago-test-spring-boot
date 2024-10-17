package prueba.products.Services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@Service
public class MercadoPagoService {

    @Value("${mercadopago.accessToken}")
    private String accessToken;

    private static final String PREFERENCES_URL = "https://api.mercadopago.com/checkout/preferences";

    public String crearPreferencia() {
        RestTemplate restTemplate = new RestTemplate();

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        // Cuerpo de la petición
        Map<String, Object> item = new HashMap<>();
        item.put("title", "Producto de ejemplo");
        item.put("quantity", 1);
        item.put("unit_price", 75);

        Map<String, Object> preference = new HashMap<>();
        preference.put("items", new Object[]{item});

        Map<String, String> backUrls = new HashMap<>();
        backUrls.put("success", "https://www.tu-sitio.com/success");
        backUrls.put("failure", "https://www.tu-sitio.com/failure");
        backUrls.put("pending", "https://www.tu-sitio.com/pending");
        preference.put("back_urls", backUrls);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(preference, headers);

        // Hacer la solicitud POST
        ResponseEntity<Map> response = restTemplate.postForEntity(PREFERENCES_URL, request, Map.class);

        if (response.getStatusCode() == HttpStatus.CREATED) {
            return response.getBody().get("id").toString(); // Devuelve el ID de la preferencia creada
        } else {
            throw new RuntimeException("Error al crear la preferencia: " + response.getStatusCode());
        }
    }
}

