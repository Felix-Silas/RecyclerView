package com.example.jsonrv;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.bumptech.glide.Glide.with;


public class HelperAdapter extends RecyclerView.Adapter<HelperAdapter.MyViewClass> {

    ArrayList<RowObject> arrayList;
    Context context;

    public HelperAdapter(ArrayList<RowObject> arrayList, Context context){
        this.arrayList= arrayList;
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
        if(position<9) {
            holder.title.setText(arrayList.get(position).getTitle());
            holder.description.setText(arrayList.get(position).getDescription());
            holder.number.setText(String.valueOf("0"+ (position + 1)));
            Glide.with(context).load(arrayList.get(position).getImage()).into(holder.image);
        } else{
            holder.title.setText(arrayList.get(position).getTitle());
            holder.description.setText(arrayList.get(position).getDescription());
            holder.number.setText(String.valueOf(position + 1));
            Glide.with(context).load(arrayList.get(position).getImage()).into(holder.image);
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewClass extends RecyclerView.ViewHolder{

        TextView title;
        TextView description;
        TextView number;
        ImageView image;
        

        public MyViewClass(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            number = itemView.findViewById(R.id.number);
            image = itemView.findViewById(R.id.imageView);
        }
    }

}
