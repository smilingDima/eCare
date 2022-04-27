package ecareserver.local.ecare;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EcareServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(EcareServerApplication.class, args);
	}

}
