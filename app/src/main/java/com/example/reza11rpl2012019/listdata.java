package com.example.reza11rpl2012019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class listdata extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DataAdapter adapter;
    private ArrayList<model> DataArrayList; //kit add kan ke adapter
    private ImageView tambah_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listdata);
        recyclerView = (RecyclerView) findViewById(R.id.rvdata);
        //addData();
        addDataonline();
    }

    void addData(){
        DataArrayList = new ArrayList<>();
        model data1 = new model();
        data1.setOriginal_title("Wrath of titans");
        data1.setPoster_path("https://upload.wikimedia.org/wikipedia/en/f/fe/Wrath_of_the_Titans.jpg");
        data1.setAdult(false);
        data1.setOverviw("Wrath of the Titans adalah sebuah film fantasi Amerika Serikat tahun 2012 yang merupakan sekuel dari film sebelumnya, Clash of the Titans (2010). Film ini disutradarai oleh Jonathan Liebesman dan dibintangi oleh Sam Worthington, Liam Neeson, Ralph Fiennes, dan Rosamund Pike.");
        data1.setVote_count(100);
        data1.setRelease_date("30 Maret 2012");
        DataArrayList.add(data1);


        adapter = new DataAdapter(DataArrayList, new DataAdapter.Callback() {
            @Override
            public void onClick(int position) {

            }

            @Override
            public void test() {

            }
        });
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(listdata.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);



    }

    void addDataonline(){
        AndroidNetworking.get("https://api.themoviedb.org/3/movie/now_playing?api_key=6ac7a042ac3b7599a689eb943fa0b6d0&language=en-US")
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("hasilJson","onResponse: " + response.toString());
                        DataArrayList = new ArrayList<>();
                        model modelku;
                        try {
                            Log.d("hasilJson","onResponse: " + response.toString());
                            JSONArray jsonArray = response.getJSONArray("results");
                            Log.d("hasilJson2","onResponse: " + jsonArray.toString());
                            for (int i = 0; i <jsonArray.length(); i++){
                                modelku = new model();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                modelku.setOriginal_title(jsonObject.getString("original_title"));
                                modelku.setRelease_date(jsonObject.getString("release_date"));
                                modelku.setOverviw(jsonObject.getString("overview"));
                                modelku.setPoster_path("https://image.tmdb.org/t/p/w500"+jsonObject.getString("poster_path"));
                                modelku.setAdult(jsonObject.getBoolean("adult"));
                                modelku.setVote_count(jsonObject.getInt("vote_count"));
                                DataArrayList.add(modelku);
                            }

                            adapter = new DataAdapter(DataArrayList, new DataAdapter.Callback() {
                                @Override
                                public void onClick(int position) {

                                }

                                @Override
                                public void test() {

                                }
                            });
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(listdata.this);
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        Log.d("errorku","onerror Errorcode : " + error.getErrorCode());
                        Log.d("errorku","onerror Errorbody : " + error.getErrorBody());
                        Log.d("errorku","onerror Errordetail : " + error.getErrorDetail());

                    }
                });

    }
}