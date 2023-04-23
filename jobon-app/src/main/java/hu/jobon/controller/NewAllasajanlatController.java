package hu.jobon.controller;

import hu.jobon.App;
import hu.jobon.database.Database;
import hu.jobon.database.model.Allasajanlat;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static hu.jobon.controller.LoginController.felhasznalo;

public class NewAllasajanlatController {
    public TextField oraberTF;
    public TextField pozicioTF;
    public TextField munkakorTF;
    public TextArea leirasTF;

    Database db = new Database();

    public void allasajanlatHozzaadasa(ActionEvent event) throws IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        Allasajanlat a = new Allasajanlat(felhasznalo.getID(), Integer.parseInt(oraberTF.getText()), pozicioTF.getText(), munkakorTF.getText(), leirasTF.getText(), dtf.format(now));
        db.newAllasajanlat(a);

        App.setRoot("homeMunkaltato");
    }
}
