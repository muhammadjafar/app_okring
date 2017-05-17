package com.example.jafarabdi.project.adapter;

/**
 * Created by jafar abdi on 24/04/2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jafarabdi.project.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder>{
    private Context context;
    private int images[];
    private String names[];

    public MyAdapter(Context context, int[] images, String[] names) {
        this.context = context;
        this.images = images;
        this.names = names;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, null);
        MyHolder myHolder=new MyHolder(layout);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.img.setImageResource(images[position]);
        holder.txt.setText(names[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
    public static class MyHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txt;

        public MyHolder(View itemView) {
            super(itemView);
            img=(ImageView) itemView.findViewById(R.id.imageView);
            txt=(TextView) itemView.findViewById(R.id.textView2);
        }
    }
}
