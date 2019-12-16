package com.example.inmobiliaria.ui.checkin;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.model.Huesped;
import com.example.inmobiliaria.model.Inventario;
import com.example.inmobiliaria.model.Reserva;
import com.example.inmobiliaria.model.TipoElemento;
import com.example.inmobiliaria.model.Usuario;
import com.example.inmobiliaria.request.ApiClient;

import java.time.LocalDate;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckinViewModel extends ViewModel {

    MutableLiveData<List<Huesped>> huespedMutableLiveData;
    MutableLiveData<List<TipoElemento>> tipoElementoMutableLiveData;
    MutableLiveData<List<Reserva>> reservaMutableLiveData;
    MutableLiveData<Boolean> guardadoMutableLiveData;


    public LiveData<Boolean> getGuardadoMutableLiveData(){
        if(guardadoMutableLiveData==null){
            guardadoMutableLiveData=new MutableLiveData<>();
        }
        return guardadoMutableLiveData;
    }
    public LiveData<List<Huesped>> getHuespedMutableLiveData(){
        if(huespedMutableLiveData==null){

            huespedMutableLiveData=new MutableLiveData<>();
        }
        return huespedMutableLiveData;

    }


    public LiveData<List<TipoElemento>> getTipoElementoMutableLiveData(){
        if(tipoElementoMutableLiveData==null){

            tipoElementoMutableLiveData=new MutableLiveData<>();
        }
        return tipoElementoMutableLiveData;

    }

    public LiveData<List<Reserva>> getReservaMutableLiveData(){
        if(reservaMutableLiveData==null){

            reservaMutableLiveData=new MutableLiveData<>();
        }
        return reservaMutableLiveData;

    }

    public void obtenerTitulares(){
        String parametro="[{\"mail\":\""+"\" ,\"password\":\""+"\"}]";
        Call<List<Huesped>> dato= ApiClient.getMyApiClient().listarHuespedTitular(parametro);
        dato.enqueue(new Callback<List<Huesped>>() {
            @Override
            public void onResponse(Call<List<Huesped>> call, Response<List<Huesped>> response) {
                if(response.isSuccessful()){

                    huespedMutableLiveData.postValue(response.body());

                }
            }

            @Override
            public void onFailure(Call<List<Huesped>> call, Throwable t) {
                Log.d("salida huesped",t.getMessage());
            }
        });


    }

    public void obtenerListaDeElementos(){

        String parametro="[{\"mail\":\""+"\" ,\"password\":\""+"\"}]";
        Call<List<TipoElemento>> dato= ApiClient.getMyApiClient().listarTipoElemento(parametro);
        dato.enqueue(new Callback<List<TipoElemento>>() {
            @Override
            public void onResponse(Call<List<TipoElemento>> call, Response<List<TipoElemento>> response) {
                tipoElementoMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<TipoElemento>> call, Throwable t) {
                Log.d("salida tipoElemento",t.getMessage());
            }
        });
    }

    public void obtenerReservas(String  ingreso, int idTitular){

        String parametro="[{\"fingreso\":\""+ingreso+"\" ,\"idTitular\":"+idTitular+"}]";
        Log.d("Salida",parametro);
        Call<List<Reserva>> dato=ApiClient.getMyApiClient().listarReservasPorTitular(parametro);
        dato.enqueue(new Callback<List<Reserva>>() {
            @Override
            public void onResponse(Call<List<Reserva>> call, Response<List<Reserva>> response) {
                if(response.isSuccessful()){
                    reservaMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Reserva>> call, Throwable t) {

                Log.d("Salida Error",t.getMessage());
            }
        });
    }

    public void registrarInventario(List<Inventario> inventarios,Reserva reserva){

        for(Inventario it:inventarios) {
            String parametro = "[{\"idReserva\":" + reserva.getIdReserva() + ",\"idTipoElemento\":" + it.getIdTipoElemento() + ",\"cantidadCheckin\":" +it.getCantidadCheckin()+
                    ",\"cantidadCheckout\":"+0+"}]";
            Log.d("Salida", parametro);
            Call<String> dato = ApiClient.getMyApiClient().registrarInventario(parametro);
            dato.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    if (response.isSuccessful()) {

                    }
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                    Log.d("Salida Error", t.getMessage());
                }
            });

        }
        cambiarEstadoReserva(reserva);
    }

    public void cambiarEstadoReserva(Reserva reserva){
        String parametro="[{\"idReserva\":\""+reserva.getIdReserva()+"\" ,\"estado\":\"Ocupada\"}]";
        Call<String> dato=ApiClient.getMyApiClient().cambiarEstado(parametro);
        dato.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()) {
                    guardadoMutableLiveData.postValue(true);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

}
