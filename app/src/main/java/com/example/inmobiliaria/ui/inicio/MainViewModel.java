package com.example.inmobiliaria.ui.inicio;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.inmobiliaria.model.Propietario;
import com.example.inmobiliaria.request.ApiClient;

import java.util.MissingFormatArgumentException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends AndroidViewModel {
private MutableLiveData<Integer> error;
private MutableLiveData<String> token;

private Context context;

    public MainViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();

    }


    public LiveData<Integer> getError(){
    if(error==null){
        error=new MutableLiveData<>();
    }
    return error;
}

public MutableLiveData<String> getToken(){
    if(token==null){
        token=new MutableLiveData<>();
    }
    return token;
}

public void ingresar(String usuario,String clave){

    Call<String> dato= ApiClient.getMyApiClient().login(usuario,clave);

    dato.enqueue(new Callback<String>() {
        @Override
        public void onResponse(Call<String> call, Response<String> response) {


            if(response.isSuccessful()) {

                token.postValue(response.body());
                SharedPreferences sp=context.getSharedPreferences("token",0);
                SharedPreferences.Editor editor=sp.edit();
                String t="Bearer "+response.body();
                editor.putString("token",t);
                editor.commit();
                Log.d("salida ultimo token", t);




                //Gone Visibility
                    error.postValue(8);


            }else{
                //Visible Visibility
                error.postValue(1);
            }


        }

        @Override
        public void onFailure(Call<String> call, Throwable t) {

            error.postValue(0);
            Log.d("salida",t.getMessage());
        }
    });
}

}
