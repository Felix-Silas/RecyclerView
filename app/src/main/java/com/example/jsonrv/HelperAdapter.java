package com.example.jsonrv;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.bumptech.glide.Glide.with;


public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.MyViewClass> {

    ArrayList<String> title;
    ArrayList<String> description;
    ArrayList<String> image;
    Context context;

    public HelperAdapter(ArrayList<String> title, ArrayList<String> description,ArrayList<String> image, Context context){
        this.title = title;
        this.description = description;
        this.image = image;
        this.context = context;

    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        MyViewClass myViewClass = new MyViewClass(view);
        return myViewClass;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {
        holder.title.setText(title.get(position));
        holder.description.setText(description.get(position));
        holder.number.setText(String.valueOf(position+1));
        Glide.with(context).load(image.get(position)).into(holder.imageView);
        

    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    public class MyViewClass extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;
        TextView number;
        ImageView imageView;
        

        public MyViewClass(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            number = itemView.findViewById(R.id.number);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}
