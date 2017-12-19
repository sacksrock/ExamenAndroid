package com.utad.danieliglesia.examen;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by daniel.iglesia on 19/12/2017.
 */

public interface FireBaseAdminListener {
    //metodo del registerOk
    public void RegisterOk(Boolean ok);
    //metodo del loginOk
    public void LoginOk(Boolean ok);
    //metodo para descargar y observar la rama
    public void Rama(String rama,DataSnapshot dataSnapshot);
}
