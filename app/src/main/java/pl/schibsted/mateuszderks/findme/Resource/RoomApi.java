package pl.schibsted.mateuszderks.findme.Resource;

import java.util.List;

import pl.schibsted.mateuszderks.findme.Room;
import retrofit.http.*;

public interface RoomApi {
    @GET("/rooms")
    List<Room> list();
}