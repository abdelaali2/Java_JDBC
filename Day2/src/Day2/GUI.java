package Day2;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUI extends Application {

    private int index = 0;
    private static List<ContactPerson> list = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        int index = 0;
        Text mainText = new Text("Contact View");
        Reflection ref = new Reflection();
        ref.setFraction(0.540f);
        mainText.setEffect(ref);
        mainText.setFont(Font.font("Arial", FontWeight.BOLD, 36));

        Label nameLabel = new Label("Name: ");
        Label emailLabel = new Label("E-Mail: ");
        Label cellPhoneLabel = new Label("Cell Phone: ");

        TextField nameField = new TextField();
        nameField.setEditable(false);

        TextField emailField = new TextField();
        emailField.setEditable(false);

        TextField cellPhoneField = new TextField();
        cellPhoneField.setEditable(false);

        Button firstButton = new Button("First Record");
        Button previousButton = new Button("Previous Record");
        Button nextButton = new Button("Next Record");
        Button lastButton = new Button("Last Record");

        GridPane gridPane0 = new GridPane();

        gridPane0.setMinSize(400, 200);
        gridPane0.setPadding(new Insets(10, 10, 10, 10));
        gridPane0.setVgap(5);
        gridPane0.setHgap(5);
        gridPane0.setAlignment(Pos.CENTER);

        gridPane0.add(mainText, 0, 0);

        GridPane gridPane1 = new GridPane();

        gridPane1.setMinSize(400, 200);
        gridPane1.setPadding(new Insets(10, 10, 10, 10));
        gridPane1.setVgap(5);
        gridPane1.setHgap(5);
        gridPane1.setAlignment(Pos.CENTER);

        gridPane1.add(nameLabel, 0, 0);
        gridPane1.add(nameField, 1, 0);
        gridPane1.add(emailLabel, 0, 1);
        gridPane1.add(emailField, 1, 1);
        gridPane1.add(cellPhoneLabel, 0, 2);
        gridPane1.add(cellPhoneField, 1, 2);

        GridPane gridPane2 = new GridPane();

        gridPane2.setMinSize(400, 200);
        gridPane2.setPadding(new Insets(10, 10, 10, 10));
        gridPane2.setVgap(5);
        gridPane2.setHgap(5);
        gridPane2.setAlignment(Pos.CENTER);

        gridPane2.add(firstButton, 0, 0);
        gridPane2.add(previousButton, 1, 0);
        gridPane2.add(nextButton, 2, 0);
        gridPane2.add(lastButton, 3, 0);

        firstButton.setOnAction((ActionEvent event) -> {
            this.index = 0;
            nameField.setText(this.list.get(this.index).getName());
            emailField.setText(this.list.get(this.index).getEmail());
            cellPhoneField.setText(this.list.get(this.index).getCellPhone());
        });

        previousButton.setOnAction((ActionEvent event) -> {
            if (this.index > 0) {
                this.index--;
            } else {
                this.index = 0;
            }
            nameField.setText(this.list.get(this.index).getName());
            emailField.setText(this.list.get(this.index).getEmail());
            cellPhoneField.setText(this.list.get(this.index).getCellPhone());
        });

        nextButton.setOnAction((ActionEvent event) -> {
            if (this.index < this.list.size()-1) {
                this.index++;
            } else if (this.index >= this.list.size()){
                this.index = this.list.size();
            }
            nameField.setText(this.list.get(this.index).getName());
            emailField.setText(this.list.get(this.index).getEmail());
            cellPhoneField.setText(this.list.get(this.index).getCellPhone());
        });

        lastButton.setOnAction((ActionEvent event) -> {
            this.index = this.list.size()-1;
            nameField.setText(this.list.get(this.index).getName());
            emailField.setText(this.list.get(this.index).getEmail());
            cellPhoneField.setText(this.list.get(this.index).getCellPhone());
        });

        BorderPane pane = new BorderPane();
        pane.setTop(gridPane0);
        pane.setCenter(gridPane1);
        pane.setBottom(gridPane2);

        Scene scene = new Scene(pane, 600, 600);

        primaryStage.setTitle("Database View");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void Begin(List<ContactPerson> queryList) {
        this.list = queryList;
        launch();
    }

}
