package org.fondazionejac.architetturasw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Esame1Application {

	public static void main(String[] args) {
		SpringApplication.run(Esame1Application.class, args);
	}

}
