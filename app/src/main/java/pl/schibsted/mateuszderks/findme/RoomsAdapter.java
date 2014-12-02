package pl.schibsted.mateuszderks.findme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.List;
import java.util.ArrayList;

public class RoomsAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<Room> items = new ArrayList<Room>();

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

        viewHolder.name.setText(room.name);
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
