package es.codelines.mascotasmenufragments.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.codelines.mascotasmenufragments.R;
import es.codelines.mascotasmenufragments.adapter.MascotaAdaptador;
import es.codelines.mascotasmenufragments.pojo.Mascota;

/**
 * Created by abraham on 25/2/17.
 */

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascota;
    private RecyclerView rvListaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvListaMascotas = (RecyclerView) v.findViewById(R.id.rvListaMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }


    public MascotaAdaptador adaptador;

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascota ,getActivity());
        rvListaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascota = new ArrayList<>();

        mascota.add(new Mascota("Gato", R.drawable.gato, 3));
        mascota.add(new Mascota("Pajaro", R.drawable.pajaro, 2));
        mascota.add(new Mascota("Perro", R.drawable.perro, 3));
        mascota.add(new Mascota("Perro Asistencia", R.drawable.perroasistencia, 5));
        mascota.add(new Mascota("Perro y Gato", R.drawable.perrogato, 1));
        mascota.add(new Mascota("Pez", R.drawable.pez, 4));
        mascota.add(new Mascota("Reptil", R.drawable.reptil, 2));
        mascota.add(new Mascota("Pez Dorado", R.drawable.pez_oro, 7));

    }

}
