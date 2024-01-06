package br.com.brunood.shipping.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductDTO {

    private String displayName;
    @NotNull(message = "value missing")
    private double value;
    @NotNull(message = "dimensions missing")
    private DimensionDTO dimension;
}
