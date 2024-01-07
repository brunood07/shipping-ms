package br.com.brunood.shipping.services;

import br.com.brunood.shipping.exceptions.InvalidPayloadToCalculateFreightException;
import br.com.brunood.shipping.factories.FreightFactoryTest;
import br.com.brunood.shipping.usecases.CalculateFreightUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class CalculateFreightUseCaseTest {

    @InjectMocks
    CalculateFreightUseCase calculateFreightUseCase;

    @Test
    void shouldReturnExceptionIfProductsIsEmpty() {

        assertThrows(InvalidPayloadToCalculateFreightException.class, () -> calculateFreightUseCase.execute(FreightFactoryTest.emptyPayload()));
    }

    @Test
    void shouldBeAbleToCalculateFreight() {
        var methods = calculateFreightUseCase.execute(FreightFactoryTest.payload());

        assertEquals(2, methods.getShippingMethods().size());
    }
}
