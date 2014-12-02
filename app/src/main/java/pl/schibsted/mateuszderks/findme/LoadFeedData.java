package pl.schibsted.mateuszderks.findme;

import android.os.AsyncTask;
import java.util.List;

import pl.schibsted.mateuszderks.findme.Resource.RoomApi;
import retrofit.RestAdapter;

public class LoadFeedData extends AsyncTask<Void, Void, List<Room>> {

    private final RoomsAdapter mAdapter;

    public LoadFeedData(RoomsAdapter adapter) {
        mAdapter = adapter;
    }


    @Override
    protected List<Room> doInBackground(Void... params) {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://agile-brushlands-2260.herokuapp.com/api/v1")
                .build();

        RoomApi roomApi = restAdapter.create(RoomApi.class);

        return roomApi.list();
    }

    @Override
    protected void onPostExecute(List<Room> rooms) {
        mAdapter.addAll(rooms);
    }
}