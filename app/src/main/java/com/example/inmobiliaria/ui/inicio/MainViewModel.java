package com.example.inmobiliaria.ui.inicio;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria.model.Usuario;
import com.example.inmobiliaria.request.ApiClient;

import java.util.List;

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
   String parametro="[{\"mail\":\""+usuario+"\" ,\"password\":\""+clave+"\"}]";

    Call<List<Usuario>> dato= ApiClient.getMyApiClient().login(parametro);
    Log.d("salida mapa:",parametro);
    dato.enqueue(new Callback<List<Usuario>>() {
        @Override
        public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {


            if(response.isSuccessful()) {
                if(response.body().size()>0) {
                Usuario u=response.body().get(0);

                SharedPreferences sp=context.getSharedPreferences("usuario",0);
                SharedPreferences.Editor editor=sp.edit();

                editor.putString("apellido",u.getApellido());
                editor.putString("nombre",u.getNombre());
                editor.putString("mail",u.getMail());
                editor.putString("password",u.getPassword());

                editor.commit();

                    token.postValue(u.getApellido());
                    error.postValue(8);
                }else{
                    //Visible Visibility
                    error.postValue(1);
                }
               //Gone Visibility



            }else{
                //Visible Visibility
                error.postValue(1);
            }


        }

        @Override
        public void onFailure(Call<List<Usuario>> call, Throwable t) {

            error.postValue(0);
            Log.d("salida Error",t.getMessage());
            Log.d("salida Error",call.request().body().toString());
            t.printStackTrace();
        }
    });
}

}
