package com.example.ejemplo.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Arrays;
import java.util.List;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<List<String>> notificationsList;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Notificaciones");

        notificationsList = new MutableLiveData<>();
        loadExampleNotifications();
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<String>> getNotificationsList() {
        return notificationsList;
    }

    private void loadExampleNotifications() {
        // Example notifications
        List<String> exampleNotifications = Arrays.asList(
                "Error: Motor sobrecalentado",
                "Error: Baja presión de aceite",
                "Error: Sistema de frenos",
                "Error: Nivel bajo de combustible",
                "Error: Falla en el sistema de iluminación"
        );
        notificationsList.setValue(exampleNotifications);
    }
}
