package com.example.sum.e_commerce;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String>{

    public CustomAdapter(@NonNull Context context, String[] items) {
        super(context,R.layout.custom_row ,items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row,parent,false);

        String txt = getItem(position);
        TextView text = customView.findViewById(R.id.txtName);
        ImageView image = customView.findViewById(R.id.imgProduct);

        text.setText(txt);
        image.setImageResource(R.mipmap.ic_launcher);

        return customView;
    }
}
