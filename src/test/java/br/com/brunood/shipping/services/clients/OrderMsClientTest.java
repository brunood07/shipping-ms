package br.com.brunood.shipping.services.clients;

import br.com.brunood.shipping.enums.ShippingStatus;
import br.com.brunood.shipping.usecases.clients.OrdersMsClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderMsClientTest {

    public static MockWebServer mockWebServer;
    private OrdersMsClient orderMsClient;

    @BeforeAll
    static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start();
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @BeforeEach
    void initialize() {
        String baseUrl = String.format("http://localhost:%s", mockWebServer.getPort());
        orderMsClient = new OrdersMsClient(WebClient.builder(), "");
        WebClient webClient = WebClient.builder().baseUrl(baseUrl).build();
        ReflectionTestUtils.setField(orderMsClient, "webClient", webClient);
    }

    @Test
    void shouldBeAbleToGetPaymentInfoByOrderId() throws InterruptedException {
        mockWebServer.enqueue((new MockResponse()
                .setBody("")
                .setResponseCode(200)
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)));

        var payment = orderMsClient.updateShippingStatus(1L, ShippingStatus.PROCESSING);

        RecordedRequest recordedRequest = mockWebServer.takeRequest();
        assertEquals("PUT", recordedRequest.getMethod());
        assertEquals("/api/v1/shipping/update/1?status=PROCESSING", recordedRequest.getPath());
    }
}
