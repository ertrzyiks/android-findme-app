package pl.schibsted.mateuszderks.findme

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

import pl.schibsted.mateuszderks.findme.resource.RoomApi
import retrofit.RestAdapter
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import android.view.View
import butterknife.bindView
import android.widget.TextView
import pl.schibsted.mateuszderks.findme.RoomsAdapter.ViewHolder
import java.util.concurrent.TimeUnit
import rx.schedulers.Timestamped
import android.text.format.DateFormat

public class RoomsAdapter : RecyclerView.Adapter<ViewHolder>() {
    val items: MutableList<Room> = arrayListOf();

    {
        val restAdapter = RestAdapter
                .Builder()
                .setEndpoint("https://agile-brushlands-2260.herokuapp.com/api/v1")
                .build()

        val roomApi = restAdapter.create<RoomApi>(javaClass<RoomApi>())

        println("CONNECTION");

        roomApi
                .list()
                .flatMap { Observable.from(it) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    items.add(0, it)
                    notifyItemInserted(0)
                }) {
                    println("Error ${it.getMessage()}")
                    it.printStackTrace()
                }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_room, viewGroup, false)

        return ViewHolder(itemView);
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val room = items.get(i);

        viewHolder.name.setText(room.name);
    }

    override fun getItemCount(): Int {
        return items.size();
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView by bindView(R.id.room_name);
    }
}
