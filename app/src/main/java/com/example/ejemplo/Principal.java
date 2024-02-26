package com.example.ejemplo;

import static com.example.ejemplo.R.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_principal);

        Button boton = findViewById(R.id.botonInicio);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la nueva actividad
                Intent intent = new Intent(Principal.this, Login.class);
                startActivity(intent);
            }
        });
        Button boton1 = findViewById(R.id.botonRegistro);
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Iniciar la nueva actividad
                Intent intent = new Intent(Principal.this, Registro.class);
                startActivity(intent);
            }
        });
    }
}