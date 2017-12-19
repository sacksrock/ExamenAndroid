package com.utad.danieliglesia.examen.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.utad.danieliglesia.examen.FBObjects.FBNoticias;
import com.utad.danieliglesia.examen.R;

import java.util.ArrayList;

/**
 * Created by daniel.iglesia on 19/12/2017.
 */
//Creacción de la clase lista noticias adapter
public class ListaNoticiasAdapter extends RecyclerView.Adapter<NoticiasViewHolder> {
    //array de noticias
    private ArrayList<FBNoticias> noticias;
    private Context nContext;
    //constructor con parametros
    public ListaNoticiasAdapter(ArrayList<FBNoticias> noticias,Context nContext){
        this.noticias = noticias;
        this.nContext = nContext;
    }

    @Override
    //view holder de noticas donde se inicializa el view holder y se hace referencia a su xml
    public NoticiasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.celda_noticia_layout,null);
        NoticiasViewHolder noticiasViewHolder = new NoticiasViewHolder(view);
        return noticiasViewHolder;
    }

    @Override
    //se relaciona los txtviews del xml con los atributos  del objeto
    public void onBindViewHolder(NoticiasViewHolder holder, int position) {
        holder.tvtitulo.setText(noticias.get(position).titulo);
        holder.tvcuerpo.setText(noticias.get(position).cuerpo);

        Glide.with(nContext).load(noticias.get(position).imgurl).into(holder.imgnoticias);

    }

    @Override
    public int getItemCount() {
        return noticias.size();
    }
}

//se crea el view holder con los atributos de noticias
class NoticiasViewHolder extends RecyclerView.ViewHolder{
    public TextView tvtitulo;
    public TextView tvcuerpo;
    public ImageView imgnoticias;

    public NoticiasViewHolder(View itemView) {
        super(itemView);
        tvtitulo=itemView.findViewById(R.id.tvtitulo);
        tvcuerpo=itemView.findViewById(R.id.tvcuerpo);
        imgnoticias=itemView.findViewById(R.id.imgnoticias);
    }
}