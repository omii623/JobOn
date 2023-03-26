package hu.jobon.controller;

import hu.jobon.database.Database;
import hu.jobon.database.model.Munkaltato;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import hu.jobon.App;

import java.io.Console;
import java.io.IOException;
import java.util.List;


public class LoginController {
    @FXML
    TextField userTextFiled;

    @FXML
    PasswordField passPassFiled;

    @FXML
    void login() throws IOException {



        Database db = new Database();
        List<Munkaltato> AllMunkaltato = db.getMunkaltatoAll();
        for (Munkaltato m : AllMunkaltato) {
            //System.out.println(m.getEmail_cim() + " - " + m.getJelszo() +
            //        " - " +m.getID() + " - " + m.getCegnev() + " - " + m.getMegalapitas_eve());
            System.out.println(m.getEmail_cim() + " - " + m.getJelszo());
            if(m.getEmail_cim().equals(userTextFiled.getText()) && m.getJelszo().equals(passPassFiled.getText())){
                System.out.println("sikeres belépés");
                App.setRoot("home");
            }
        }
    }
}
