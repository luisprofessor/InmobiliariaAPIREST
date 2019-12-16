package com.example.inmobiliaria.ui.checkout;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inmobiliaria.model.Huesped;
import com.example.inmobiliaria.model.Inventario;
import com.example.inmobiliaria.model.Reserva;
import com.example.inmobiliaria.model.TipoElemento;
import com.example.inmobiliaria.ui.inicio.Principal;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.model.Contrato;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CheckoutFragment extends Fragment {
    //private ArrayList<Inventario> myList=new ArrayList<>();
    private ArrayList<Inventario> inventarios;
    private Spinner huespedes;
    private Spinner spinnerReservas;
    private ListView list;
    private EditText entrada;
    private Calendar calendario;
    private Reserva reserva=new Reserva();
    private Button guardar;

    private CheckoutViewModel CheckoutViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_checkin, container, false);
        ((Principal) getActivity()).setActionBarTitle("Check-Out");

        CheckoutViewModel= ViewModelProviders.of(this).get(CheckoutViewModel.class);
        CheckoutViewModel.getHuespedMutableLiveData().observe(this, new Observer<List<Huesped>>() {
            @Override
            public void onChanged(List<Huesped> huespeds) {

                ArrayAdapter<Huesped>   comboAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, huespeds);
                huespedes.setAdapter(comboAdapter);

            }
        });

        CheckoutViewModel.getInventarioMutableLiveData().observe(this, new Observer<List<Inventario>>() {
            @Override
            public void onChanged(List<Inventario> tipoElementos) {
                inventarios=(ArrayList<Inventario>) tipoElementos;
                Log.d("salida elementos:",inventarios.get(0).getIdTipoElemento()+"");
                generarListView();
            }
        });
        CheckoutViewModel.getGuardadoMutableLiveData().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                guardar.setEnabled(false);
            }
        });
        configView(root);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CheckoutViewModel.registrarInventario(inventarios,reserva);
            }
        });


        CheckoutViewModel.getReservaMutableLiveData().observe(this, new Observer<List<Reserva>>() {
            @Override
            public void onChanged(List<Reserva> reservas) {
                ArrayAdapter<Reserva>   comboAdapter = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, reservas);
                spinnerReservas.setAdapter(comboAdapter);
                spinnerReservas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        // Toast.makeText(getContext(),((Huesped)huespedes.getSelectedItem()).getApellido(),Toast.LENGTH_LONG).show();


                        reserva.setIdReserva(((Reserva)spinnerReservas.getSelectedItem()).getIdReserva());
                        CheckoutViewModel.obtenerListaDeElementos();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        spinnerReservas.setSelection(0);

                    }
                });
            }
        });
        huespedes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getContext(),((Huesped)huespedes.getSelectedItem()).getApellido(),Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                huespedes.setSelection(0);

            }
        });


        return root;
    }

    public void cargarElementos(){
       // myList=new ArrayList<>();


    }

    public void generarListView(){

        ArrayAdapter<Inventario> adapter=new ItemsOutAdapter(getContext(),R.layout.items,inventarios,getLayoutInflater());
        list.setAdapter(adapter);
    }

    private void configView(View root){


        calendario = Calendar.getInstance();
        CheckoutViewModel.obtenerTitulares();
        huespedes=root.findViewById(R.id.titular);
        spinnerReservas=root.findViewById(R.id.reservas);
        list=root.findViewById(R.id.otraLista);
        entrada=root.findViewById(R.id.etEntrada);
        guardar=root.findViewById(R.id.guardar);


        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                calendario.set(Calendar.YEAR, year);
                calendario.set(Calendar.MONTH, monthOfYear);
                calendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                actualizarInput();





            }

        };
        entrada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getContext(), date, calendario
                        .get(Calendar.YEAR), calendario.get(Calendar.MONTH),
                        calendario.get(Calendar.DAY_OF_MONTH)).show();
            }
        });




    }

    private void actualizarInput() {
        String formatoDeFecha = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);

        entrada.setText(sdf.format(calendario.getTime()));
        int idTitular=((Huesped)huespedes.getSelectedItem()).getIdHuesped();
        CheckoutViewModel.obtenerReservas(sdf.format(calendario.getTime()),idTitular);
    }
}

