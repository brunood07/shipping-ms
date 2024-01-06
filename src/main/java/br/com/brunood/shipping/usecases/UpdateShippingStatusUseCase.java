package br.com.brunood.shipping.usecases;

import br.com.brunood.shipping.enums.ShippingStatus;
import br.com.brunood.shipping.usecases.clients.OrdersMsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateShippingStatusUseCase {

    @Autowired
    private OrdersMsClient ordersMsClient;

    public void updateShippingStatus(Long orderId, ShippingStatus status) {
        this.ordersMsClient.updateShippingStatus(orderId, status);
    }
}
