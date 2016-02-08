package com.msasecure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@EnableHystrixDashboard
@Controller
public class MonitorDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorDashboardApplication.class, args);
	}
}
