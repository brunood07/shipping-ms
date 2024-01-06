package br.com.brunood.shipping.dtos;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CalculateFreightUseCaseResponse {

    List<ShippingMethodDTO> shippingMethods;
}
