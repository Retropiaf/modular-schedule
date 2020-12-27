package com.hyperplan.modularschedule;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.UnknownHostException;

@SpringBootApplication
public class ModularScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModularScheduleApplication.class, args);

	}

}
