package com.example.shivam84.androidnearbyhospotal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shivam84.androidnearbyhospotal.Model.Results;
import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowNearPlace extends AppCompatActivity {

    private List<Results> list_users1=new ArrayList<>();
    private Results selectedDoctor;
   // private TextView input_Doctor_name,input_Dr_Vicn;
    private ListView list_data1;
    private ProgressBar circular_progress1;
    private TextView input_Doctor_name, input_Dr_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_near_place);

       list_data1=(ListView)findViewById(R.id.ListViewShow) ;

        input_Doctor_name=(TextView) findViewById(R.id.textViewDrName);
        input_Dr_email=(TextView) findViewById(R.id.textViewEmail);


        circular_progress1=(ProgressBar)findViewById(R.id.progress);

        ListViewAdapter adapter=new ListViewAdapter(ShowNearPlace.this,list_users1);
        list_data1.setAdapter(adapter);
        circular_progress1.setVisibility(View.INVISIBLE);
        list_data1.setVisibility(View.VISIBLE);

        Intent intent=this.getIntent();

        String name=intent.getExtras().getString("NAME_KEY");
        String email=intent.getExtras().getString("EMAIL_KEY");

        input_Doctor_name.setText(name);
        input_Dr_email.setText(email);







        //input_Doctor_name=(TextView) findViewById(R.id.te);


    }

    }

