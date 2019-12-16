package com.example.inmobiliaria.ui.checkout;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Inventario;
import com.example.inmobiliaria.model.Reserva;
import com.example.inmobiliaria.model.Inventario;

import java.util.List;

public class ItemsOutAdapter extends ArrayAdapter<Inventario> {
    private Reserva reserva;

    private Context context;
    private List<Inventario> lista;
    private LayoutInflater inflador;


    public ItemsOutAdapter(@NonNull Context context, int resource, @NonNull List<Inventario> objects, LayoutInflater inflador) {
            super(context, resource, objects);

            this.context=context;
            this.lista=objects;
            this.inflador=inflador;
            this.reserva=reserva;




            }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;

        if(itemView==null){
            itemView=inflador.inflate(R.layout.itemsout,parent,false);
        }
            Inventario inventario=lista.get(position);


        Log.d("salida adapter",inventario.getTipoElemento().getDescripcion());
            TextView idTipoElemento=itemView.findViewById(R.id.idTipoElementoOut);
            TextView descripcion=itemView.findViewById(R.id.descripcionOut);
            EditText cantidad=itemView.findViewById(R.id.cantidadOut);
            Button mas=itemView.findViewById(R.id.masOut);
            EditText salida=itemView.findViewById(R.id.cantidadSalidaOut);


            idTipoElemento.setText(inventario.getTipoElemento().getIdTipoElemento()+"");
            descripcion.setText(inventario.getTipoElemento().getDescripcion());
            cantidad.setText(inventario.getCantidadCheckin()+"");
            salida.setText(cantidad.getText());
            inventario.setGetCantidadCheckout(inventario.getCantidadCheckin());



            mas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Integer cant = Integer.parseInt(salida.getText().toString());
                    cant++;
                    cant = cant % 10;
                    salida.setText(cant + "");

                    lista.get(position).setGetCantidadCheckout(cant);


                }


            });


            return itemView;
    }
}