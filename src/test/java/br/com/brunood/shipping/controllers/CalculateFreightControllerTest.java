package br.com.brunood.shipping.controllers;

import br.com.brunood.shipping.dtos.CalculateFreightUseCaseRequest;
import br.com.brunood.shipping.exceptions.InvalidPayloadToCalculateFreightException;
import br.com.brunood.shipping.factories.FreightFactoryTest;
import br.com.brunood.shipping.usecases.CalculateFreightUseCase;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.doThrow;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculateFreightControllerTest {

    @Mock
    CalculateFreightUseCase calculateFreightUseCase;
    @InjectMocks
    CalculateFreightController calculateFreightController;

    private final String baseUrl = "/api/v1/freight/calculate";
    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.standaloneSetup(calculateFreightController);
    }

    @Test
    void shouldReturn404WithAMalformedUrl() {
        String malformedUrl = "/api/v1/freigh";

        given().when()
                .put(malformedUrl)
                .then()
                .statusCode(404);
    }

    @Test
    void shouldReturn200WhenCalculateFreightWithValidPayload() {

        given().body(FreightFactoryTest.payload()).contentType(MediaType.APPLICATION_JSON).when()
                .post(baseUrl)
                .then()
                .statusCode(200);
    }

    @Test
    void shouldReturn400WhenCalculateFreightWithInvalidPayload() {
        doThrow(InvalidPayloadToCalculateFreightException.class).when(calculateFreightUseCase).execute(FreightFactoryTest.emptyPayload());

        given().when()
                .post(baseUrl)
                .then()
                .statusCode(400);
    }
}
