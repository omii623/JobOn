package hu.jobon.controller;

import hu.jobon.database.Database;
import hu.jobon.database.model.*;
import hu.jobon.database.servicemodel.BerStat;
import hu.jobon.database.servicemodel.KorStat;
import hu.jobon.database.servicemodel.SzakmaStat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;

import java.util.List;

import static hu.jobon.controller.LoginController.felhasznalo;

public class HomeAdminController {
    @FXML
    public TableView tv1;
    @FXML
    public TableView tv2;
    @FXML
    public TableView tv3;
    @FXML
    public TableColumn munkaltatoCol;
    @FXML
    public TableColumn oraberCol;
    @FXML
    public TableColumn pozicioCol;
    @FXML
    public TableColumn munkakorCol;
    @FXML
    public TableColumn leirasCol;
    @FXML
    public TableColumn letrehozasCol;
    @FXML
    public TextField email;
    @FXML
    public TextField pass;
    @FXML
    public TableView tv4;
    @FXML
    public TableView tv5;
    @FXML
    public TableView tv6;
    public TextField berTF;
    @FXML
    public TableView tv7;

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


        TableColumn allaskeresoCol = new TableColumn("ID");
        allaskeresoCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn nevCol = new TableColumn("teljes_nev");
        nevCol.setCellValueFactory(new PropertyValueFactory<>("teljes_nev"));
        TableColumn szulCol = new TableColumn("szuletesi_datum");
        szulCol.setCellValueFactory(new PropertyValueFactory<>("szuletesi_datum"));
        TableColumn varosCol = new TableColumn("varos");
        varosCol.setCellValueFactory(new PropertyValueFactory<>("varos"));
        TableColumn cimCol = new TableColumn("cim");
        cimCol.setCellValueFactory(new PropertyValueFactory<>("cim"));
        tv2.getColumns().addAll(allaskeresoCol, nevCol, szulCol, varosCol, cimCol);


        TableColumn munkaltatoidCol = new TableColumn("ID");
        munkaltatoidCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn cegnevCol = new TableColumn("cegnev");
        cegnevCol.setCellValueFactory(new PropertyValueFactory<>("cegnev"));
        TableColumn telCol = new TableColumn("telefonszam");
        telCol.setCellValueFactory(new PropertyValueFactory<>("telefonszam"));
        TableColumn varosmCol = new TableColumn("varos");
        varosmCol.setCellValueFactory(new PropertyValueFactory<>("varos"));
        TableColumn cimmCol = new TableColumn("cim");
        cimmCol.setCellValueFactory(new PropertyValueFactory<>("cim"));
        TableColumn megalapitasCol = new TableColumn("megalapitas_eve");
        megalapitasCol.setCellValueFactory(new PropertyValueFactory<>("megalapitas_eve"));
        TableColumn hiv_emailCol = new TableColumn("email_cim_hivatalos");
        hiv_emailCol.setCellValueFactory(new PropertyValueFactory<>("email_cim_hivatalos"));
        tv3.getColumns().addAll(munkaltatoidCol, cegnevCol, telCol, varosmCol, cimmCol, megalapitasCol, hiv_emailCol);


        TableColumn felhasznaloidCol = new TableColumn("ID");
        felhasznaloidCol.setCellValueFactory(new PropertyValueFactory<>("ID"));
        TableColumn emailCol = new TableColumn("email_cim");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email_cim"));
        TableColumn jelszoCol = new TableColumn("jelszo");
        jelszoCol.setCellValueFactory(new PropertyValueFactory<>("jelszo"));
        TableColumn tipusCol = new TableColumn("tipus");
        tipusCol.setCellValueFactory(new PropertyValueFactory<>("tipus"));
        TableColumn actionCol = new TableColumn("action");
        actionCol.setCellFactory(param -> new TableCell<>() {
            private final Button deleteBtn = new Button("Delete");
//            private final Button editBtn = new Button("Edit");

            {
                deleteBtn.setOnAction(event -> {
                    Felhasznalo f = (Felhasznalo) getTableRow().getItem();
                    deleteFelhasznalo(f);
                    ActionEvent actionEvent = new ActionEvent();
                    listazzFelhasznalok(actionEvent);
                });

                HBox container = new HBox();
                container.getChildren().addAll(deleteBtn);
                container.setSpacing(10.0);
                setGraphic(container);
            }


        });
        tv4.getColumns().addAll(felhasznaloidCol, emailCol, jelszoCol, tipusCol, actionCol);

        TableColumn szakmaCol = new TableColumn("szakma");
        szakmaCol.setCellValueFactory(new PropertyValueFactory<>("szakma"));
        TableColumn felhasznalok_szamaCol = new TableColumn("felhasznalok_szama");
        felhasznalok_szamaCol.setCellValueFactory(new PropertyValueFactory<>("felhasznalok_szama"));
        tv5.getColumns().addAll(szakmaCol, felhasznalok_szamaCol);

        TableColumn korCol = new TableColumn("atlag_eletkor");
        korCol.setCellValueFactory(new PropertyValueFactory<>("atlag_eletkor"));
        TableColumn szakma2Col = new TableColumn("szakma");
        szakma2Col.setCellValueFactory(new PropertyValueFactory<>("szakma"));
        tv6.getColumns().addAll(korCol, szakma2Col);

        TableColumn berCol = new TableColumn("ber");
        berCol.setCellValueFactory(new PropertyValueFactory<>("ber"));
        TableColumn munkakor2Col = new TableColumn("munkakor");
        munkakor2Col.setCellValueFactory(new PropertyValueFactory<>("munkakor"));
        tv7.getColumns().addAll(berCol, munkakor2Col);
    }

    private void deleteFelhasznalo(Felhasznalo f) {
        db.deleteFelhasznalo(f);
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

    public void listazzAllaskeresok(ActionEvent actionEvent) {
        List<Allaskereso> allaskeresok = db.getAllaskeresoAll();
        tv2.getItems().clear();
        for (Allaskereso allaskereso : allaskeresok) {
            System.out.println(allaskereso.getTeljes_nev());
            tv2.getItems().add(allaskereso);
        }
    }

    public void listazzMunkaltatok(ActionEvent actionEvent) {
        List<Munkaltato> munkaltatok = db.getMunkaltatoAll();
        tv3.getItems().clear();
        for (Munkaltato munkaltato : munkaltatok) {
            System.out.println(munkaltato.getCegnev());
            tv3.getItems().add(munkaltato);
        }
    }

    public void listazzFelhasznalok(ActionEvent actionEvent) {
        List<Felhasznalo> felhasznalok = db.getFelhasznaloAll();
        tv4.getItems().clear();
        for (Felhasznalo felhasznalo : felhasznalok) {
            System.out.println(felhasznalo.getEmail_cim());
            tv4.getItems().add(felhasznalo);
        }
    }



    public void listazzstatszakma(ActionEvent event) {
        List<SzakmaStat> szakmak = db.getStatSzakmaFelhasznalo();
        tv5.getItems().clear();
        for (SzakmaStat szakma : szakmak) {
//            System.out.println(felhasznalo.getEmail_cim());
            tv5.getItems().add(szakma);
        }
    }

    public void listazzstatkor() {
        List<KorStat> eletkorok = db.getStatKorFelhasznalo();
        tv6.getItems().clear();
        for (KorStat eletkor : eletkorok) {
//            System.out.println(felhasznalo.getEmail_cim());
            tv6.getItems().add(eletkor);
        }
    }

    public void listazzminber(ActionEvent event) {
        List<BerStat> berek = db.getStatMinBer(berTF.getText());
        tv7.getItems().clear();
        for (BerStat ber : berek) {
            tv7.getItems().add(ber);
        }
    }

    public void listazzmaxber(ActionEvent event) {
        List<BerStat> berek = db.getStatMaxBer(berTF.getText());
        tv7.getItems().clear();
        for (BerStat ber : berek) {
            tv7.getItems().add(ber);
        }
    }
}
