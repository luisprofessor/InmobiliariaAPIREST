package com.example.inmobiliaria.ui.perfil;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
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
import com.example.inmobiliaria.model.Usuario;
import com.example.inmobiliaria.request.ApiClient;
import com.example.inmobiliaria.ui.inicio.MainActivity;
import com.example.inmobiliaria.ui.inicio.Principal;
import com.example.inmobiliaria.R;

public class PerfilFragment extends Fragment {
    EditText apellido, nombres,  mail, pass;
    Button aceptar,editar;
    private PerfilViewModel perfilViewModel;
    private Usuario propietarioVisto=null;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        ((Principal) getActivity()).setActionBarTitle("Perfil");




        apellido=root.findViewById(R.id.apellido);
        nombres=root.findViewById(R.id.nombres);
        mail=root.findViewById(R.id.mail);
        pass=root.findViewById(R.id.pass);

        aceptar=root.findViewById(R.id.aceptar);
        editar=root.findViewById(R.id.editar);

        perfilViewModel=ViewModelProviders.of(this).get(PerfilViewModel.class);
        perfilViewModel.getPropietarioMutableLiveData().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {

                propietarioVisto=usuario;

                fijarDatos(usuario);

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

        apellido.setEnabled(true);
        nombres.setEnabled(true);
        mail.setEnabled(true);
        pass.setEnabled(true);

        editar.setVisibility(View.GONE);
        aceptar.setVisibility(View.VISIBLE);

    }

    public void aceptar(){

       propietarioVisto.setApellido(apellido.getText().toString());
        propietarioVisto.setNombre(nombres.getText().toString());
       propietarioVisto.setMail(mail.getText().toString());
        propietarioVisto.setPassword(pass.getText().toString());
        perfilViewModel.actualizar(propietarioVisto);
    }

    public void fijarDatos(Usuario sesion){

        apellido.setText(String.valueOf(sesion.getApellido()));
        nombres.setText(String.valueOf(sesion.getNombre()));

        mail.setText(String.valueOf(sesion.getMail()));
        pass.setText(String.valueOf(sesion.getPassword()));
        Log.d("salida",pass.getText()+"");


        apellido.setEnabled(false);
        nombres.setEnabled(false);

        mail.setEnabled(false);
        pass.setEnabled(false);

        editar.setVisibility(View.VISIBLE);
        aceptar.setVisibility(View.GONE);

    }
}