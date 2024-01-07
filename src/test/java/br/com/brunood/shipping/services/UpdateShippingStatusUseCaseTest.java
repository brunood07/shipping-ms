package br.com.brunood.shipping.services;

import br.com.brunood.shipping.enums.ShippingStatus;
import br.com.brunood.shipping.usecases.UpdateShippingStatusUseCase;
import br.com.brunood.shipping.usecases.clients.OrdersMsClient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UpdateShippingStatusUseCaseTest {

    @Mock
    OrdersMsClient ordersMsClient;
    @InjectMocks
    UpdateShippingStatusUseCase updateShippingStatusUseCase;

    @Test
    void shouldBeAbleToUpdateShippingStatus() {
        when(ordersMsClient.updateShippingStatus(anyLong(), any())).thenReturn("");

        updateShippingStatusUseCase.execute(1L, ShippingStatus.PROCESSING);

        verify(ordersMsClient, times(1)).updateShippingStatus(anyLong(), any());
    }
}
