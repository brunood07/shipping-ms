package br.com.brunood.shipping.dtos;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DimensionDTO {

    private double weight;
    private double width;
    private double height;
}
