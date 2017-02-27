package es.codelines.mascotasmenufragments.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import es.codelines.mascotasmenufragments.R;
import es.codelines.mascotasmenufragments.adapter.FotoAdaptador;
import es.codelines.mascotasmenufragments.pojo.Foto;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Foto> foto;
    private RecyclerView rvFotos;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvFotos = (RecyclerView) v.findViewById(R.id.rvFotos);

        GridLayoutManager glm = new GridLayoutManager(getContext(),3);
        rvFotos.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public FotoAdaptador adaptador;

    public void inicializarAdaptador(){
        adaptador = new FotoAdaptador(foto ,getActivity());
        rvFotos.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        foto = new ArrayList<>();

        foto.add(new Foto(R.drawable.gato, "3"));
        foto.add(new Foto(R.drawable.gato, "6"));
        foto.add(new Foto(R.drawable.gato, "2"));
        foto.add(new Foto(R.drawable.gato, "9"));
        foto.add(new Foto(R.drawable.gato, "8"));
        foto.add(new Foto(R.drawable.gato, "1"));
        foto.add(new Foto(R.drawable.gato, "0"));
        foto.add(new Foto(R.drawable.gato, "5"));
        foto.add(new Foto(R.drawable.gato, "3"));

    }

}
