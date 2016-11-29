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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static void writeToFile(Object o){
        Gson gson = new Gson();
        try
        {
            FileWriter writer = new FileWriter("C:\\Users\\Aleksey Zhulanov\\IdeaProjects\\WindowMy\\src\\todo.json", true);
            String json = gson.toJson(o);
            writer.write(json+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
