package pl.schibsted.mateuszderks.findme;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LoadFeedData extends AsyncTask<Void, Void, ArrayList<Room>> {

    private final String mUrl =
            "https://agile-brushlands-2260.herokuapp.com:443/api/v1/rooms?only_public=false";

    private final ArrayAdapter mAdapter;

    public LoadFeedData(ArrayAdapter adapter) {
        Log.v("DUPA", "Adapter");
        mAdapter = adapter;
    }

    private InputStream retrieveStream(String url) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = null;
        httpGet = new HttpGet(url);

        HttpResponse httpResponse = null;
        try {
            httpResponse = client.execute(httpGet);
            HttpEntity getResponseEntity = httpResponse.getEntity();
            return getResponseEntity.getContent();
        } catch (IOException e) {
            httpGet.abort();
        }
        return null;
    }

    @Override
    protected ArrayList<Room> doInBackground(Void... params) {
        Log.v("DUPA", "InBackground");

        InputStream source = retrieveStream(mUrl);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(source));
        } catch (Exception e) {
            return null;
        }

        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr = null;

        do{
            try {
                inputStr = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            responseStrBuilder.append(inputStr);
        }
        while (null != inputStr);

        JSONArray array;

        try {
            array = new JSONArray(responseStrBuilder.toString());
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        ArrayList<Room> result = Room.fromJson(array);
        Log.v("DUPA", result.toString());
        return result;
    }

    @Override
    protected void onPostExecute(ArrayList<Room> rooms) {
        Log.v("DUPA", rooms.toString());
        mAdapter.addAll(rooms);
    }
}