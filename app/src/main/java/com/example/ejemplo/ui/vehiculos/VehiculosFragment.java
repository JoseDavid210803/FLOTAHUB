package com.example.ejemplo.ui.vehiculos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ejemplo.R;
import com.example.ejemplo.ui.vehiculos.VehiculosViewModel.Vehiculo;

import java.util.List;

public class VehiculosFragment extends Fragment {

    private VehiculosViewModel vehiculosViewModel;

    private EditText txtVINVehiculo, txtNombrePropietario, txtApellidoPPropietario, txtApellidoMPropietario, txtPlacaVehiculo, txtTipoVehiculo, txtColorVehiculo, txtMarcaVehiculo;
    private Button btnAgregarVehiculo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_vehiculos, container, false);

        vehiculosViewModel = new ViewModelProvider(this).get(VehiculosViewModel.class);

        txtVINVehiculo = root.findViewById(R.id.txtVINVehiculo);
        txtNombrePropietario = root.findViewById(R.id.txtNombrePropietario);
        txtApellidoPPropietario = root.findViewById(R.id.txtApellidoPPropietario);
        txtApellidoMPropietario = root.findViewById(R.id.txtApellidoMPropietario);
        txtPlacaVehiculo = root.findViewById(R.id.txtPlacaVehiculo);
        txtTipoVehiculo = root.findViewById(R.id.txtTipoVehiculo);
        txtColorVehiculo = root.findViewById(R.id.txtColorVehiculo);
        txtMarcaVehiculo = root.findViewById(R.id.txtMarcaVehiculo);
        btnAgregarVehiculo = root.findViewById(R.id.btnAgregarVehiculo);

        btnAgregarVehiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vin = txtVINVehiculo.getText().toString().trim();
                String nombrePropietario = txtNombrePropietario.getText().toString().trim();
                String apellidoP = txtApellidoPPropietario.getText().toString().trim();
                String apellidoM = txtApellidoMPropietario.getText().toString().trim();
                String placa = txtPlacaVehiculo.getText().toString().trim();
                String tipo = txtTipoVehiculo.getText().toString().trim();
                String color = txtColorVehiculo.getText().toString().trim();
                String marca = txtMarcaVehiculo.getText().toString().trim();

                if (vin.isEmpty() || nombrePropietario.isEmpty() || apellidoP.isEmpty() || apellidoM.isEmpty() || placa.isEmpty() || tipo.isEmpty() || color.isEmpty() || marca.isEmpty()) {
                    Toast.makeText(getActivity(), "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Vehiculo vehiculo = new Vehiculo(vin, nombrePropietario, apellidoP, apellidoM, placa, tipo, color, marca);
                vehiculosViewModel.addVehiculo(vehiculo);
                Toast.makeText(getActivity(), "Vehículo agregado exitosamente", Toast.LENGTH_SHORT).show();
            }
        });

        vehiculosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                // Actualiza UI si es necesario
            }
        });

        vehiculosViewModel.getVehiculosList().observe(getViewLifecycleOwner(), new Observer<List<Vehiculo>>() {
            @Override
            public void onChanged(List<Vehiculo> vehiculos) {
                // Actualiza UI con la lista de vehículos
            }
        });

        return root;
    }
}
