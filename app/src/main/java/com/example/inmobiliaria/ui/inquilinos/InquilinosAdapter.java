package com.example.inmobiliaria.ui.inquilinos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.inmobiliaria.ui.inicio.MainActivity;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Contrato;
import com.example.inmobiliaria.model.Inquilino;

import java.util.List;

public class InquilinosAdapter extends ArrayAdapter<Inquilino> {
    private Context context;
    private List<Inquilino> list;
    private LayoutInflater inflador;

    public InquilinosAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino> objects, LayoutInflater inflador) {
        super(context, resource, objects);

        this.context=context;
        this.list=objects;
        this.inflador=inflador;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View item=convertView;

        if(item==null){
            item=inflador.inflate(R.layout.inquilinos,parent,false);
        }

        Inquilino inqui=list.get(position);

        TextView dni=item.findViewById(R.id.valorDni);
        dni.setText(inqui.getDni()+"");

        TextView apellido=item.findViewById(R.id.valorApellido);
        apellido.setText(inqui.getApellido());

        TextView nombre=item.findViewById(R.id.valorNombre);
        nombre.setText(inqui.getNombre());

        String direccion="";
        TextView dire=item.findViewById(R.id.valorDireccion);
       /* for (Contrato c: MainActivity.contratos) {
            if(c.getInquilino().getId()==inqui.getId()){
                direccion=c.getPropiedad().getDireccion();
            }
        };*/
        dire.setText(direccion);

        TextView tel=item.findViewById(R.id.valorTel);
        tel.setText(inqui.getTelefono()+"");

        return item;
    }
}
