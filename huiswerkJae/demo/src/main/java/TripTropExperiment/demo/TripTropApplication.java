package TripTropExperiment.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TripTropApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripTropApplication.class, args);
	}

}

@Component
class AppRunner implements CommandLineRunner {

	@Autowired
	private LoginService loginService;

	@Autowired
	private AccessCheckService accessCheckService;

	@Override
	public void run(String... args) throws Exception {
		// Perform login and retrieve token
		String token = loginService.performLogin("edevries", "3g2Rw9sT1x");

		// Use the token to check app access
		if (token != null && !token.isEmpty()) {
			accessCheckService.checkAppAccess("edevries", "triptop", token);
		} else {
			System.out.println("Failed to retrieve token. Cannot proceed with access check.");
		}
	}
}