package com.example.ejemplo.ui.choferes;

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
import com.example.ejemplo.ui.choferes.ChoferesViewModel.Chofer;

import java.util.List;

public class ChoferesFragment extends Fragment {

    private ChoferesViewModel choferesViewModel;

    private EditText txtNacimientoChofer, txtNombreChofer, txtApellidoPChofer, txtApellidoMChofer, txtEstadoChofer, txtCiudadChofer, txtDireccionChofer, txtCPChofer, txtLicChofer;
    private Button btnAgregarChofer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_choferes, container, false);

        choferesViewModel = new ViewModelProvider(this).get(ChoferesViewModel.class);

        txtNacimientoChofer = root.findViewById(R.id.txtNacimientoChofer);
        txtNombreChofer = root.findViewById(R.id.txtNombreChofer);
        txtApellidoPChofer = root.findViewById(R.id.txtApellidoPChofer);
        txtApellidoMChofer = root.findViewById(R.id.txtApellidoMChofer);
        txtEstadoChofer = root.findViewById(R.id.txtEstadoChofer);
        txtCiudadChofer = root.findViewById(R.id.txtCiudadChofer);
        txtDireccionChofer = root.findViewById(R.id.txtDireccionChofer);
        txtCPChofer = root.findViewById(R.id.txtCPChofer);
        txtLicChofer = root.findViewById(R.id.txtLicChofer);
        btnAgregarChofer = root.findViewById(R.id.btnAgregarChofer);

        btnAgregarChofer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fechaNacimiento = txtNacimientoChofer.getText().toString().trim();
                String nombre = txtNombreChofer.getText().toString().trim();
                String apellidoP = txtApellidoPChofer.getText().toString().trim();
                String apellidoM = txtApellidoMChofer.getText().toString().trim();
                String estado = txtEstadoChofer.getText().toString().trim();
                String ciudad = txtCiudadChofer.getText().toString().trim();
                String calle = txtDireccionChofer.getText().toString().trim();
                String codigoPostal = txtCPChofer.getText().toString().trim();
                String numeroLicencia = txtLicChofer.getText().toString().trim();

                if (fechaNacimiento.isEmpty() || nombre.isEmpty() || apellidoP.isEmpty() || apellidoM.isEmpty() || estado.isEmpty() || ciudad.isEmpty() || calle.isEmpty() || codigoPostal.isEmpty() || numeroLicencia.isEmpty()) {
                    Toast.makeText(getActivity(), "Por favor completa todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                Chofer chofer = new Chofer(fechaNacimiento, nombre, apellidoP, apellidoM, estado, ciudad, calle, codigoPostal, numeroLicencia);
                choferesViewModel.addChofer(chofer);
                Toast.makeText(getActivity(), "Chofer agregado exitosamente", Toast.LENGTH_SHORT).show();
            }
        });

        choferesViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                // Actualiza UI si es necesario
            }
        });

        choferesViewModel.getChoferesList().observe(getViewLifecycleOwner(), new Observer<List<Chofer>>() {
            @Override
            public void onChanged(List<Chofer> choferes) {
                // Actualiza UI con la lista de choferes
            }
        });

        return root;
    }
}
