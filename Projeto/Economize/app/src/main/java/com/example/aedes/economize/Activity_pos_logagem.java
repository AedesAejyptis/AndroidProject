package com.example.aedes.economize;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.aedes.economize.Frags_Formularios.FragNovaCategoria;
import com.example.aedes.economize.Frags_Formularios.FragNovaTransacao;
import com.example.aedes.economize.Frags_Formularios.FragNovoOrcamento;
import com.example.aedes.economize.Frags_Graficos.FragGrafico_first;
import com.example.aedes.economize.Frags_Listas_Historicos.FragListaOrcamentos;
import com.example.aedes.economize.Frags_Listas_Historicos.FragHistoricoTransacoes;
import com.example.aedes.economize.Frags_Listas_Historicos.FragListaCategorias;

public class Activity_pos_logagem extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String usuarioAtual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity_pos_logagem);
        usuarioAtual = getIntent().getStringExtra("usuarioAtual");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.acivity_pos_logagem, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fm = getFragmentManager();
       if (id == R.id.nav_addtrans) {
           fm.beginTransaction().replace(R.id.content_frame, new FragNovaTransacao()).commit();
        } else if (id == R.id.nav_addcat) {
           fm.beginTransaction().replace(R.id.content_frame, new FragNovaCategoria()).commit();
        }else if (id == R.id.nav_orc) {
           fm.beginTransaction().replace(R.id.content_frame, new FragNovoOrcamento()).commit();
       }else if (id == R.id.nav_listaCat) {
           fm.beginTransaction().replace(R.id.content_frame, new FragListaCategorias()).commit();
       }else if (id == R.id.nav_listaTrans) {
           fm.beginTransaction().replace(R.id.content_frame, new FragHistoricoTransacoes()).commit();
       }else if (id == R.id.nav_listaOrc) {
           fm.beginTransaction().replace(R.id.content_frame,new FragListaOrcamentos()).commit();
       }else if (id == R.id.nav_graph_first){
           fm.beginTransaction().replace(R.id.content_frame,new FragGrafico_first()).commit();
       }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public String getUsuarioAtual(){
        return usuarioAtual;
    }
}
