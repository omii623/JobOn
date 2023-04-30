package hu.jobon.controller;

import hu.jobon.database.Database;
import hu.jobon.database.model.*;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import hu.jobon.App;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LoginController {
    Database db = new Database();
    @FXML
    TextField userTextFiled;
    @FXML
    PasswordField passPassFiled;
    public static Felhasznalo felhasznalo = new Felhasznalo();

    @FXML
    void login() throws IOException {
        List<Felhasznalo> AllFelhasznalo = db.getFelhasznaloAll();
        for (Felhasznalo f : AllFelhasznalo) {
            System.out.println(f.getEmail_cim() + " - " + f.getJelszo() + " - " + f.getTipus());
            if(f.getEmail_cim().equals(userTextFiled.getText()) && f.getJelszo().equals(passPassFiled.getText())){
                System.out.println("sikeres belépés");
                felhasznalo.setID(f.getID());
                felhasznalo.setEmail_cim(f.getEmail_cim());
                felhasznalo.setJelszo(f.getJelszo());
                felhasznalo.setTipus(f.getTipus());
                if(f.getTipus() == 1) {
                    App.setRoot("homeAdmin");
                }
                else if(f.getTipus() == 2) {
                    App.setRoot("homeAllaskereso");
                }
                else if(f.getTipus() == 3){
                    App.setRoot("homeMunkaltato");
                }
            }
        }
    }


    @FXML
    void regist() throws IOException {
        App.setRoot("regist");
    }
}
