package com.example.jafarabdi.project;

/**
 * Created by jafar abdi on 20/04/2017.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.jafarabdi.project.adapter.ImageCatering;
import com.example.jafarabdi.project.connect.CustomVolleyRequest;

import java.util.List;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.ViewHolder>{
    /*private ImageLoader imageLoader;
    private Context context;

    //List of superHeroes
    List<ImageCatering> catering;
    //private final Context context;
    /*String [] name=
            {"Apple","Facebook","Twitter","Google",
                    "Microsoft","Wikipedia","Yahoo","Youtube"};*/
    //LayoutInflater inflater;
    /*public RecylerAdapter(Context context){
        this.context=context;
        inflater=LayoutInflater.from(context);
    }*/

    /*public RecylerAdapter(ImageLoader imageLoader, Context context, List<ImageCatering> catering) {
        this.imageLoader = imageLoader;
        this.context = context;
        this.catering = catering;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        RecyclerViewHolder viewHolder=new RecyclerViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        ImageCatering imageCatering=catering.
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
    }*/
    private ImageLoader imageLoader;
    private Context context;

    //List of superHeroes
    List<ImageCatering> caterings;

    public RecylerAdapter(List<ImageCatering> caterings, Context context){
        super();
        //Getting all the superheroes
        this.caterings = caterings;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ImageCatering catering =  caterings.get(position);

        /*imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get("http://192.168.42.110/Android/upload/"+catering.getImageUrl(), ImageLoader.getImageListener(holder.imageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

        holder.imageView.setImageUrl("http://192.168.42.110/Android/upload/"+catering.getImageUrl(), imageLoader);*/
        holder.textViewName.setText(catering.getName());
        /*holder.textViewRank.setText(String.valueOf(superHero.getRank()));
        holder.textViewRealName.setText(superHero.getRealName());
        holder.textViewCreatedBy.setText(superHero.getCreatedBy());
        holder.textViewFirstAppearance.setText(superHero.getFirstAppearance());

        String powers = "";

        for(int i = 0; i<superHero.getPowers().size(); i++){
            powers+= superHero.getPowers().get(i);
        }

        holder.textViewPowers.setText(powers);*/
    }

    @Override
    public int getItemCount() {
        return caterings.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public NetworkImageView imageView;
        public TextView textViewName;
        /*public TextView textViewRank;
        public TextView textViewRealName;
        public TextView textViewCreatedBy;
        public TextView textViewFirstAppearance;
        public TextView  textViewPowers;*/

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (NetworkImageView) itemView.findViewById(R.id.daftar_icon);
            textViewName = (TextView) itemView.findViewById(R.id.daftar_deskripsi);
            /*textViewRank= (TextView) itemView.findViewById(R.id.textViewRank);
            textViewRealName= (TextView) itemView.findViewById(R.id.textViewRealName);
            textViewCreatedBy= (TextView) itemView.findViewById(R.id.textViewCreatedBy);
            textViewFirstAppearance= (TextView) itemView.findViewById(R.id.textViewFirstAppearance);
            textViewPowers= (TextView) itemView.findViewById(R.id.textViewPowers);*/
        }
    }

}
