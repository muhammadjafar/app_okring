package com.example.jafarabdi.project;

/**
 * Created by jafar abdi on 20/04/2017.
 */
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
public class RecyclerViewHolder extends RecyclerView.ViewHolder{
    TextView tv1,tv2;
    ImageView imageView;
    public RecyclerViewHolder(View itemView){
        super(itemView);
        tv1=(TextView) itemView.findViewById(R.id.daftar_judul);
        tv2=(TextView) itemView.findViewById(R.id.daftar_deskripsi);
        imageView=(ImageView) itemView.findViewById(R.id.daftar_icon);
    }
}
