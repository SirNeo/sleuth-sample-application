package es.jmpalma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SleuthSampleApplication {

	private final static Logger logger = LoggerFactory.getLogger(SleuthSampleApplication.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(SleuthSampleApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping("/")
	public String home() {
		logger.info("you called home");
		return "Hello World";
	}

	@RequestMapping("/callhome")
	public String callHome() {
		logger.info("calling home");
		return restTemplate.getForObject("http://localhost:8890", String.class);
	}
}
