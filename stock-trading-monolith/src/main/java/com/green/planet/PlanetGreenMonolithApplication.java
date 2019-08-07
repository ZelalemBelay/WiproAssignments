package com.green.planet;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class PlanetGreenMonolithApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PlanetGreenMonolithApplication.class, args);
	}

}
