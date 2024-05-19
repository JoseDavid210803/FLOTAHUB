package com.example.ejemplo.ui.vehiculos;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class VehiculosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<List<Vehiculo>> vehiculosList;
    private DatabaseReference vehiculosRef;

    public VehiculosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is vehiculos fragment");

        vehiculosList = new MutableLiveData<>();
        vehiculosRef = FirebaseDatabase.getInstance().getReference().child("vehiculos");

        loadVehiculos();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Vehiculo>> getVehiculosList() {
        return vehiculosList;
    }

    private void loadVehiculos() {
        vehiculosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Vehiculo> vehiculos = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Vehiculo vehiculo = snapshot.getValue(Vehiculo.class);
                    vehiculos.add(vehiculo);
                }
                vehiculosList.setValue(vehiculos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle possible errors.
            }
        });
    }

    public void addVehiculo(Vehiculo vehiculo) {
        vehiculosRef.push().setValue(vehiculo);
    }

    // Clase Vehiculo
    public static class Vehiculo {
        public String vin;
        public String nombrePropietario;
        public String apellidoPaternoPropietario;
        public String apellidoMaternoPropietario;
        public String placa;
        public String tipo;
        public String color;
        public String marca;

        public Vehiculo() {
            // Constructor vacío necesario para Firebase
        }

        public Vehiculo(String vin, String nombrePropietario, String apellidoP, String apellidoM, String placa, String tipo, String color, String marca) {
            this.vin = vin;
            this.nombrePropietario = nombrePropietario;
            this.apellidoPaternoPropietario = apellidoP;
            this.apellidoMaternoPropietario = apellidoM;
            this.placa = placa;
            this.tipo = tipo;
            this.color = color;
            this.marca = marca;
        }
    }
}
