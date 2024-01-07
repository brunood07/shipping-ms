package br.com.brunood.shipping.usecases;

import br.com.brunood.shipping.dtos.CalculateFreightUseCaseRequest;
import br.com.brunood.shipping.dtos.CalculateFreightUseCaseResponse;
import br.com.brunood.shipping.dtos.ShippingMethodDTO;
import br.com.brunood.shipping.exceptions.InvalidPayloadToCalculateFreightException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
public class CalculateFreightUseCase {

    public CalculateFreightUseCaseResponse execute(CalculateFreightUseCaseRequest data) {
        if (data.getProducts().isEmpty()) throw new InvalidPayloadToCalculateFreightException();

        final double[] value = {0};

        data.getProducts().forEach(product -> {
            var calcDimensions = product.getDimension().getWidth() / product.getDimension().getHeight();
            var calcWeight = product.getDimension().getWeight() / 3;
            var calcBase = product.getValue() / 20;
            var totalCalc = calcDimensions + calcWeight + calcBase;
            value[0] = value[0] + Math.floor(totalCalc);
        });

        List<ShippingMethodDTO> shippingMethods = new LinkedList<>();
        shippingMethods.add(ShippingMethodDTO.builder().deliveryDays(2).value(new BigDecimal(value[0] * 2)).displayName("Fast").build());
        shippingMethods.add(ShippingMethodDTO.builder().deliveryDays(4).value(new BigDecimal(value[0])).displayName("Economic").build());

        return CalculateFreightUseCaseResponse.builder()
                .shippingMethods(shippingMethods)
                .build();
    }

}
