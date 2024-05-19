package com.example.ejemplo.ui.mantenimiento;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;

public class MantenimientoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<List<MatriculaItem>> matriculasList;

    public MantenimientoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Autos para mantenimiento");

        matriculasList = new MutableLiveData<>();
        loadExampleMantenimiento();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<MatriculaItem>> getMatriculasList() {
        return matriculasList;
    }

    private void loadExampleMantenimiento() {
        // Example matriculas with severity
        List<MatriculaItem> exampleMatriculas = Arrays.asList(
                new MatriculaItem("ABC123", "Chequeo básico", "green"),
                new MatriculaItem("DEF456", "Chequeo básico", "green"),
                new MatriculaItem("GHI789", "Chequeo básico", "green"),
                new MatriculaItem("JKL012", "Problema moderado", "yellow"),
                new MatriculaItem("MNO345", "Problema moderado", "yellow"),
                new MatriculaItem("PQR678", "Problema moderado", "yellow"),
                new MatriculaItem("STU901", "Problema grave", "red"),
                new MatriculaItem("VWX234", "Problema grave", "red"),
                new MatriculaItem("YZA567", "Problema grave", "red")
        );
        matriculasList.setValue(exampleMatriculas);
    }

    public static class MatriculaItem {
        public final String matricula;
        public final String descripcion;
        public final String color;

        public MatriculaItem(String matricula, String descripcion, String color) {
            this.matricula = matricula;
            this.descripcion = descripcion;
            this.color = color;
        }
    }
}
