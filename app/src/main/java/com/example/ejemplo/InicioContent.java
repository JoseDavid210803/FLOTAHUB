package com.example.ejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class InicioContent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_content); // Asegúrate de que este sea el nombre correcto de tu layout

        Toolbar toolbar = findViewById(R.id.toolbar);
        ImageButton buttonDrawerToggle = findViewById(R.id.buttonDrawerToggle);

        buttonDrawerToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navegar a la vista del menú (Inicio)
                Intent intent = new Intent(InicioContent.this, Inicio.class);
                startActivity(intent);
            }
        });
    }
}
