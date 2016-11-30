package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("My To-Do");
        primaryStage.setScene(new Scene(root, 300, 300));

        //controls: Лист + кнопка + текстовое поле
        Button addItem = new Button("Add Item");
        addItem.setDefaultButton(true);
        RadioButton setStatusRadioButton = new RadioButton("Important.");
        TextField stringForAdding = new TextField();

        //controls

        ListView<String> myToDo = new ListView<String>();
        ObservableList<String> data = FXCollections.observableArrayList();


        myToDo.setPrefWidth(300);
        myToDo.setPrefHeight(200);

        //Context menu for Elements
        ContextMenu menuForListElements = new ContextMenu();
        MenuItem delete = new MenuItem("Delete");
        menuForListElements.getItems().add(delete);

        //надо написать класс котрый читает из файла в лист

        //Actions for Button
        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Create an Object from TextField
                String title = stringForAdding.getText();
                String status = setStatusRadioButton.isSelected() ? "Important":"Without";
                ItemToDO oneItem = new ItemToDO(title, status);
                    data.add(oneItem.title);
                    myToDo.setItems(data);
                    ItemToDO.writeToFile(oneItem);
                    stringForAdding.clear();
                }
        });
        //End Actions
        //Actions for Menu
        myToDo.setOnMouseClicked(event -> {
            //Вызываем контекстное меню для елемента.
            myToDo.setContextMenu(menuForListElements);
            //Для контекстного меню Delete, реализовано удажение.
            delete.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    data.remove(myToDo.getSelectionModel().getSelectedIndex());
                }
            });
        });
        //End Action for Menu

        //Set Grid
        GridPane grigForElements = new GridPane();
        grigForElements.setPrefSize(300, 300);
        grigForElements.addRow(0,myToDo);
        grigForElements.addRow(1, stringForAdding);
        grigForElements.addRow(2, addItem, setStatusRadioButton);
        Scene scene = new Scene(grigForElements);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
