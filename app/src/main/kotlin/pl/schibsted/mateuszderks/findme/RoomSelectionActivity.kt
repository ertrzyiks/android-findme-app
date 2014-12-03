package pl.schibsted.mateuszderks.findme

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.support.v7.widget.LinearLayoutManager
import butterknife.bindView
import android.support.v7.widget.RecyclerView

public class RoomSelectionActivity : ActionBarActivity() {

    val recyclerView: RecyclerView by bindView(R.id.roomlist);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_selection);

        val adapter = RoomsAdapter();
        recyclerView.setAdapter(adapter);

        val layoutManager = LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }
}
