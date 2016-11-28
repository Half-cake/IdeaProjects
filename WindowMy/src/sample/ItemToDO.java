package sample;

import com.google.gson.Gson;

/**
 * Created by Панда on 28.11.2016.
 */
public class ItemToDO {
    Gson gson = new Gson();
    private String Title;

    public ItemToDO(String title) {
        this.Title = title;
        gson.toJson(title);
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
