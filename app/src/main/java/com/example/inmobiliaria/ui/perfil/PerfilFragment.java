package com.example.inmobiliaria.ui.perfil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria.model.Propietario;
import com.example.inmobiliaria.request.ApiClient;
import com.example.inmobiliaria.ui.inicio.MainActivity;
import com.example.inmobiliaria.ui.inicio.Principal;
import com.example.inmobiliaria.R;

public class PerfilFragment extends Fragment {
    EditText dni, apellido, nombres, tel, mail, pass;
    Button aceptar,editar;
    private PerfilViewModel perfilViewModel;
    private Propietario propietarioVisto=null;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        ((Principal) getActivity()).setActionBarTitle("Perfil");



        dni=root.findViewById(R.id.dni);
        apellido=root.findViewById(R.id.apellido);
        nombres=root.findViewById(R.id.nombres);
        tel=root.findViewById(R.id.tel);
        mail=root.findViewById(R.id.mail);
        pass=root.findViewById(R.id.pass);

        aceptar=root.findViewById(R.id.aceptar);
        editar=root.findViewById(R.id.editar);

        perfilViewModel=ViewModelProviders.of(this).get(PerfilViewModel.class);
        perfilViewModel.getPropietarioMutableLiveData().observe(this, new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {

                propietarioVisto=propietario;

                fijarDatos(propietario);

            }
        });


            perfilViewModel.leer();

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editar();
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getContext()).setTitle("").setMessage("Desea guardar los datos?").setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        aceptar();

                    }
                }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        fijarDatos(null);
                    }
                }).show();
            }
        });

        return root;
    }

    public void editar(){
        dni.setEnabled(true);
        apellido.setEnabled(true);
        nombres.setEnabled(true);
        tel.setEnabled(true);
        mail.setEnabled(true);
        pass.setEnabled(true);

        editar.setVisibility(View.GONE);
        aceptar.setVisibility(View.VISIBLE);

    }

    public void aceptar(){
       propietarioVisto.setDni(Integer.parseInt(dni.getText().toString()));
       propietarioVisto.setApellido(apellido.getText().toString());
        propietarioVisto.setNombre(nombres.getText().toString());
        propietarioVisto.setTelefono(Integer.parseInt(tel.getText().toString()));
        propietarioVisto.setCorreo(mail.getText().toString());
        propietarioVisto.setClave(pass.getText().toString());
        perfilViewModel.actualizar(propietarioVisto);
    }

    public void fijarDatos(Propietario sesion){
        dni.setText(String.valueOf(sesion.getDni()));
        apellido.setText(String.valueOf(sesion.getApellido()));
        nombres.setText(String.valueOf(sesion.getNombre()));
        tel.setText(String.valueOf(sesion.getTelefono()));
        mail.setText(String.valueOf(sesion.getCorreo()));
        pass.setText(String.valueOf(sesion.getClave()));
        Log.d("salida",pass.getText()+"");

        dni.setEnabled(false);
        apellido.setEnabled(false);
        nombres.setEnabled(false);
        tel.setEnabled(false);
        mail.setEnabled(false);
        pass.setEnabled(false);

        editar.setVisibility(View.VISIBLE);
        aceptar.setVisibility(View.GONE);

    }
}