package com.example.jafarabdi.project.akun;

/**
 * Created by jafar abdi on 17/05/2017.
 */
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.jafarabdi.project.R;

public class TabProfil1 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_profil_penjual1, container, false);
        return rootView;
    }

}
