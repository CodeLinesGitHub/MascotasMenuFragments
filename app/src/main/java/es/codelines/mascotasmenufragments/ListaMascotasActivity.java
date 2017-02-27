package es.codelines.mascotasmenufragments;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import es.codelines.mascotasmenufragments.activities_menu.AboutActivity;
import es.codelines.mascotasmenufragments.activities_menu.FormContactoActivity;
import es.codelines.mascotasmenufragments.adapter.MascotaAdaptador;
import es.codelines.mascotasmenufragments.adapter.PageAdapter;
import es.codelines.mascotasmenufragments.fragment.PerfilFragment;
import es.codelines.mascotasmenufragments.fragment.RecyclerViewFragment;
import es.codelines.mascotasmenufragments.pojo.Mascota;

public class ListaMascotasActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    /*ArrayList<Mascota> mascota;
    private RecyclerView rvListaMascotas;*/
    private ImageButton imgBtnStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mascotas);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgBtnStar = (ImageButton) findViewById(R.id.imgBtnStar);
        imgBtnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaMascotasActivity.this, MascotasFavoritasActivity.class);
                startActivity(intent);
            }
        });

        /*rvListaMascotas = (RecyclerView) findViewById(R.id.rvListaMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();*/
    }
    // Agregando los fragments a la lista
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager (){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_name);
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

    /*public MascotaAdaptador adaptador;

    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascota ,this);
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

    }*/

    public void clickFloatingActionButtonCamera(View view){
        Toast.makeText(this, "Hacer una foto", Toast.LENGTH_SHORT).show();
    }
}
