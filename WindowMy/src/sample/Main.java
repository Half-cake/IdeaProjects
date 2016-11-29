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
        ListView<String> myToDo = new ListView<String>();
        ObservableList<String> data = FXCollections.observableArrayList();


        myToDo.setPrefWidth(300);
        myToDo.setPrefHeight(100);

        TextField stringForAdding = new TextField();


        //Context menu for Elements
        ContextMenu menu = new ContextMenu();
        MenuItem delete = new MenuItem("Delete");
        menu.getItems().add(delete);

        //надо написать класс котрый читает из файла в лист

        //Actions
        addItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ItemToDO item = new ItemToDO(stringForAdding.getText());
                data.add(item.title);
                myToDo.setItems(data);
                item.writeToFile(item.title);

                //Gson gson = new Gson();
                //gson.toJson(item.getTitle());
            }
        });

        myToDo.setOnMouseClicked(event -> {
            //Вызываем контекстное меню для елемента.
            myToDo.setContextMenu(menu);
            //Для контекстного меню Delete, реализовано удажение.
            delete.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    data.remove(myToDo.getSelectionModel().getSelectedIndex());
                }
            });
        });


        //Set Grid
        GridPane grigForElements = new GridPane();
        grigForElements.setPrefSize(300, 300);
        grigForElements.addRow(0,myToDo);
        grigForElements.addRow(1, stringForAdding);
        grigForElements.addRow(2, addItem);
        Scene scene = new Scene(grigForElements);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
