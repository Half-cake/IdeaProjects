package sample;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;


/**
 * Created by Панда on 28.11.2016.
 */
public class ItemToDO {

    String title;
    String status;
    String defaultStatus = "not set";

    public ItemToDO(String title){
        this.title = title;
        this.status = defaultStatus;

    }

    public ItemToDO(String title, String status) {
        this.title = title;
        this.status = status;
    }

    public void writeToFile(Object o){
        Gson gson = new Gson();
        String json = gson.toJson(o);
        try {
            FileWriter writer = new FileWriter("C:\\Users\\Панда\\Documents\\GitHub\\IdeaProjects\\WindowMy\\src\\todo.json");
            writer.append(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
