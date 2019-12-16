package com.example.inmobiliaria.ui.entradas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Pago;
import com.example.inmobiliaria.model.Reserva;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class ReservasAdapter extends ArrayAdapter<Reserva> {
    private Context context;
    private List<Reserva> lista;
    private LayoutInflater inflador;

    public ReservasAdapter(@NonNull Context context, int resource, @NonNull List<Reserva> objects, LayoutInflater inflador) {
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
            itemView=inflador.inflate(R.layout.reservas,parent,false);
        }

        Reserva reserva=lista.get(position);

        TextView numero=itemView.findViewById(R.id.nroReserva);
        numero.setText(reserva.getIdReserva()+"");

        String ingreso = reserva.getIngreso();

        TextView fechaIngreso=itemView.findViewById(R.id.FechaIngreso);
        fechaIngreso.setText(ingreso);


        String salida = reserva.getEgreso();

        TextView fechaEgreso=itemView.findViewById(R.id.fechaSalida);
        fechaEgreso.setText(salida);

        TextView titular=itemView.findViewById(R.id.titular);
        titular.setText(reserva.getTitular().getApellido()+", "+reserva.getTitular().getNombre());
        //titular.setText(reserva.getIdTitular()+"");

        return itemView;
    }
}
