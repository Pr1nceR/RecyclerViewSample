package com.example.recyclerviewpractice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ZodiacRecyclerViewAdapter extends RecyclerView.Adapter<ZodiacRecyclerViewAdapter.MyViewHolder> {

    private  final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<ZodiacSignModel>zodiacSignModels;

    public ZodiacRecyclerViewAdapter(Context context, ArrayList<ZodiacSignModel>zodiacSignModels,
                                     RecyclerViewInterface recyclerViewInterface){

        this.context = context;
        this.zodiacSignModels = zodiacSignModels;
        this.recyclerViewInterface = recyclerViewInterface;

    }
    @NonNull
    @Override
    public ZodiacRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row,parent,false);

        return new ZodiacRecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);

    }
    @Override
    public void onBindViewHolder(@NonNull ZodiacRecyclerViewAdapter.MyViewHolder holder, int position) {
                holder.tv.setText(zodiacSignModels.get(position).getZodiacSignName());
                holder.imageView.setImageResource(zodiacSignModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return zodiacSignModels.size();
    }
    public static class MyViewHolder extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tv;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tv = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        if(recyclerViewInterface != null){
                            int pos = getAdapterPosition();
                            if(pos != RecyclerView.NO_POSITION){
                                recyclerViewInterface.onItemClick(pos);
                            }
                        }
                }
            });
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemLongClick(pos);
                        }
                    }
                    return true;
                }
            });
        }
    }
}
