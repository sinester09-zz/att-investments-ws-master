package br.com.attinvestments;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class WsApplication {
	
	private static final Logger log = LoggerFactory.getLogger(WsApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext config = SpringApplication.run(WsApplication.class, args);
		Environment env = config.getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" + "Application '{}' is running!\n\t"
						+ "Profile Active is :{}\n" + "----------------------------------------------------------",
						WsApplication.class.getCanonicalName(), Arrays.asList(env.getActiveProfiles())
		);
	}
}
