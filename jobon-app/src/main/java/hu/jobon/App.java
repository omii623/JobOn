package hu.jobon;

import hu.jobon.database.Database;
import hu.jobon.database.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        stage.setScene(scene);
        stage.show();
        Database db = new Database();
        List<Munkaltato> AllMunkaltato = db.getMunkaltatoAll();
        for (Munkaltato m : AllMunkaltato) {
            System.out.println(m.getEmail_cim() + " - " + m.getJelszo() +
                    " - " +m.getID() + " - " + m.getCegnev() + " - " + m.getMegalapitas_eve());
        }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}