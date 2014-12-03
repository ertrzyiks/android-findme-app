package pl.schibsted.mateuszderks.findme

import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.support.v7.widget.LinearLayoutManager
import butterknife.bindView
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.view.View
import android.content.Intent
import pl.schibsted.mateuszderks.findme.resource.RoomApi
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat

public class LoginActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        val button:Button = findViewById(R.id.button) as Button;


        button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View): Unit {
                switchToMain();
            }
        });
    }

    fun switchToMain(): Unit {
        val myIntent: Intent = Intent(this, javaClass<MainActivity>());
        startActivity(myIntent);
    }
}
