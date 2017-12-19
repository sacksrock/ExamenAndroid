package com.example.milib;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {

    public RecyclerView recyclerView;


    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  = inflater.inflate(R.layout.fragment_lista_mensajes, container, false);
        recyclerView = v.findViewById(R.id.listamensajes);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

       /* ArrayList<String> mdatos= new ArrayList<>();
        mdatos.add("MENSAJE 1");
        mdatos.add("MENSAJE 2");
        mdatos.add("MENSAJE 3");
        mdatos.add("MENSAJE 4");*/

       // ListaMensajesAdapter listaMensajesAdapter = new ListaMensajesAdapter(mdatos);
        // recyclerView.setAdapter(listaMensajesAdapter);



        return v;
    }

    public void setAdapter(RecyclerView.Adapter<RecyclerView.ViewHolder> adapter){

        recyclerView.setAdapter(adapter);

    }

}
