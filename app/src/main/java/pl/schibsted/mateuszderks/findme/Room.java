package pl.schibsted.mateuszderks.findme;

import org.json.JSONException;
import org.json.JSONObject;

public class Room {
    String id;
    String name;

    public Room(JSONObject object){
        try {
            this.id = object.getString("id");
            this.name = object.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}