package pe.com.unfpg.persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UnfpgMicroservicioPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnfpgMicroservicioPersonaApplication.class, args);
	}

}
