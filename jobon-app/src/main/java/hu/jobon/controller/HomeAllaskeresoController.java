package hu.jobon.controller;

import hu.jobon.database.Database;
import hu.jobon.database.model.Allasajanlat;
import hu.jobon.database.model.Allaskereso;
import hu.jobon.database.model.Munkaltato;
import hu.jobon.database.servicemodel.Jelentkezeseim;
import hu.jobon.database.servicemodel.JelentkezokMunkaltatonkent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.util.List;

import static hu.jobon.controller.LoginController.felhasznalo;

public class HomeAllaskeresoController {
    @FXML
    public TableView tv1;
    @FXML
    public TextField email;
    @FXML
    public TextField pass;
    @FXML
    public TableView<Allasajanlat> tv2;
    @FXML
    public TableView<Jelentkezeseim> tv3;
    @FXML
    public Button denyBtn;

    Database db = new Database();
    @FXML
    public void initialize(){
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
        tv1.getColumns().addAll(munkaltatoCol, oraberCol, pozicioCol, munkakorCol, leirasCol, letrehozasCol);

        TableColumn IdCol = new TableColumn("ID");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn mmunkaltatoCol = new TableColumn("felhasznalo_ID");
        mmunkaltatoCol.setCellValueFactory(new PropertyValueFactory<>("felhasznalo_ID"));
        TableColumn moraberCol = new TableColumn("oraber");
        moraberCol.setCellValueFactory(new PropertyValueFactory<>("oraber"));
        TableColumn mpozicioCol = new TableColumn("pozicio");
        mpozicioCol.setCellValueFactory(new PropertyValueFactory<>("pozicio"));
        TableColumn mmunkakorCol = new TableColumn("munkakor");
        mmunkakorCol.setCellValueFactory(new PropertyValueFactory<>("munkakor"));
        TableColumn mleirasCol = new TableColumn("leiras");
        mleirasCol.setCellValueFactory(new PropertyValueFactory<>("leiras"));
        TableColumn mletrehozasCol = new TableColumn("letrehozas_ideje");
        mletrehozasCol.setCellValueFactory(new PropertyValueFactory<>("letrehozas_ideje"));
        TableColumn actionCol = new TableColumn("action");
        actionCol.setCellFactory(param -> new TableCell<>() {
            private final Button applyBtn = new Button("Apply");

            {


                applyBtn.setOnAction(event -> {
                   Allasajanlat a = tv2.getSelectionModel().getSelectedItem();
                    applyAllasajanlat(a.getID(), felhasznalo.getID());
                    listazz();
                });
                HBox container = new HBox();
                container.getChildren().addAll(applyBtn);
                container.setSpacing(10.0);
                setGraphic(container);
            }


        });
        tv2.getColumns().addAll(IdCol, mmunkaltatoCol, moraberCol, mpozicioCol, mmunkakorCol, mleirasCol, mletrehozasCol, actionCol);


        TableColumn allasIDCol = new TableColumn("AID");
        allasIDCol.setCellValueFactory(new PropertyValueFactory<>("AID"));
        TableColumn oraber2Col = new TableColumn("oraber");
        oraber2Col.setCellValueFactory(new PropertyValueFactory<>("oraber"));
        TableColumn pozicio2Col = new TableColumn("pozicio");
        pozicio2Col.setCellValueFactory(new PropertyValueFactory<>("pozicio"));
        TableColumn munkakor2Col = new TableColumn("munkakor");
        munkakor2Col.setCellValueFactory(new PropertyValueFactory<>("munkakor"));
        TableColumn leiras2Col = new TableColumn("leiras");
        leiras2Col.setCellValueFactory(new PropertyValueFactory<>("leiras"));
        TableColumn actionCol2 = new TableColumn("action");
        actionCol2.setCellFactory(param -> new TableCell<>() {
            private final Button denyBtn = new Button("Deny");

            {
                denyBtn.setOnAction(event -> {
                    Jelentkezeseim j = tv3.getSelectionModel().getSelectedItem();
                    deleteJelentkezeseim(j.getAID());
                    listazzJelentkezeseim();
                });
//                if () {
                    HBox container = new HBox();
                    container.getChildren().addAll(denyBtn);
                    container.setSpacing(10.0);
                    setGraphic(container);
//                }
            }

        });

        tv3.getColumns().addAll(allasIDCol, oraberCol, pozicioCol, munkakorCol, leirasCol, actionCol2);

    }

    @FXML
    private void deleteJelentkezeseim(int AID) {
        db.deleteJelentkezeseim(AID);
    }

    private void applyAllasajanlat(int aid, int fid) {
        db.applyAllasajanlat(aid, fid);
    }

    @FXML
    void listazz() {
        List<Allasajanlat> allasok = db.getAllasajanlatAll();
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


    public void listazzmallasokat() {
        List<Allasajanlat> allasok = db.getMAllasajanlatAll();
        tv2.getItems().clear();
        for (Allasajanlat allas : allasok) {
            System.out.println(allas.getMunkakor());
            tv2.getItems().add(allas);
        }
    }

    public void listazzJelentkezeseim() {
        List<Jelentkezeseim> jelentkezesek = db.getJelentkezeseim();
        tv3.getItems().clear();
        for (Jelentkezeseim jelentkezes : jelentkezesek) {
            tv3.getItems().add(jelentkezes);
        }
    }

}
