package com.example.aedes.economize.frags_historicos;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aedes.economize.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragListaGraficos extends Fragment {


    public FragListaGraficos() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_frag_lista_graficos, container, false);
    }

}