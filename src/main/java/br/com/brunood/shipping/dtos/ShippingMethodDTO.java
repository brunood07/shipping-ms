package br.com.brunood.shipping.dtos;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ShippingMethodDTO {

    private String displayName;
    private BigDecimal value;
    private int deliveryDays;
}
