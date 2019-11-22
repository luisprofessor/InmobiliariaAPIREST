package com.example.inmobiliaria.ui.inquilinos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.inmobiliaria.ui.inicio.MainActivity;
import com.example.inmobiliaria.ui.inicio.Principal;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Inquilino;

import java.util.ArrayList;

public class InquilinosFragment extends Fragment {
    private ArrayList<Inquilino> myList=new ArrayList<>();
    private ListView list;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
;
        View root = inflater.inflate(R.layout.fragment_inquilinos, container, false);
        ((Principal) getActivity()).setActionBarTitle("Inquilinos");

        list=root.findViewById(R.id.inquis);

        cargarInquilinos();
        generarListView(list);

        return root;
    }

    public void cargarInquilinos(){

       /* for (Inquilino i: MainActivity.inquilinos) {
            myList.add(i);
        }*/
    }

    public void generarListView(ListView root){
        ArrayAdapter<Inquilino> adapter=new InquilinosAdapter(getContext(),R.layout.inquilinos,myList,getLayoutInflater());
        root.setAdapter(adapter);
    }
}