package demo.rest.boot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"demo.rest.controller"})
public class OrderReceiptApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderReceiptApplication.class, args);
	}
}
