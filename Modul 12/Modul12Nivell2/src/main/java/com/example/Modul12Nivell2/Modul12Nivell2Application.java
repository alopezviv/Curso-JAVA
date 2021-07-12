package com.example.Modul12Nivell2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.XADataSourceAutoConfiguration;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, XADataSourceAutoConfiguration.class})
//https://www.yawintutor.com/failed-to-configure-a-datasource-failed-to-determine-a-suitable-driver-class/ LA SOLUCIO QUE HE TROBAT PERQUE NO FUNCIONAVA
public class Modul12Nivell2Application {

	public static void main(String[] args) {
		SpringApplication.run(Modul12Nivell2Application.class, args);
	}

}
