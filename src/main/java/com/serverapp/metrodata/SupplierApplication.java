package com.serverapp.metrodata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SupplierApplication {

	public static void main(String[] args) {
		SpringApplication.run(SupplierApplication.class, args);

		System.out.println();
		System.out.println("Server is running");
		System.out.println();
	}

}
