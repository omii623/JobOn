package hu.jobon.jobonapp;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.jobon.database.*;

@SpringBootApplication
public class JobonAppApplication {

	@Autowired
    DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(JobonAppApplication.class, args);
		
		Database db = new Database();
		db.connect();
	}
}
