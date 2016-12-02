package sample;

import com.google.gson.Gson;
import javafx.scene.control.ListView;

import java.io.FileReader;
import java.util.Date;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;


/**
 * Created by Панда on 28.11.2016.
 */
public class ItemToDO {

    private String title;
    private String status;
    private long timeStamp;
    Date createData;


    public ItemToDO(String title){
        this.title = title;
    }

    public ItemToDO(String title, String status, long timeStamp) {
        this.title = title;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public void setTitle(String title) {
        this.title = title;
        }

    public String getTitle() {
        return title;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public static void writeToFile(Object o) throws IOException {
        Gson gson = new Gson();
        File file = new File("todo.json");
        if (!file.exists()) file.createNewFile();

        try
        {
            FileWriter writer = new FileWriter(file.getAbsolutePath(), true);
            String json = gson.toJson(o);
            writer.write(json+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ListView readFromFile()throws Exception {
        //Подключение gson
        Gson gson = new Gson();
        //Создаем лист для ипорта
        ListView<ItemToDO> itemsForImport = new ListView<ItemToDO>();
        //Находим файл с содержимым
        FileReader file = new FileReader("todo.json");
        //Сканер для содержимого
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String fromFile = sc.nextLine();
            ItemToDO itemToDO = gson.fromJson(fromFile, ItemToDO.class);
            itemsForImport.getItems().addAll(itemToDO);
        }

    return itemsForImport;
    }
}
