package com.example.user.mydelicious3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlaceAdapter extends BaseAdapter{
    private Context mContext;
    private String nameList[];
    private String image[];
    LayoutInflater inflater;

    public PlaceAdapter(Context context, String[] nameList, String[] image) {
        mContext = context;
        this.nameList = nameList;
        this.image = image;
        inflater = (LayoutInflater.from(context));
    }
    @Override
    public int getCount() {
        return nameList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Context c = mContext;
        view = inflater.inflate(R.layout.list_view_place,null);
        TextView name = (TextView)view.findViewById(R.id.textView);
        ImageView icon = (ImageView)view.findViewById(R.id.icon);
        name.setText(nameList[position]);
        int id = c.getResources().getIdentifier("drawable/"+image[position], null, c.getPackageName());
        icon.setImageResource(id);
        return view;
    }
}
