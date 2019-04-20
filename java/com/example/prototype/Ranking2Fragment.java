package com.example.prototype;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class Ranking2Fragment extends Fragment implements AdapterView.OnItemSelectedListener{
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_ranking,container,false);

        MainActivity activity = (MainActivity) getActivity();
        final String DataFromActivity = activity.getData();

        String[] menuItems = {
                "KBANK",
                "ADVANC",
                "TMB",
                "SCB",
                "TRUE",
                "CPP",
                "MAJOR",
                "PLANB",
                "WORK",
                "MBK"
        };
        final ListView listView = (ListView) view.findViewById(R.id.list_ranking);
        ArrayAdapter<String> listViewAdater = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                menuItems
        );
        listView.setAdapter(listViewAdater);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    fm.beginTransaction().replace(R.id.fragment_container,new CompareResultFragment()).addToBackStack(null).commit();
                    String text = listView.getItemAtPosition(position).toString();
                    Toast.makeText(getActivity(),text,Toast.LENGTH_SHORT).show();

            }
        });

        Spinner spinner = view.findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.stockranking,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
