package br.com.brunood.shipping.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductDTO {

    private String displayName;
    private double value;
    private DimensionDTO dimension;
}
