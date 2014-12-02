package pl.schibsted.mateuszderks.findme.Resource;

import java.util.List;

import retrofit.Callback;

import pl.schibsted.mateuszderks.findme.Room;
import retrofit.http.*;

public interface RoomApi {
    @GET("/rooms")
    void list(Callback<List<Room>> callback);
}