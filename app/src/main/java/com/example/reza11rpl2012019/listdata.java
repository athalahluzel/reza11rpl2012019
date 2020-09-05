package com.example.reza11rpl2012019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

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
}