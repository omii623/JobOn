package hu.jobon.controller;

import hu.jobon.App;
import hu.jobon.database.Database;
import hu.jobon.database.model.Allaskereso;
import hu.jobon.database.model.Munkaltato;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import oracle.ucp.proxy.annotation.Post;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class RegistController implements Initializable {
    @FXML
    TextField emailReg;
    @FXML
    PasswordField passReg;
    @FXML
    PasswordField passRegAgain;
    @FXML
    RadioButton placeHunter;
    @FXML
    RadioButton employer;
    @FXML
    AnchorPane pane;

    //*radio1*// álláskereső
    @FXML
    TextField nameP;
    @FXML
    DatePicker dateP;
    @FXML
    TextField cityP;
    @FXML
    TextField addresP;

    //*radio2*// munkáltató
    @FXML
    TextField nameE;
    @FXML
    TextField phoneE;
    @FXML
    TextField emailE;
    @FXML
    DatePicker dateE;
    @FXML
    TextField cityE;
    @FXML
    TextField addresE;

    Database db = new Database();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //radio1
        //nameP.setVisible(false);
        //dateP.setVisible(false);
        //cityP.setVisible(false);
        //addresP.setVisible(false);

        //radio2
        nameE.setVisible(false);
        phoneE.setVisible(false);
        emailE.setVisible(false);
        dateE.setVisible(false);
        cityE.setVisible(false);
        addresE.setVisible(false);

        dateP.setValue(LocalDate.of(2000,1,1));
        dateE.setValue(LocalDate.of(2000,1,1));
    }

    @FXML
    void radioButton1(){
        nameP.setVisible(true);
        dateP.setVisible(true);
        cityP.setVisible(true);
        addresP.setVisible(true);
        nameE.setVisible(false);
        phoneE.setVisible(false);
        emailE.setVisible(false);
        dateE.setVisible(false);
        cityE.setVisible(false);
        addresE.setVisible(false);
    }

    @FXML
    void radioButton2(){
        nameP.setVisible(false);
        dateP.setVisible(false);
        cityP.setVisible(false);
        addresP.setVisible(false);
        nameE.setVisible(true);
        phoneE.setVisible(true);
        emailE.setVisible(true);
        dateE.setVisible(true);
        cityE.setVisible(true);
        addresE.setVisible(true);
    }
    @FXML
    void regist() throws IOException {
        //System.out.println("-"+dateP.getValue().toString()+"-");

        if(employer.isSelected()){
            Munkaltato m = new Munkaltato(0,passReg.getText(),emailReg.getText(), nameE.getText(),
                    phoneE.getText(),emailE.getText(),dateE.getValue().toString(), cityE.getText(),addresE.getText());
            db.registFelhasznalo(m);
            App.setRoot("homeMunkaltato");
        }else{
            Allaskereso a = new Allaskereso(0,passReg.getText(),emailReg.getText(),nameP.getText(),
                    dateP.getValue().toString(),cityP.getText(),addresP.getText());
            db.registFelhasznalo(a);
            App.setRoot("homeAllaskereso");
        }//*/
    }

    @FXML
    void home() throws IOException {
        App.setRoot("login");
    }
}