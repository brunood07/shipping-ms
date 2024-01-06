package br.com.brunood.shipping.usecases.clients;

import br.com.brunood.shipping.enums.ShippingStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrdersMsClient {

    private final WebClient webClient;

    public OrdersMsClient(WebClient.Builder webClientBuilder, @Value("${rest.client.orders}") String baseURL) {
        this.webClient = webClientBuilder.baseUrl(baseURL).build();
    }

    public String updateShippingStatus(Long orderId, ShippingStatus status) {
        return this.webClient.put().uri("/api/v1/shipping/update/{orderId}?status={status}", orderId, status).retrieve().bodyToMono(String.class).block();
    }
}
