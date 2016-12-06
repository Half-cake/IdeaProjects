package sample;

import com.google.gson.Gson;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Aleksey Zhulanov on 05.12.2016.
 */
public class readFromFile {

    public static ArrayList<ItemToDO> readItemsFromFile()throws Exception {
        //Подключение gson
        Gson gson = new Gson();
        //Создаем лист для ипорта
        ArrayList<ItemToDO> itemsFromFile = new ArrayList<>();
        //Находим файл с содержимым
        FileReader file = new FileReader("todo.json");
        //Сканер для содержимого
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String fromFile = sc.nextLine();
            ItemToDO itemToDO = gson.fromJson(fromFile, ItemToDO.class);
            itemsFromFile.add(itemToDO);
        }

        return itemsFromFile;
    }
}
