package com.example.jafarabdi.project.beranda;

/**
 * Created by jafar abdi on 27/05/2017.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class ParseJSON {
    public static String[] ids;
    public static String[] names;
    public static String[] alamat;
    public static String[] image;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_ALAMAT = "alamat";
    public static final String KEY_IMAGE = "image";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json){
        this.json = json;
    }

    protected void parseJSON(){
        JSONObject jsonObject=null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);
            ids = new String[users.length()];
            names = new String[users.length()];
            alamat = new String[users.length()];
            image = new String[users.length()];

            for(int i=0;i<users.length();i++){
                JSONObject jo = users.getJSONObject(i);
                ids[i] = jo.getString(KEY_ID);
                names[i] = jo.getString(KEY_NAME);
                alamat[i] = jo.getString(KEY_ALAMAT);
                image[i] = jo.getString(KEY_IMAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
