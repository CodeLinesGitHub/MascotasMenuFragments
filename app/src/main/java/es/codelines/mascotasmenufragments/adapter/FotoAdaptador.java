package es.codelines.mascotasmenufragments.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import es.codelines.mascotasmenufragments.R;
import es.codelines.mascotasmenufragments.pojo.Foto;

/**
 * Created by abraham on 26/2/17.
 */

public class FotoAdaptador extends RecyclerView.Adapter<FotoAdaptador.FotoViewHolder> {

    ArrayList<Foto> fotos;
    Activity activity;

    public FotoAdaptador(ArrayList<Foto> fotos, Activity activity) {
        this.fotos = fotos;
        this.activity = activity;
    }

    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil,parent,false);
        return new FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotoViewHolder fotoViewHolder, int position) {
        final Foto foto = fotos.get(position);
        fotoViewHolder.imgvPerfil.setImageResource(foto.getFoto());
        fotoViewHolder.tvPerfil.setText(foto.getRaiting());
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgvPerfil;
        private TextView tvPerfil;

        public FotoViewHolder(View itemView) {
            super(itemView);
            imgvPerfil = (ImageView) itemView.findViewById(R.id.imgvPerfil);
            tvPerfil = (TextView) itemView.findViewById(R.id.tvPerfil);
        }
    }
}
