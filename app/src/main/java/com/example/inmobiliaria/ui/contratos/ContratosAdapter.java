package com.example.inmobiliaria.ui.contratos;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Contrato;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ContratosAdapter extends ArrayAdapter<Contrato> {
    private Context context;
    private List<Contrato> lista;
    private LayoutInflater inflador;

    public ContratosAdapter(@NonNull Context context, int resource, @NonNull List<Contrato> objects, LayoutInflater inflador) {
            super(context, resource, objects);

            this.context=context;
            this.lista=objects;
            this.inflador=inflador;

            }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;
        if(itemView==null){
            itemView=inflador.inflate(R.layout.contratos,parent,false);
        }
            Contrato contrato=lista.get(position);

            String inicio = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(contrato.getFechaInicio());

            TextView numero=itemView.findViewById(R.id.fechaInicio);
            numero.setText(inicio);

            String fin;
            if(contrato.getFechaFin()!=null){
                 fin = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(contrato.getFechaFin());
            } else {
                 fin=null;
            }

            TextView fecha=itemView.findViewById(R.id.fechaFin);
            fecha.setText(fin);

            TextView importe=itemView.findViewById(R.id.valorPapu);
            importe.setText("$"+contrato.getPrecio()+",-");

            TextView valorEn=itemView.findViewById(R.id.valorEn);
            if(contrato.getFechaFin()==null){
                valorEn.setText("Vigente");
            } else {
                valorEn.setText("Caducado");
            }


            return itemView;
    }
}