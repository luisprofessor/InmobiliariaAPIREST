package com.example.inmobiliaria.ui.pagos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.inmobiliaria.ui.inicio.MainActivity;
import com.example.inmobiliaria.ui.inicio.Principal;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Pago;

import java.util.ArrayList;

public class PagosFragment extends Fragment {
    private ArrayList<Pago> myList;
    private Spinner casas;
    private ListView list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_pagos, container, false);
        ((Principal) getActivity()).setActionBarTitle("Pagos");

        casas=root.findViewById(R.id.lugares);
        list=root.findViewById(R.id.miLista);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(getContext(),R.array.direcciones,android.R.layout.simple_spinner_item);
        casas.setAdapter(adapter);
        casas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cargarPagos(position+1);
                generarListView(list);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                casas.setSelection(0);
                cargarPagos(1);
                generarListView(list);
            }
        });

        return root;
    }

    public void cargarPagos(int casa){
        myList=new ArrayList<>();

       /* for (Pago p: MainActivity.pagos) {
            if(p.getContrato().getPropiedad().getId()==casa) {
                myList.add(p);
            }
        }*/
    }

    public void generarListView(ListView root){
        ArrayAdapter<Pago> adapter=new PagosAdapter(getContext(),R.layout.pagos,myList,getLayoutInflater());
        root.setAdapter(adapter);
    }
}