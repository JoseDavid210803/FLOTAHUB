package com.example.ejemplo;

import static java.lang.Thread.sleep;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.slider.RangeSlider;

public class Registro extends AppCompatActivity implements View.OnClickListener {

    private EditText name, email, pass, pass2;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btn = (Button) findViewById(R.id.idBtnRegistar);
        name = (EditText) findViewById(R.id.idTxtName);
        email = (EditText) findViewById(R.id.idTxtEmail);
        pass = (EditText) findViewById(R.id.idTxtPass);
        pass2 = (EditText) findViewById(R.id.idTxtPass2);

        btn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        String nameStr = name.getText().toString();
        String emailStr = email.getText().toString();
        String passStr = pass.getText().toString();
        String pass2Str = pass2.getText().toString();

        if(passStr.equals(pass2Str)){
            Toast.makeText(this, "¡Usuario "+nameStr+" registrado exitosamente!",
                    Toast.LENGTH_SHORT).show();

            Toast.makeText(this, "Te enviaremos un correo a "+emailStr, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }

    }
}