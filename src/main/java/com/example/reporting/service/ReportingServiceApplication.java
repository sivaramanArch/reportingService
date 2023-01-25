package com.example.reporting.service;

import com.example.reporting.service.service.OrderReportingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan("com.example.reporting.service")
@RequiredArgsConstructor
public class ReportingServiceApplication implements CommandLineRunner {

	private final OrderReportingService orderReportingService;

	public static void main(String[] args) {
		SpringApplication.run(ReportingServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 orderReportingService.insertRecordsIntoOrderTable(1000);
	}
}
