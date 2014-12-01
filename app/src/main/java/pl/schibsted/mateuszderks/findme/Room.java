package pl.schibsted.mateuszderks.findme;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Room {
    String name;

    public Room(JSONObject object){
        try {
            this.name = object.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Room> fromJson(JSONArray jsonObjects) {
        ArrayList<Room> rooms = new ArrayList<Room>();
        for (int i = 0; i < jsonObjects.length(); i++) {
            try {
                rooms.add(new Room(jsonObjects.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return rooms;
    }
}