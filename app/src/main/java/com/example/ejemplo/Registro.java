package com.example.ejemplo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    private TextInputEditText nombreCompleto, correoElectronico, contrasena, confirmarContrasena;
    private MaterialButton btnRegistrar;
    private DatabaseReference databaseReference;
    private static final String TAG = "RegistroActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        // Inicializar vistas
        nombreCompleto = findViewById(R.id.nombreCompleto);
        correoElectronico = findViewById(R.id.correoElectronico);
        contrasena = findViewById(R.id.contrasena);
        confirmarContrasena = findViewById(R.id.confirmarContrasena);
        btnRegistrar = findViewById(R.id.btnRegistrar);

        // Inicializar referencia a Firebase Database
        databaseReference = FirebaseDatabase.getInstance().getReference("usuarios");

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = getTextFromInput(nombreCompleto);
                String correo = getTextFromInput(correoElectronico);
                String pass = getTextFromInput(contrasena);
                String confirmPass = getTextFromInput(confirmarContrasena);

                Log.d(TAG, "Datos ingresados - Nombre: " + nombre + ", Correo: " + correo + ", Contraseña: " + pass + ", Confirmar Contraseña: " + confirmPass);

                if (nombre.isEmpty() || correo.isEmpty() || pass.isEmpty() || confirmPass.isEmpty()) {
                    Toast.makeText(Registro.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(confirmPass)) {
                    Toast.makeText(Registro.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                } else if (pass.length() < 6) {
                    Toast.makeText(Registro.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                } else {
                    String userId = databaseReference.push().getKey();
                    Log.d(TAG, "Generated UserId: " + userId);
                    if (userId != null) {
                        Map<String, String> user = new HashMap<>();
                        user.put("nombre", nombre);
                        user.put("correo", correo);
                        user.put("contrasena", pass);

                        databaseReference.child(userId).setValue(user).addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "Usuario registrado correctamente en la base de datos");
                                Toast.makeText(Registro.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Registro.this, Menu2.class));
                                finish();
                            } else {
                                Log.e(TAG, "Error al registrar usuario en la base de datos", task.getException());
                                Toast.makeText(Registro.this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Log.e(TAG, "Error al generar el userId");
                        Toast.makeText(Registro.this, "Error al generar el userId", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private String getTextFromInput(TextInputEditText input) {
        return input != null && input.getText() != null ? input.getText().toString().trim() : "";
    }
}
