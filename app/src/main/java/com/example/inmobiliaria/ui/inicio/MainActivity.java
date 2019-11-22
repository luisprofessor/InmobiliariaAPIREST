package com.example.inmobiliaria.ui.inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Contrato;
import com.example.inmobiliaria.model.Inquilino;
import com.example.inmobiliaria.model.Pago;
import com.example.inmobiliaria.model.Propiedad;
import com.example.inmobiliaria.model.Propietariox;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText name,pass;
    private TextView error;
    private String token;
    private MainViewModel mainViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
        error=findViewById(R.id.error);
        mainViewModel= ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getError().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer s) {

                error.setVisibility(s);
            }
        });
        mainViewModel.getToken().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Intent i=new Intent(getApplicationContext(),Principal.class);
                startActivity(i);
            }
        });


    }

    public void ingresar(android.view.View view){

           mainViewModel.ingresar(name.getText().toString(),pass.getText().toString());
        }
    }

