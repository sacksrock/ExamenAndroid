package com.utad.danieliglesia.examen.FBObjects;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by daniel.iglesia on 19/12/2017.
 */

@IgnoreExtraProperties
//cracion del objeto noticias y atributos
public class FBNoticias {

    public String titulo;
    public String cuerpo;
    public String imgurl;

    public FBNoticias(){

    }

    public FBNoticias(String titulo, String cuerpo, String imgurl) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
        this.imgurl = imgurl;
    }
}
