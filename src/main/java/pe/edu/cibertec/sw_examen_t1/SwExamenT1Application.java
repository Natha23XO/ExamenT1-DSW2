package pe.edu.cibertec.sw_examen_t1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SwExamenT1Application {

	public static void main(String[] args) {
		SpringApplication.run(SwExamenT1Application.class, args);
	}

}
