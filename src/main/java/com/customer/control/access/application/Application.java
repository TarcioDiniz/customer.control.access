package com.customer.control.access.application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
// 1) escaneia services, controllers, etc
@ComponentScan("com.customer.control.access")
// 2) escaneia suas interfaces de repositório
@EnableJpaRepositories("com.customer.control.access.domain.repositories")
// 3) escaneia suas entidades JPA
@EntityScan("com.customer.control.access.domain.entities")
@EnableJpaAuditing
@OpenAPIDefinition(
        info = @Info(
                title = "CustomerController Control API",
                version = "v1",
                description = "API para controle de acesso"
        )
)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
