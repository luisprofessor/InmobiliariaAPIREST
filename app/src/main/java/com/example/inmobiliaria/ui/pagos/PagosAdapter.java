package com.example.inmobiliaria.ui.pagos;

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

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class PagosAdapter extends ArrayAdapter<Pago> {
    private Context context;
    private List<Pago> lista;
    private LayoutInflater inflador;

    public PagosAdapter(@NonNull Context context, int resource, @NonNull List<Pago> objects, LayoutInflater inflador) {
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
            itemView=inflador.inflate(R.layout.pagos,parent,false);
        }

        Pago pago=lista.get(position);

        TextView numero=itemView.findViewById(R.id.valorNro);
        numero.setText(pago.getNroPago()+"");

        String payed = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(pago.getFecha());

        TextView fecha=itemView.findViewById(R.id.valorFecha);
        fecha.setText(payed);

        TextView importe=itemView.findViewById(R.id.valorImporte);
        importe.setText("$"+pago.getImporte()+",-");

        return itemView;
    }
}
