package com.utad.danieliglesia.examen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.milib.ListaFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;
import com.utad.danieliglesia.examen.Adapters.ListaNoticiasAdapter;
import com.utad.danieliglesia.examen.FBObjects.FBNoticias;

import java.util.ArrayList;

/**
 * Created by daniel.iglesia on 19/12/2017.
 */

public class Second extends AppCompatActivity {

    ListaFragment ListaFragmentNoticias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //inicializamos el events de la actividad 2
        SecondEvents events = new SecondEvents(this);
        DataHolder.instance.fireBaseAdmin.setListener(events);
        //asociamos el framento de noticas xml a una variable
        ListaFragmentNoticias = (ListaFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentListaNoticias);
        //descargamos la rama noticias y la observamos
        DataHolder.instance.fireBaseAdmin.Rama("Noticias");

        ArrayList<String> mdatos= new ArrayList<>();
    }
}
//MainActivityEvents implementa los listeners de firebase
class SecondEvents implements FireBaseAdminListener{

    Second secondActivity;

    public SecondEvents(Second secondActivity){
        this.secondActivity = secondActivity;
    }
    //este metodo comprueba la rama con Noticias y si es asi añadimos el adapter al recycler view
    @Override
    public void Rama(String rama, DataSnapshot dataSnapshot) {
        if (rama.equals("Noticias")){
            GenericTypeIndicator<ArrayList<FBNoticias>> indicator = new GenericTypeIndicator<ArrayList<FBNoticias>>(){};
            ArrayList<FBNoticias> noticias = dataSnapshot.getValue(indicator);
            ListaNoticiasAdapter listaNoticiasAdapter = new ListaNoticiasAdapter(noticias,secondActivity);
            secondActivity.ListaFragmentNoticias.recyclerView.setAdapter(listaNoticiasAdapter);
        }
    }
    @Override
    public void RegisterOk(Boolean ok) {

    }

    @Override
    public void LoginOk(Boolean ok) {

    }
}

