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

}
