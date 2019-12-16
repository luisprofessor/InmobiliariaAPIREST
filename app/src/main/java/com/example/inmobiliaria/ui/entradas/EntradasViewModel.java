package com.example.inmobiliaria.ui.entradas;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.model.Huesped;
import com.example.inmobiliaria.model.Reserva;
import com.example.inmobiliaria.request.ApiClient;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EntradasViewModel extends ViewModel {
public MutableLiveData<List<Reserva>> reservaMutableLiveData;


public LiveData<List<Reserva>> getReservaMutableLiveData(){

    if(reservaMutableLiveData==null){
        reservaMutableLiveData = new MutableLiveData<>();

    }
        return reservaMutableLiveData;

}


public void obtenerReservas(){
    String formatoDeFecha = "yyyy-MM-dd"; //In which you need put here
    SimpleDateFormat sdf = new SimpleDateFormat(formatoDeFecha, Locale.US);
    Calendar calendario=Calendar.getInstance();
    String fecha=sdf.format(calendario.getTime());


        String parametro="[{\"fingreso\":\""+fecha+"\"}]";
        Log.d("Salida",parametro);
        Call<List<Reserva>> dato= ApiClient.getMyApiClient().listarReservasPorFecha(parametro);
        dato.enqueue(new Callback<List<Reserva>>() {
            @Override
            public void onResponse(Call<List<Reserva>> call, Response<List<Reserva>> response) {
                if(response.isSuccessful()){
                   ArrayList<Reserva> reservas=(ArrayList<Reserva>)response.body();
                   // Log.d("Salida Obtuvo Reserva",response.body().get(0).getIngreso());

                    String parametro="[{\"mail\":\""+"\" ,\"password\":\""+"\"}]";
                    Call<List<Huesped>> dato= ApiClient.getMyApiClient().listarHuespedTitular(parametro);
                    dato.enqueue(new Callback<List<Huesped>>() {
                        @Override
                        public void onResponse(Call<List<Huesped>> call, Response<List<Huesped>> response) {
                            if(response.isSuccessful()){

                                Log.d("Salida Buscando Huesped",response.body().get(0).getApellido());
                                ArrayList<Huesped> huespeds=(ArrayList<Huesped>)response.body();
                                for(Reserva r:reservas){
                                    for(Huesped h:huespeds){
                                        if(r.getIdTitular()==h.getIdHuesped()){
                                            r.setTitular(h);
                                        }
                                    }
                                }
                                reservaMutableLiveData.postValue(reservas);



                            }
                        }

                        @Override
                        public void onFailure(Call<List<Huesped>> call, Throwable t) {
                            Log.d("salida huesped",t.getMessage());
                        }
                    });


                }
            }

            @Override
            public void onFailure(Call<List<Reserva>> call, Throwable t) {

                Log.d("Salida Error",t.getMessage());
            }
        });





}

}
