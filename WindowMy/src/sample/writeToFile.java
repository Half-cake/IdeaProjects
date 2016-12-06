package sample;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Aleksey Zhulanov on 05.12.2016.
 */
public class writeToFile {
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
}
