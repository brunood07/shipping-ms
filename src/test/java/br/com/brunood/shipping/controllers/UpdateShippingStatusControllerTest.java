package br.com.brunood.shipping.controllers;

import br.com.brunood.shipping.usecases.UpdateShippingStatusUseCase;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UpdateShippingStatusControllerTest {

    @Mock
    UpdateShippingStatusUseCase updateShippingStatusUseCase;
    @InjectMocks
    UpdateShippingStatusController updateShippingStatusController;

    private final String baseUrl = "/api/v1/shipping/update";
    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(updateShippingStatusController);
    }

    @Test
    void shouldReturn404WithAMalformedUrl() {
        String malformedUrl = "/api/v1/ship";

        given().when()
                .put(malformedUrl)
                .then()
                .statusCode(404);
    }

    @Test
    void shouldReturn200WhenUpdateShippingStatus() {

        given().when()
                .put(baseUrl + "/1?status=PROCESSING")
                .then()
                .statusCode(200);
    }

}
