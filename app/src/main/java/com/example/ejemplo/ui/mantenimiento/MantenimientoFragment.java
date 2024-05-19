package com.example.ejemplo.ui.mantenimiento;

import android.graphics.Color;
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
import com.example.ejemplo.ui.mantenimiento.MantenimientoViewModel.MatriculaItem;

import java.util.List;

public class MantenimientoFragment extends Fragment {

    private MantenimientoViewModel mantenimientoViewModel;
    private TextView textView;
    private ListView listView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mantenimiento, container, false);

        textView = root.findViewById(R.id.text_mantenimiento);
        listView = root.findViewById(R.id.listview_mantenimiento);

        mantenimientoViewModel = new ViewModelProvider(this).get(MantenimientoViewModel.class);

        mantenimientoViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        mantenimientoViewModel.getMatriculasList().observe(getViewLifecycleOwner(), new Observer<List<MatriculaItem>>() {
            @Override
            public void onChanged(List<MatriculaItem> matriculas) {
                ArrayAdapter<MatriculaItem> adapter = new ArrayAdapter<MatriculaItem>(getContext(), android.R.layout.simple_list_item_2, android.R.id.text1, matriculas) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);
                        MatriculaItem item = getItem(position);
                        TextView text1 = view.findViewById(android.R.id.text1);
                        TextView text2 = view.findViewById(android.R.id.text2);

                        text1.setText(item.matricula);
                        text2.setText(item.descripcion);

                        switch (item.color) {
                            case "green":
                                view.setBackgroundColor(Color.GREEN);
                                break;
                            case "yellow":
                                view.setBackgroundColor(Color.YELLOW);
                                break;
                            case "red":
                                view.setBackgroundColor(Color.RED);
                                break;
                        }

                        return view;
                    }
                };
                listView.setAdapter(adapter);
            }
        });

        return root;
    }
}
