package com.example.ejemplo;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Inicio extends AppCompatActivity {
    DrawerLayout drawerLayout;
    ImageButton buttonDrawerToggle;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        drawerLayout = findViewById(R.id.drawerLayout);
        buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);
        navigationView = findViewById(R.id.navigationView);

        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });

        View headerview = navigationView.getHeaderView(0);
        ImageView useImage = headerview.findViewById(R.id.userImage);
        TextView textUsername = headerview.findViewById(R.id.textUsername);

        useImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Inicio.this, textUsername.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int itemId = menuItem.getItemId();

                if (itemId == R.id.navInicio) {
                    Toast.makeText(Inicio.this, "Inicio", Toast.LENGTH_SHORT).show();
                }

                if (itemId == R.id.navAlerts) {
                    Toast.makeText(Inicio.this, "Notificaciones", Toast.LENGTH_SHORT).show();
                }

                if (itemId == R.id.navSeguro) {
                    Toast.makeText(Inicio.this, "Seguros", Toast.LENGTH_SHORT).show();
                }

                if (itemId == R.id.navMante) {
                    Toast.makeText(Inicio.this, "Mantenimiento", Toast.LENGTH_SHORT).show();
                }

                if (itemId == R.id.navAdeudos) {
                    Toast.makeText(Inicio.this, "Adeudos", Toast.LENGTH_SHORT).show();
                }

                if (itemId == R.id.navVehiculos) {
                    Toast.makeText(Inicio.this, "Vehiculos", Toast.LENGTH_SHORT).show();
                }

                if (itemId == R.id.navChoferes) {
                    Toast.makeText(Inicio.this, "Choferes", Toast.LENGTH_SHORT).show();
                }

                if (itemId == R.id.navSalir) {
                    Toast.makeText(Inicio.this, "Salir", Toast.LENGTH_SHORT).show();
                }

                drawerLayout.close();
                return false;
            }
        });
    }
}
