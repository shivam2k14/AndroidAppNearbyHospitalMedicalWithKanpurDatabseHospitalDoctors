package com.example.shivam84.androidnearbyhospotal;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.shivam84.androidnearbyhospotal.Model.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shivam84 on 4/2/2018.
 */
public class ListViewAdapter extends BaseAdapter {

    Activity activity;
    private List<Results> list_users1;


    LayoutInflater inflater;

    public ListViewAdapter(Activity activity, List<Results> list_users1) {
        this.activity = activity;
        this.list_users1 = list_users1;
    }

    @Override
    public int getCount() {
        return list_users1.size();
    }

    @Override
    public Object getItem(int position) {
        return list_users1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater=(LayoutInflater)activity.getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview= inflater.inflate(R.layout.activity_show_near_place,null);

        TextView textDrName=(TextView)itemview.findViewById(R.id.textViewDrName);
        TextView textDradd=(TextView)itemview.findViewById(R.id.textViewEmail);




        textDrName.setText(list_users1.get(position).getName());
        textDradd.setText(list_users1.get(position).getVicinity());

        return itemview;



    }


}
