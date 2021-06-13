package com.fabricio_daniel.proyecto_final;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    FragmentContainerView fragmentContainerView;
    MaterialToolbar topAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentContainerView = findViewById(R.id.fragmentContainerView);
        topAppBar = findViewById(R.id.topAppBar);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, new ClientesFragment());

        fragmentTransaction.commit();

        topAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()){
                    case R.id.more:
                        fragmentTransaction.replace(R.id.fragmentContainerView, new ClientesFragment());
                        break;
                    case R.id.more2:
                        fragmentTransaction.replace(R.id.fragmentContainerView, new DirectoresFragment());
                        break;
                    case R.id.more3:
                        fragmentTransaction.replace(R.id.fragmentContainerView, new DistribuidoresFragment());
                        break;
                    case R.id.more4:
                        fragmentTransaction.replace(R.id.fragmentContainerView, new EmpleadosFragment());
                        break;
                    case R.id.more5:
                        fragmentTransaction.replace(R.id.fragmentContainerView, new PeliculasFragment());
                        break;
                    case R.id.more6:
                        fragmentTransaction.replace(R.id.fragmentContainerView, new PrestamosFragment());
                        break;
                    default:
                        return false;
                }
                fragmentTransaction.commit();
                return true;
            }
        });

    }

}