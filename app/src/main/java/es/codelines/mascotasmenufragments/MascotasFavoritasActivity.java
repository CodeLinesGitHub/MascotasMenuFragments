package es.codelines.mascotasmenufragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import es.codelines.mascotasmenufragments.activities_menu.AboutActivity;
import es.codelines.mascotasmenufragments.activities_menu.FormContactoActivity;
import es.codelines.mascotasmenufragments.adapter.MascotaAdaptador;
import es.codelines.mascotasmenufragments.pojo.Mascota;

public class MascotasFavoritasActivity extends AppCompatActivity {

    private Toolbar toolbar;
    ArrayList<Mascota> mascota;
    private RecyclerView rvListaMascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvListaMascotasFavoritas = (RecyclerView) findViewById(R.id.rvListaMascotasFavoritas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaMascotasFavoritas.setLayoutManager(llm);

        inicializarListaMascotasFavoritas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menuContacto:
                //Toast.makeText(this, "Has pulsado la opción 1", Toast.LENGTH_SHORT).show();
                Intent intentForm = new Intent(this, FormContactoActivity.class);
                startActivity(intentForm);
                break;
            case R.id.menuAbout:
                //Toast.makeText(this, "Has pulsado la opción 2", Toast.LENGTH_SHORT).show();
                Intent intentAbout = new Intent(this, AboutActivity.class);
                startActivity(intentAbout);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public MascotaAdaptador adaptador;

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascota, this);
        rvListaMascotasFavoritas.setAdapter(adaptador);
    }

    public void inicializarListaMascotasFavoritas(){
        mascota = new ArrayList<>();

        mascota.add(new Mascota("Pajaro", R.drawable.pajaro, 2));
        mascota.add(new Mascota("Gato", R.drawable.gato, 3));
        mascota.add(new Mascota("Perro Asistencia", R.drawable.perroasistencia, 5));
        mascota.add(new Mascota("Perro", R.drawable.perro, 3));
        mascota.add(new Mascota("Perro y Gato", R.drawable.perrogato, 1));
    }
}
