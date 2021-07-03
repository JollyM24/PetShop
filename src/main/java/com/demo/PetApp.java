package com.demo;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PetApp {

	public static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {
		Application.launch(StartFX.class);
	}

}
