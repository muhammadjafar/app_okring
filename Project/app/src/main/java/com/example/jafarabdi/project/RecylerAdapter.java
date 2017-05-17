package com.example.jafarabdi.project;

/**
 * Created by jafar abdi on 20/04/2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
public class RecylerAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{
    private final Context context;
    String [] name=
            {"Apple","Facebook","Twitter","Google",
                    "Microsoft","Wikipedia","Yahoo","Youtube"};
    LayoutInflater inflater;
    public RecylerAdapter(Context context){
        this.context=context;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=inflater.inflate(R.layout.item_list, parent, false);
        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.tv1.setText(name[position]);
        holder.tv1.setOnClickListener(clickListener);
        holder.imageView.setOnClickListener(clickListener);
        holder.tv1.setTag(holder);
        holder.imageView.setTag(holder);
    }
    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewHolder viewHolder=(RecyclerViewHolder) v.getTag();
            int position=viewHolder.getPosition();
            Toast.makeText(context, "Menu ini berada di posisi "+position,Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public int getItemCount() {
        return name.length;
    }
}
