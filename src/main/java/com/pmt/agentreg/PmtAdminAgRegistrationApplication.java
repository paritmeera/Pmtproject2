package com.pmt.agentreg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.pmt.agentreg.model.PhotoUpload;


//import com.pmt.agentreg.model.PhotoUpload1;

@SpringBootApplication
@ComponentScan("com.pmt.agentreg")
@EnableConfigurationProperties({
   PhotoUpload.class
})
public class PmtAdminAgRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PmtAdminAgRegistrationApplication.class, args);
		System.out.println("<----------------***---BOOTED--****----------------------->");
	}

}
