package br.com.brunood.shipping.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DimensionDTO {

    @NotNull(message = "dimension missing")
    private double weight;
    @NotNull(message = "dimension missing")
    private double width;
    @NotNull(message = "dimension missing")
    private double height;
}
