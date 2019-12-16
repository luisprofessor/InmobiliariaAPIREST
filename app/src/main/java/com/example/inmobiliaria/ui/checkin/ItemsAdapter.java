package com.example.inmobiliaria.ui.checkin;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Contrato;
import com.example.inmobiliaria.model.Inventario;
import com.example.inmobiliaria.model.Reserva;
import com.example.inmobiliaria.model.TipoElemento;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemsAdapter extends ArrayAdapter<TipoElemento> {
    private Reserva reserva;

    private Context context;
    private List<TipoElemento> lista;
    private LayoutInflater inflador;
    private List<Inventario> inventarios;

    public ItemsAdapter(@NonNull Context context, int resource, @NonNull List<TipoElemento> objects, LayoutInflater inflador,Reserva reserva, List<Inventario> inventarios) {
            super(context, resource, objects);

            this.context=context;
            this.lista=objects;
            this.inflador=inflador;
            this.reserva=reserva;
            this.inventarios=inventarios;



            }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView=convertView;

        if(itemView==null){
            itemView=inflador.inflate(R.layout.items,parent,false);
        }
            TipoElemento tipoElemento=lista.get(position);


        Log.d("salida adapter",tipoElemento.getDescripcion());
            TextView idTipoElemento=itemView.findViewById(R.id.idTipoElemento);
            TextView descripcion=itemView.findViewById(R.id.descripcion);
            EditText cantidad=itemView.findViewById(R.id.cantidad);
            Button mas=itemView.findViewById(R.id.mas);


            idTipoElemento.setText(tipoElemento.getIdTipoElemento()+"");
            descripcion.setText(tipoElemento.getDescripcion());
            cantidad.setText("0");
            Inventario inventario=new Inventario();

             inventario.setIdTipoElemento(tipoElemento.getIdTipoElemento());

              inventarios.add(inventario);
            mas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Integer cant = Integer.parseInt(cantidad.getText().toString());
                    cant++;
                    cant = cant % 10;
                    cantidad.setText(cant + "");



                    inventarios.get(position).setIdReserva(reserva.getIdReserva());
                    inventarios.get(position).setCantidadCheckin(cant);


                }


            });


            return itemView;
    }
}