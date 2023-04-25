package hu.jobon.controller;

import hu.jobon.App;
import hu.jobon.database.Database;
import hu.jobon.database.model.Allasajanlat;
import hu.jobon.database.model.Felhasznalo;
import hu.jobon.database.model.Jelentkezes;
import hu.jobon.database.servicemodel.JelentkezokMunkaltatonkent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import static hu.jobon.controller.LoginController.felhasznalo;

public class HomeMunkaltatoController {
    @FXML
    public TableView<Allasajanlat> tv1;
    @FXML
    public TableView tv2;
    @FXML
    public TextField email;
    @FXML
    public TextField pass;


    Database db = new Database();
    @FXML
    public void initialize(){
        TableColumn IdCol = new TableColumn("ID");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn munkaltatoCol = new TableColumn("felhasznalo_ID");
        munkaltatoCol.setCellValueFactory(new PropertyValueFactory<>("felhasznalo_ID"));
        TableColumn oraberCol = new TableColumn("oraber");
        oraberCol.setCellValueFactory(new PropertyValueFactory<>("oraber"));
        TableColumn pozicioCol = new TableColumn("pozicio");
        pozicioCol.setCellValueFactory(new PropertyValueFactory<>("pozicio"));
        TableColumn munkakorCol = new TableColumn("munkakor");
        munkakorCol.setCellValueFactory(new PropertyValueFactory<>("munkakor"));
        TableColumn leirasCol = new TableColumn("leiras");
        leirasCol.setCellValueFactory(new PropertyValueFactory<>("leiras"));
        TableColumn letrehozasCol = new TableColumn("letrehozas_ideje");
        letrehozasCol.setCellValueFactory(new PropertyValueFactory<>("letrehozas_ideje"));
        TableColumn actionCol = new TableColumn("action");
        actionCol.setCellFactory(param -> new TableCell<>() {
            private final Button deleteBtn = new Button("Delete");
            private final Button editBtn = new Button("Edit");

            {
                deleteBtn.setOnAction(event -> {

//                    Allasajanlat allasajanlat =  getTableRow().getItem();
                    Allasajanlat a = tv1.getSelectionModel().getSelectedItem();
                    deleteAllasajanlat(a.getID());
                    listazz();

                });

                editBtn.setOnAction(event -> {
//                    Order o = getTableRow().getItem();
//                    editOrder(o);
//                    refreshTable();
                });
                HBox container = new HBox();
                container.getChildren().addAll(editBtn, deleteBtn);
                container.setSpacing(10.0);
                setGraphic(container);
            }


        });

        tv1.getColumns().addAll(IdCol, munkaltatoCol, oraberCol, pozicioCol, munkakorCol, leirasCol, letrehozasCol, actionCol);

        TableColumn pozCol = new TableColumn("pozicio");
        pozCol.setCellValueFactory(new PropertyValueFactory<>("pozicio"));
        TableColumn munkaCol = new TableColumn("munkakor");
        munkaCol.setCellValueFactory(new PropertyValueFactory<>("munkakor"));
//        TableColumn leiras2Col = new TableColumn("leiras");
//        leiras2Col.setCellValueFactory(new PropertyValueFactory<>("leiras"));
        TableColumn teljes_nevCol = new TableColumn("allaskereso_teljes_nev");
        teljes_nevCol.setCellValueFactory(new PropertyValueFactory<>("allaskereso_teljes_nev"));
        tv2.getColumns().addAll( pozCol, munkaCol, teljes_nevCol);

 }



    private String GET_ALLASAJANLATAIM;
    @FXML
    void listazz() {
        GET_ALLASAJANLATAIM = "SELECT * FROM C##SAELDC.ALLASAJANLAT WHERE FID= '" + felhasznalo.getID() + "'";
        List<Allasajanlat> allasok = db.getAllasajanlataim(GET_ALLASAJANLATAIM);
        tv1.getItems().clear();
        for (Allasajanlat allas : allasok) {
            System.out.println(allas.getMunkakor());
            tv1.getItems().add(allas);
        }
    }

    public void adataim(ActionEvent actionEvent) {
        email.setText(felhasznalo.getEmail_cim());
        pass.setText(felhasznalo.getJelszo());
    }

    private String UPDATE_ADMIN;

    public void modositas(ActionEvent actionEvent) {
        felhasznalo.setEmail_cim(email.getText());
        felhasznalo.setJelszo(pass.getText());
        UPDATE_ADMIN = "UPDATE C##SAELDC.FELHASZNALO SET EMAIL_CIM = '" + felhasznalo.getEmail_cim() + "', JELSZO ='" + felhasznalo.getJelszo() + "' WHERE ID = " + Integer.toString(felhasznalo.getID()) ;
        System.out.println(felhasznalo.getEmail_cim());
        System.out.println(felhasznalo.getJelszo());
        System.out.println(UPDATE_ADMIN);
        db.updateFelhasznalo(UPDATE_ADMIN);
    }


    public void ujallasajanlat(ActionEvent event) throws IOException {
        App.setRoot("ujAllasajanlat");

    }

    private void deleteAllasajanlat(int ID) {
        System.out.println("Info: "+ID);
        db.deleteAllasajanlat(ID);
    }

    public void listazzJelentkezok(ActionEvent event) {
        List<JelentkezokMunkaltatonkent> jelentkezesek = db.getJelentkezok();
        tv2.getItems().clear();
        for (JelentkezokMunkaltatonkent jelentkezes : jelentkezesek) {
            tv2.getItems().add(jelentkezes);
        }
    }
}
