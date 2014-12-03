package pl.schibsted.mateuszderks.findme.resource


import pl.schibsted.mateuszderks.findme.Room
import retrofit.http.POST
import rx.Observable

public trait UserApi {
    POST("/users")
    public fun signup(): Observable<List<Room>>
}