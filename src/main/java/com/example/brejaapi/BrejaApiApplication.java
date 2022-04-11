package com.example.brejaapi;

import com.example.brejaapi.domain.repository.CervejaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BrejaApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BrejaApiApplication.class, args);
	}

	@Autowired
	CervejaRepository cr;

	@Override
	public void run(String... args) throws Exception
	{
		
	}

}
