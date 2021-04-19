package br.ml.simios;

import br.ml.simios.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class SimiosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimiosApplication.class, args);
	}
}
