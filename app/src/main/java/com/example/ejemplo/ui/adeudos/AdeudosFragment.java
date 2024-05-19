package com.example.ejemplo.ui.adeudos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ejemplo.R;

import java.util.List;

public class AdeudosFragment extends Fragment {

    private AdeudosViewModel adeudosViewModel;
    private TextView textView;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_adeudos, container, false);

        textView = root.findViewById(R.id.text_adeudos);
        listView = root.findViewById(R.id.listview_adeudos);

        adeudosViewModel = new ViewModelProvider(this).get(AdeudosViewModel.class);

        adeudosViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        adeudosViewModel.getAdeudosList().observe(getViewLifecycleOwner(), new Observer<List<String>>() {
            @Override
            public void onChanged(List<String> adeudos) {
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, adeudos);
                listView.setAdapter(adapter);
            }
        });

        return root;
    }
}
