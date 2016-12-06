package sample;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javafx.collections.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.*;

/**
 * Created by Aleksey Zhulanov on 30.11.2016.
 */

public class Controller implements Initializable {
    @FXML
    private Button addItem;

    @FXML
    private TextField stringForAdding;

    @FXML
    public ListView myToDo = new ListView<>();


    @FXML
    private RadioButton setStatusRadioButton;

    @FXML
    private ContextMenu menu;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            fullListView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    };


     public void fullListView() throws Exception {
         ArrayList<ItemToDO> incomingList = new ArrayList<ItemToDO>(readFromFile.readItemsFromFile());
         ObservableList<String> data = FXCollections.observableArrayList();
         for (ItemToDO o: incomingList) {
             data.add(o.getTitle());
         }
         myToDo.getItems().addAll(data);
     }

     public void addItem(ActionEvent event) throws Exception {

         String title = stringForAdding.getText();
        String status = setStatusRadioButton.isSelected() ? "Important":"Without";
        Date time = new Date();
        long timeStamp = time.getTime();

        ItemToDO oneItem = new ItemToDO(title, status, timeStamp);

         //Добавляем в Обсерв лист
         myToDo.getItems().add(oneItem.getTitle());
        //Добавляем Объект в файл
        writeToFile.writeToFile(oneItem);
        //Чистим Форму
        stringForAdding.clear();
    }

    public void deleteItemFromList(){
        MenuItem deleteItem = new MenuItem("Delete");
        int getItem = myToDo.getFocusModel().getFocusedIndex();
        System.out.print(getItem);
        myToDo.getItems().remove(getItem);
    }
}
