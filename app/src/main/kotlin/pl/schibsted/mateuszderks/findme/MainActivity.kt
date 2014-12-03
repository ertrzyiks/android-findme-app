package pl.schibsted.mateuszderks.findme

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.support.v7.widget.LinearLayoutManager
import butterknife.bindView
import android.support.v7.widget.RecyclerView

public class MainActivity : ActionBarActivity() {

    val recyclerView: RecyclerView by bindView(R.id.roomlist)//butterknife example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = RoomsAdapter()
        recyclerView.setAdapter(adapter)

        val layoutManager = LinearLayoutManager(this)
        recyclerView.setLayoutManager(layoutManager)
    }
}
