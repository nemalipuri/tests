package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class HelloClientApplication {
	@Autowired
	RestTemplate client;

	@RequestMapping("/")
	public String hello() {
		return client.getForObject("http://simple/", String.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloClientApplication.class, args);
	}

}