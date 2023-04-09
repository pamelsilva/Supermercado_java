package com.supermercado.supermercadoprodutos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class SupermercadoProdutosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupermercadoProdutosApplication.class, args);
	}

}
