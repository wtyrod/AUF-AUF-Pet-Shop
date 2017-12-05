package com.example.rodrigo.navview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("AUF AUF");


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
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





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager;
        fragmentManager = getSupportFragmentManager();
        if (id == R.id.nav_home) {
            fragmentManager.beginTransaction().replace(R.id.content, new HomeFragment()).commit();
            getSupportActionBar().setTitle("AUF AUF");
        } else if (id == R.id.nav_conta) {
            fragmentManager.beginTransaction().replace(R.id.content, new ContaFragment()).commit();
            getSupportActionBar().setTitle("Minha Conta");
        } else if (id == R.id.nav_alimentacao) {
            fragmentManager.beginTransaction().replace(R.id.content, new AlimentacaoFragment()).commit();
            getSupportActionBar().setTitle("Alimentação");
        } else if (id == R.id.nav_adocao) {
            fragmentManager.beginTransaction().replace(R.id.content, new AdocaoFragment()).commit();
            getSupportActionBar().setTitle("Adoção");
        } else if (id == R.id.nav_acessorios) {
            fragmentManager.beginTransaction().replace(R.id.content, new AcessoriosFragment()).commit();
            getSupportActionBar().setTitle("Acessórios");
        } else if (id == R.id.nav_car) {
            fragmentManager.beginTransaction().replace(R.id.content, new CarrinhoFragment()).commit();
            getSupportActionBar().setTitle("Meu Carrinho");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}