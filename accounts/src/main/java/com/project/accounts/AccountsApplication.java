package com.project.accounts;

import com.project.accounts.dto.AccountsInfoDto;
import com.project.accounts.dto.AccountsInfoDtoRecord;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableConfigurationProperties(value = {AccountsInfoDto.class})
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Account microservices REST API documentation",
				description = "Bank application microservice REST API documentation",
				version = "v0.0.1",
				contact = @Contact(
						name = "Amith Kashyap H",
						email = "amith@gmail.com",
						url = "amith.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "amith.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				url = "externaldocs.com",
				description = "Bank's Accounts microservice REST API documentation"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
