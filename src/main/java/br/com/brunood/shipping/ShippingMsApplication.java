package br.com.brunood.shipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ShippingMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingMsApplication.class, args);
	}

}
