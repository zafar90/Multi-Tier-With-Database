package com.example.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankappApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
		
		String nullString = null; // This will throw a NullPointerException
                System.out.println(nullString.length());

		String password = "1234";
                System.out.println("Password" + password);
	}

}
