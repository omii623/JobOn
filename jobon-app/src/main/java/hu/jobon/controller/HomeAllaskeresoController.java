package hu.jobon.controller;

import hu.jobon.App;
import hu.jobon.database.Database;
import hu.jobon.database.model.Allasajanlat;
import hu.jobon.database.model.Allaskereso;
import hu.jobon.database.model.Munkaltato;
import hu.jobon.database.model.Szakma;
import hu.jobon.database.servicemodel.AllasajanlatCegesAdatokkal;
import hu.jobon.database.servicemodel.Jelentkezeseim;
import hu.jobon.database.servicemodel.JelentkezokMunkaltatonkent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.io.IOException;
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
    public TableView<AllasajanlatCegesAdatokkal> tv2;
    @FXML
    public TableView<Jelentkezeseim> tv3;
    @FXML
    public Button denyBtn;
    @FXML
    public TextField searchTF;
    @FXML
    public Button applyBtn;
    @FXML
    public TextField szakmaa;

    public static Szakma szakma = new Szakma();

    Database db = new Database();
    @FXML
    public void initialize(){

        TableColumn IdCol = new TableColumn("ID");
        IdCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn cegnevCol = new TableColumn("cegnev");
        cegnevCol.setCellValueFactory(new PropertyValueFactory<>("cegnev"));
        cegnevCol.setMinWidth(130);
        TableColumn varosCol = new TableColumn("varos");
        varosCol.setCellValueFactory(new PropertyValueFactory<>("varos"));
        TableColumn cimCol = new TableColumn("cim");
        cimCol.setCellValueFactory(new PropertyValueFactory<>("cim"));
        cimCol.setMinWidth(150);
        TableColumn moraberCol = new TableColumn("oraber");
        moraberCol.setCellValueFactory(new PropertyValueFactory<>("oraber"));
        TableColumn mpozicioCol = new TableColumn("pozicio");
        mpozicioCol.setCellValueFactory(new PropertyValueFactory<>("pozicio"));
        mpozicioCol.setMinWidth(150);
        TableColumn mmunkakorCol = new TableColumn("munkakor");
        mmunkakorCol.setCellValueFactory(new PropertyValueFactory<>("munkakor"));
        TableColumn mleirasCol = new TableColumn("leiras");
        mleirasCol.setCellValueFactory(new PropertyValueFactory<>("leiras"));
        mleirasCol.setMinWidth(200);

        tv2.getColumns().addAll(IdCol, cegnevCol, varosCol, cimCol, moraberCol, mpozicioCol, mmunkakorCol, mleirasCol);

        TableColumn allasIDCol = new TableColumn("AID");
        allasIDCol.setCellValueFactory(new PropertyValueFactory<>("AID"));
        TableColumn oraber2Col = new TableColumn("oraber");
        oraber2Col.setCellValueFactory(new PropertyValueFactory<>("oraber"));
        TableColumn pozicio2Col = new TableColumn("pozicio");
        pozicio2Col.setCellValueFactory(new PropertyValueFactory<>("pozicio"));
        pozicio2Col.setMinWidth(150);
        TableColumn munkakor2Col = new TableColumn("munkakor");
        munkakor2Col.setCellValueFactory(new PropertyValueFactory<>("munkakor"));
        TableColumn leiras2Col = new TableColumn("leiras");
        leiras2Col.setCellValueFactory(new PropertyValueFactory<>("leiras"));
        leiras2Col.setMinWidth(200);
        tv3.getColumns().addAll(allasIDCol, oraber2Col, pozicio2Col, munkakor2Col, leiras2Col);

    }

    @FXML
    private void deleteJelentkezeseim() {
        Jelentkezeseim j = tv3.getSelectionModel().getSelectedItem();
        db.deleteJelentkezeseim(j.getAID());
        listazzJelentkezeseim();

    }

    @FXML
    private void applyAllasajanlat() {
        AllasajanlatCegesAdatokkal a = tv2.getSelectionModel().getSelectedItem();
        db.applyAllasajanlat(a.getID(), felhasznalo.getID());
//        listazzmallasokat();
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

    private String INSERT_SZAKMA;

    public void szakmahozzaadas(ActionEvent actionEvent) {
        szakma.setSzakma(szakmaa.getText());
        szakma.setFelhasznalo_ID(felhasznalo.getID());
        //INSERT_SZAKMA = "INSERT INTO C##SAELDC.SZAKMA (SZAKMA, FID)  VALUES (" + "'" + szakma.getSzakma() + "', " + szakma.getFelhasznalo_ID() + " )";
        INSERT_SZAKMA = "BEGIN C##SAELDC.newSzakma(" + szakma.getFelhasznalo_ID() + ", '" +  szakma.getSzakma() + "'); END;";
        System.out.println(szakma.getSzakma());
        System.out.println(szakma.getFelhasznalo_ID());
        System.out.println(INSERT_SZAKMA);
        db.insertSzakma(INSERT_SZAKMA);
        szakmaa.setText("");
    }


    public void listazzmallasokat() {
        List<AllasajanlatCegesAdatokkal> allasok = db.getMAllasajanlatAll();
        tv2.getItems().clear();
        for (AllasajanlatCegesAdatokkal allas : allasok) {
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

    public void listazzeszerintm(ActionEvent event) {
        List<AllasajanlatCegesAdatokkal> allasok = db.getMAllasajanlat(searchTF.getText(), 1);
        tv2.getItems().clear();
        for (AllasajanlatCegesAdatokkal allas : allasok) {
            tv2.getItems().add(allas);
        }
    }

    public void listazzeszerintv(ActionEvent event) {
        List<AllasajanlatCegesAdatokkal> allasok = db.getMAllasajanlat(searchTF.getText(), 2);
        tv2.getItems().clear();
        for (AllasajanlatCegesAdatokkal allas : allasok) {
            tv2.getItems().add(allas);
        }
    }

    public void listazzeszerinto(ActionEvent event) {
        List<AllasajanlatCegesAdatokkal> allasok = db.getMAllasajanlat(searchTF.getText(),3);
        tv2.getItems().clear();
        for (AllasajanlatCegesAdatokkal allas : allasok) {
            tv2.getItems().add(allas);
        }
    }

    public void listazzAtlagonFeluli(ActionEvent event) {
        List<AllasajanlatCegesAdatokkal> allasok = db.getAtlagonFeluliAllasajanlat();
        tv2.getItems().clear();
        for (AllasajanlatCegesAdatokkal allas : allasok) {
            tv2.getItems().add(allas);
        }
    }

    public void kijelentkezes(ActionEvent event) throws IOException {
        App.setRoot("login");
    }
}
