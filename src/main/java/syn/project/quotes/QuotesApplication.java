package syn.project.quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import syn.project.quotes.services.BashParser;
import syn.project.quotes.services.QuoteService;

@SpringBootApplication
public class QuotesApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(QuotesApplication.class, args);

	}

	@Autowired
	QuoteService service;

	@Override
	public void run(String... args) throws Exception {
	}



}
