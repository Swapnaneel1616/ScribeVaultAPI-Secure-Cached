//package com.neel.FinalJournal;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//@SpringBootApplication
//
//public class FinalJournalApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(FinalJournalApplication.class, args);
//	}
//
//}
package com.neel.FinalJournal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class FinalJournalApplication {
	public static void main(String[] args) {
		SpringApplication.run(FinalJournalApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();

	}

}
