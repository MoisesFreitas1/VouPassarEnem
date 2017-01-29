package losfreitasapps.com.enem;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager FM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FM = getFragmentManager();
        if (getIntent().hasExtra("hum")) {
            FM.beginTransaction().replace(R.id.content_principal, new Humanas()).commit();
        }
        if (getIntent().hasExtra("nat")) {
            FM.beginTransaction().replace(R.id.content_principal, new Natureza()).commit();
        }
        if (getIntent().hasExtra("esp")) {
            FM.beginTransaction().replace(R.id.content_principal, new Espanhol()).commit();
        }
        if (getIntent().hasExtra("ing")) {
            FM.beginTransaction().replace(R.id.content_principal, new Ingles()).commit();
        }
        if (getIntent().hasExtra("mat")) {
            FM.beginTransaction().replace(R.id.content_principal, new Matematica()).commit();
        }
        if (getIntent().hasExtra("port")) {
            FM.beginTransaction().replace(R.id.content_principal, new Portugues()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
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

        if (id == R.id.nav_humanas) {
            FM.beginTransaction().replace(R.id.content_principal, new Humanas()).commit();
        } else if (id == R.id.nav_natureza) {
            FM.beginTransaction().replace(R.id.content_principal, new Natureza()).commit();
        } else if (id == R.id.nav_matematica) {
            FM.beginTransaction().replace(R.id.content_principal, new Matematica()).commit();
        } else if (id == R.id.nav_ingles) {
            FM.beginTransaction().replace(R.id.content_principal, new Ingles()).commit();
        } else if (id == R.id.nav_espanhol) {
            FM.beginTransaction().replace(R.id.content_principal, new Espanhol()).commit();
        } else if (id == R.id.nav_portugues) {
            FM.beginTransaction().replace(R.id.content_principal, new Portugues()).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
