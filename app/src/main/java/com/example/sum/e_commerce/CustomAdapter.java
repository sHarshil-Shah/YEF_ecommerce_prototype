package com.example.sum.e_commerce;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<itemDetails> {

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    private static class ViewHolder {
        TextView name;
        TextView discription;
        TextView price;
        ImageView imageView;
    }


    public CustomAdapter(Context context, int resource, ArrayList<itemDetails> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the persons information
        String name = getItem(position).getName();
        String discription = getItem(position).getDiscription();
        int price = getItem(position).getPrice();
        int image = getItem(position).getImage();

        //Create the person object with the information
        itemDetails person = new itemDetails(name,discription,price,image);

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;


        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.name = convertView.findViewById(R.id.txtName);
            holder.discription =  convertView.findViewById(R.id.txtDescription);
            holder.price =  convertView.findViewById(R.id.txtItemPrice);
holder.imageView = convertView.findViewById(R.id.imgProduct);
            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext,   (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        result.startAnimation(animation);
        lastPosition = position;

        holder.name.setText(person.getName());
        holder.discription.setText(person.getDiscription());
        holder.price.setText("₹ "+person.getPrice());
        holder.imageView.setImageResource(image);

        return convertView;
    }
}
