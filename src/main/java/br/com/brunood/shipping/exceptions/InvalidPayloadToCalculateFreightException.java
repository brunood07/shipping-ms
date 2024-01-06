package br.com.brunood.shipping.exceptions;

public class InvalidPayloadToCalculateFreightException extends RuntimeException {
    public InvalidPayloadToCalculateFreightException() {
        super("Invalid payload");
    }
}
