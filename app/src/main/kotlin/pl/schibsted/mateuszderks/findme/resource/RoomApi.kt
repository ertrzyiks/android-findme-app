package pl.schibsted.mateuszderks.findme.resource


import pl.schibsted.mateuszderks.findme.Room
import retrofit.http.GET
import rx.Observable

public trait RoomApi {
    GET("/rooms")
    public fun list(): Observable<List<Room>>
}