package com.example.jafarabdi.project.beranda;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.jafarabdi.project.R;
import com.example.jafarabdi.project.connect.Constants;
import com.example.jafarabdi.project.connect.CustomVolleyRequest;

/**
 * Created by jafar abdi on 27/05/2017.
 */

public class CustomDetail extends ArrayAdapter<String>{
    private String[] ids;
    private String[] names;
    private String[] alamat;
    private String[] image;
    private Activity context;

    public CustomDetail(Activity context, String[] ids, String[] names, String[] alamat,String[] image) {
        super(context, R.layout.detail_beranda, ids);
        this.context = context;
        this.ids = ids;
        this.names = names;
        this.alamat = alamat;
        this.image = image;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.detail_beranda, null, true);
        TextView textViewId = (TextView) listViewItem.findViewById(R.id.id);
        TextView textViewNama = (TextView) listViewItem.findViewById(R.id.nama);
        TextView textViewAlamat = (TextView) listViewItem.findViewById(R.id.alamat);
        NetworkImageView imageView = (NetworkImageView) listViewItem.findViewById(R.id.foto);
        textViewId.setText(ids[position]);
        textViewNama.setText(names[position]);
        textViewAlamat.setText(alamat[position]);
        ImageLoader imageLoader = CustomVolleyRequest.getInstance(context).getImageLoader();
        imageLoader.get(Constants.PATH_IMAGE+image[position], ImageLoader.getImageListener(imageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

        imageView.setImageUrl(Constants.PATH_IMAGE+image[position], imageLoader);

        return listViewItem;
    }
}
