package br.com.brunood.shipping.controllers;

import br.com.brunood.shipping.enums.ShippingStatus;
import br.com.brunood.shipping.usecases.UpdateShippingStatusUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shipping")
public class UpdateShippingStatusController {

    @Autowired
    private UpdateShippingStatusUseCase updateShippingStatusUseCase;

    @PutMapping("/update/{orderId}")
    public ResponseEntity<Object> updateShippingStatus(@PathVariable(name = "orderId") Long orderId, @RequestParam(name = "status") ShippingStatus status) {
        this.updateShippingStatusUseCase.execute(orderId, status);
        return ResponseEntity.ok().body("updated");
    }

}
