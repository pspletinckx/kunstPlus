package com.rhcloud.github_pspletinckx.kunstplus;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pieter on 31/03/2015.
 */
public class LikesListAdaptor extends ArrayAdapter<String>{
    private final Activity context;
    private final String [] web;
    private final Integer[] imageId;

    public LikesListAdaptor(Activity context, String[] web, Integer[] imageId){
        super(context, R.layout.list_item_adv, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_item_likes, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView);
        txtTitle.setText(web[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }

}
