package ecare.local;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcareTariffApplication {
    private static final Logger logger = LogManager.getLogger(EcareTariffApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(EcareTariffApplication.class, args);
        logger.info("Application started");
    }
}
