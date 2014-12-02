package pl.schibsted.mateuszderks.findme;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class ViewHolder extends RecyclerView.ViewHolder {
    TextView name;

    public ViewHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.room_name);
    }
}

