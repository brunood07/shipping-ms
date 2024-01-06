package br.com.brunood.shipping.controllers;

import br.com.brunood.shipping.dtos.CalculateFreightUseCaseRequest;
import br.com.brunood.shipping.usecases.CalculateFreightUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/freight")
public class CalculateFreightController {

    @Autowired
    private CalculateFreightUseCase calculateFreightUseCase;

    @PostMapping("/calculate")
    public ResponseEntity<Object> calculateFreight(@RequestBody CalculateFreightUseCaseRequest data) {
        try {
            var shippingMethods = this.calculateFreightUseCase.execute(data);
            return ResponseEntity.ok().body(shippingMethods);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
