package com.example.inmobiliaria.ui.propiedades;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Propiedad;


public class ItemPropiedad extends Fragment {

    private Propiedad propiedad;

    private Switch disponible;
    private Button guardar;
    private EditText direccion,ambientes,precio;
    private Spinner tipo,uso;

    public ItemPropiedad(){}

    public ItemPropiedad(Propiedad p) {
        propiedad=p;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_item_propiedad, container, false);

        direccion=root.findViewById(R.id.direccion);
        ambientes=root.findViewById(R.id.ambientes);
        precio=root.findViewById(R.id.precio);
        tipo=root.findViewById(R.id.tipo);
        uso=root.findViewById(R.id.uso);
        disponible=root.findViewById(R.id.disponible);

        guardar=root.findViewById(R.id.guardar);

        if(propiedad!=null){
            fijarDatos(propiedad);
        }

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).setTitle("").setMessage("Desea cambiar la disponibilidad?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        aceptar(propiedad);
                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        disponible.setChecked(propiedad.isDisponible());
                    }
                }).show();
            }
        });

        return root;
    }

    public void fijarDatos(Propiedad elegida){
        direccion.setText(elegida.getDireccion());
        ambientes.setText(String.valueOf(elegida.getAmbientes()));
        precio.setText(String.valueOf(elegida.getPrecio()));

        ArrayAdapter<CharSequence> adapterTipo=ArrayAdapter.createFromResource(getContext(),R.array.tipos,android.R.layout.simple_spinner_item);
        tipo.setAdapter(adapterTipo);
        tipo.setSelection(adapterTipo.getPosition(elegida.getTipo()));
        tipo.setEnabled(false);

        ArrayAdapter<CharSequence> adapterUso=ArrayAdapter.createFromResource(getContext(),R.array.usos,android.R.layout.simple_spinner_item);
        uso.setAdapter(adapterUso);
        uso.setSelection(adapterUso.getPosition(elegida.getUso()));
        uso.setEnabled(false);

        disponible.setChecked(elegida.isDisponible());
    }

    public void aceptar(Propiedad p){
        p.setDisponible(disponible.isChecked());
    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
