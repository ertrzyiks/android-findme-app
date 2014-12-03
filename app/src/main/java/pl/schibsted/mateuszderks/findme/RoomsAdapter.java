package pl.schibsted.mateuszderks.findme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;
import java.util.ArrayList;

import pl.schibsted.mateuszderks.findme.resource.RoomApi;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RoomsAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<Room> items = new ArrayList<Room>();

    RoomsAdapter() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://agile-brushlands-2260.herokuapp.com/api/v1")
                .build();

        RoomApi roomApi = restAdapter.create(RoomApi.class);

        Callback<List<Room>> callback = new Callback<List<Room>>() {
            @Override
            public void success(List<Room> o, Response response) {
                addAll(o);
            }

            @Override
            public void failure(RetrofitError retrofitError) {

            }
        };

        roomApi.list(callback);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_room, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Room room = items.get(i);

        viewHolder.name.setText(room.name + " - " + room.id);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addAll(List<Room> list) {
        items.addAll(list);
        notifyDataSetChanged();
    }
}
