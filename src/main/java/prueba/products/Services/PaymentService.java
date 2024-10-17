package prueba.products.Services;

import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.preference.Preference;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {

    public Preference createPreference(String title, String description, String pictureUrl, String categoryId, int quantity, String currencyId, BigDecimal unitPrice) throws MPException, MPApiException {
        // Crear un item
        PreferenceItemRequest itemRequest = PreferenceItemRequest.builder()
                .id("1234")
                .title(title)
                .description(description)
                .pictureUrl(pictureUrl)
                .categoryId(categoryId)
                .quantity(quantity)
                .currencyId(currencyId)
                .unitPrice(unitPrice)
                .build();

        List<PreferenceItemRequest> items = new ArrayList<>();
        items.add(itemRequest);

        // Crear la preferencia
        PreferenceRequest preferenceRequest = PreferenceRequest.builder()
                .items(items)
                .build();

        PreferenceClient client = new PreferenceClient();
        return client.create(preferenceRequest);
    }
}