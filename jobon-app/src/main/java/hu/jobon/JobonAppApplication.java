package hu.jobon;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.jobon.database.*;
import hu.jobon.tables.*;

//import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JobonAppApplication {

	@Autowired
    DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(JobonAppApplication.class, args);
		
		Database db = new Database();
		List<Munkaltato> AllMunkaltato = db.getMunkaltatoAll();
		for (Munkaltato m : AllMunkaltato) {
			System.out.println(m.getEmail_cim() + " - " + m.getJelszo() + 
			" - " +m.getID() + " - " + m.getCegnev() + " - " + m.getMegalapitas_eve());
		}
	}
}
