package com.example.ejemplo.ui.adeudos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;

public class AdeudosViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<List<String>> adeudosList;

    public AdeudosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Adeudos");

        adeudosList = new MutableLiveData<>();
        loadExampleAdeudos();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<String>> getAdeudosList() {
        return adeudosList;
    }

    private void loadExampleAdeudos() {
        // Example adeudos
        List<String> exampleAdeudos = Arrays.asList(
                "Adeudo: Refrendo 2023",
                "Adeudo: Multa por exceso de velocidad",
                "Adeudo: Tenencia 2022",
                "Adeudo: Verificación vehicular",
                "Adeudo: Impuesto ambiental"
        );
        adeudosList.setValue(exampleAdeudos);
    }
}
