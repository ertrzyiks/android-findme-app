package pl.schibsted.mateuszderks.findme;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RoomsAdapter adapter = new RoomsAdapter();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.roomlist);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


        LoadFeedData loadFeedData = new LoadFeedData(adapter);
        loadFeedData.execute();
    }
}
