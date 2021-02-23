package com.example.polls;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		PollsApplication.class,
		Jsr310JpaConverters.class
})
public class PollsApplication {

	private static ConfigurableApplicationContext context;

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		context = SpringApplication.run(PollsApplication.class, args);

	}
		public static void restart() {
		System.out.println("inside restart !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			ApplicationArguments args = context.getBean(ApplicationArguments.class);
			System.out.println("inside restart !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

			Thread thread = new Thread(() -> {
				System.out.println("After line 1");

				context.close();
				System.out.println("After line 2");

				context = SpringApplication.run(PollsApplication.class, args.getSourceArgs());
				System.out.println("After line 3");

			});

			System.out.println("After line 4");

			thread.setDaemon(false);
			System.out.println("After line 5");

			thread.start();
			System.out.println("After line 6");

		}


	public static void stop() {
		System.out.println("inside stop !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		context.close();
		System.out.println("inside stop !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

}
