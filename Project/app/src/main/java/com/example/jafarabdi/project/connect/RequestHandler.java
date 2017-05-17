package com.example.jafarabdi.project.connect;

import android.app.DownloadManager;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by jafar abdi on 02/05/2017.
 */

public class RequestHandler {
    private static RequestHandler mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;

    private RequestHandler(Context context) {
        mCtx=context;
        mRequestQueue=getRequestQueue();
    }
    public static synchronized RequestHandler getInstance(Context context){
        if (mInstance==null){
            mInstance=new RequestHandler(context);
        }
        return mInstance;
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue==null){
            mRequestQueue= Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req){
        getRequestQueue().add(req);
    }
}
