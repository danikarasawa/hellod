package daniela.dev.hellod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellodApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellodApplication.class, args);
		System.out.println("HelloD, girl ;)");
	}
}
