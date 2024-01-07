package br.com.brunood.shipping.factories;

import br.com.brunood.shipping.dtos.CalculateFreightUseCaseRequest;
import br.com.brunood.shipping.dtos.DimensionDTO;
import br.com.brunood.shipping.dtos.ProductDTO;

import java.util.ArrayList;
import java.util.List;

public class FreightFactoryTest {

    public static CalculateFreightUseCaseRequest payload() {

        List<ProductDTO> products = new ArrayList<>();

        var dim = DimensionDTO.builder()
                .height(1)
                .weight(1)
                .width(1)
                .build();

        products.add(ProductDTO.builder()
                .dimension(dim)
                .displayName("Test")
                .value(10)
                .build());

        return CalculateFreightUseCaseRequest.builder()
                .products(products)
                .build();
    }

    public static CalculateFreightUseCaseRequest emptyPayload() {
        return CalculateFreightUseCaseRequest.builder()
                .products(new ArrayList<>())
                .build();
    }
}
