package com.utad.danieliglesia.examen;
/**
 * Created by daniel.iglesia on 19/12/2017.
 */
public class DataHolder {
    public static DataHolder instance= new DataHolder();

    public FireBaseAdmin fireBaseAdmin;
    public DataHolder(){
        fireBaseAdmin = new FireBaseAdmin();
    }
}

