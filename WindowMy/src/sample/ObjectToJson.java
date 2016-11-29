package sample;

import com.google.gson.Gson;

import java.util.Objects;

/**
 * Created by Aleksey Zhulanov on 29.11.2016.
 */
public class ObjectToJson {
    public static String objectJson(Objects o){
        Gson gson = new Gson();
        String json = gson.toJson(o);
        System.out.print(json);
        return json;
    }
}
