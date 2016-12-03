package sample;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.collections.ObservableList;
import javafx.collections.ArrayChangeListener;
import javafx.collections.FXCollections;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

/**
 * Created by Aleksey Zhulanov on 30.11.2016.
 */
public class Controller implements Initializable {
    @FXML
    private Button addItem;

    @FXML
    private TextField stringForAdding;

    @FXML
    private ListView myToDo = new ListView<>();

    @FXML
    private RadioButton setStatusRadioButton;

    @FXML
    private ContextMenu cMenuDeleteItem;
    private MenuItem deleteItem = new MenuItem("Delete");

    @Override
    public void initialize(URL location, ResourceBundle resources) {};


     public void fullListView() throws Exception {
         ListView<Object> incomingList = new ListView<>();
         incomingList = ItemToDO.readFromFile();

     }

    public void setAddItem(ActionEvent event) throws Exception {
        ObservableList<String> data = FXCollections.observableArrayList();
        String title = stringForAdding.getText();
        String status = setStatusRadioButton.isSelected() ? "Important":"Without";
        Date time = new Date();
        long timeStamp = time.getTime();

        ItemToDO oneItem = new ItemToDO(title, status, timeStamp);
        //Добавляем в Обсерв лист
        data.add(oneItem.getTitle());
        //Добавляем из ОбсервЛиста в основной лист
        myToDo.getItems().addAll(data);

        //Добавляем в Файл объект
        ItemToDO.writeToFile(oneItem);
        //Чистим Форму
        stringForAdding.clear();
    }
    public void setOnMouseClicked(MouseEvent event){
        deleteItem.setOnAction(event1 -> {
            myToDo.getItems().remove(myToDo.getSelectionModel().getSelectedIndex());
            System.out.println(myToDo.getSelectionModel().getSelectedIndex());}

        );
    }
}
