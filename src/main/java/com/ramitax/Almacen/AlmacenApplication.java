package com.ramitax.Almacen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.ramitax"})
@EntityScan(basePackages = {"com.ramitax"})
@ComponentScan(basePackages = {"com.ramitax"})
@EnableAspectJAutoProxy
public class AlmacenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlmacenApplication.class, args);
	}

}
