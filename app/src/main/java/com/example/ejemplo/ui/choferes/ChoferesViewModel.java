package com.example.ejemplo.ui.choferes;

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

public class ChoferesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<List<Chofer>> choferesList;
    private DatabaseReference choferesRef;

    public ChoferesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is choferes fragment");

        choferesList = new MutableLiveData<>();
        choferesRef = FirebaseDatabase.getInstance().getReference().child("choferes");

        loadChoferes();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<Chofer>> getChoferesList() {
        return choferesList;
    }

    private void loadChoferes() {
        choferesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Chofer> choferes = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Chofer chofer = snapshot.getValue(Chofer.class);
                    choferes.add(chofer);
                }
                choferesList.setValue(choferes);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle possible errors.
            }
        });
    }

    public void addChofer(Chofer chofer) {
        choferesRef.push().setValue(chofer);
    }

    // Clase Chofer
    public static class Chofer {
        public String fechaNacimiento;
        public String nombre;
        public String apellidoPaterno;
        public String apellidoMaterno;
        public String estado;
        public String ciudad;
        public String calle;
        public String codigoPostal;
        public String numeroLicencia;

        public Chofer() {
            // Constructor vacío necesario para Firebase
        }

        public Chofer(String fechaNacimiento, String nombre, String apellidoP, String apellidoM, String estado, String ciudad, String calle, String codigoPostal, String numeroLicencia) {
            this.fechaNacimiento = fechaNacimiento;
            this.nombre = nombre;
            this.apellidoPaterno = apellidoP;
            this.apellidoMaterno = apellidoM;
            this.estado = estado;
            this.ciudad = ciudad;
            this.calle = calle;
            this.codigoPostal = codigoPostal;
            this.numeroLicencia = numeroLicencia;
        }
    }
}
