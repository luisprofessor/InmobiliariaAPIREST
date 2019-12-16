package com.example.inmobiliaria.ui.entradas;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria.model.Reserva;
import com.example.inmobiliaria.ui.inicio.Principal;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Pago;

import java.util.ArrayList;
import java.util.List;

public class EntradasFragment extends Fragment {
    private ArrayList<Reserva> myList;

    private ListView list;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_entradas, container, false);
        ((Principal) getActivity()).setActionBarTitle("Entradas");


        list=root.findViewById(R.id.miLista);
        EntradasViewModel ev= ViewModelProviders.of(this).get(EntradasViewModel.class);
        ev.getReservaMutableLiveData().observe(this, new Observer<List<Reserva>>() {
            @Override
            public void onChanged(List<Reserva> reservas) {
                myList=(ArrayList<Reserva>)reservas;
                generarListView(list);
            }
        });
        ev.obtenerReservas();


        return root;
    }


    public void generarListView(ListView root){
        ArrayAdapter<Reserva> adapter=new ReservasAdapter(getContext(),R.layout.reservas,myList,getLayoutInflater());
        root.setAdapter(adapter);
    }
}