package com.example.latihan2;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView table = new TableView<>();

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage)  {
        Scene scene = new Scene(new Group());

        stage.setTitle("Test TableView");
        stage.setWidth(350);
        stage.setHeight(550);

        final Label label = new Label("Daftar Mahasiswa");
        label.setFont(new Font("Arial",30));
        table.setEditable(true);

        TableColumn nameCol = new TableColumn("Nama");
        TableColumn nimCol = new TableColumn("NIM");
        TableColumn emailCol = new TableColumn("Email");

        table.getColumns().addAll(nameCol,nimCol,emailCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(20,10,10,10));
        vbox.getChildren().addAll(label,table);

        ((Group)scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();

        final ObservableList<Mahasiwa>data = FXCollections.observableArrayList(
                new Mahasiwa("Larynt","20221037031189","laryntsa@gmail.com"),
                new Mahasiwa("Ahya","202210370311187","ayaa@gmail.com")
        );

        nameCol.setCellValueFactory(new PropertyValueFactory<Mahasiwa,String>("name"));
        nimCol.setCellValueFactory(new PropertyValueFactory<Mahasiwa,String>("nim"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Mahasiwa,String>("email"));

        table.setItems(data);

        final TextField addName = new TextField();
        addName.setMaxWidth(nameCol.getPrefWidth());
        addName.setPromptText("Nama Mahasiswa");

        final TextField addNim = new TextField();
        addNim.setMaxWidth(nimCol.getPrefWidth());
        addNim.setPromptText("NIM");

        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");

        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                data.add(new Mahasiwa(
                        addName.getText(),
                        addNim.getText(),
                        addEmail.getText()
                ));
                addName.clear();
                addNim.clear();
                addEmail.clear();
            }
        });
        final HBox hboxInput = new HBox();
        hboxInput.getChildren().addAll(addName,addNim,addEmail,addButton);
        hboxInput.setSpacing(10);


        vbox.getChildren().addAll(hboxInput);
    }

    public static class Mahasiwa{
        private final SimpleStringProperty name;
        private final SimpleStringProperty nim;
        private final SimpleStringProperty email;

        public Mahasiwa(String name, String nim, String email) {
            this.name = new SimpleStringProperty (name);
            this.nim = new SimpleStringProperty(nim);
            this.email = new SimpleStringProperty(email);
        }

        public String getName() {
            return name.get();
        }

        public void setName(String fName) {
            name.set(fName);
        }

        public String getNim() {
            return nim.get();
        }

        public void setNim(String fNim) {
            nim.set(fNim);
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String fEmail) {
            email.set(fEmail);
        }
    }

}