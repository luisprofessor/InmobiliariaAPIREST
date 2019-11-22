package com.example.inmobiliaria.ui.perfil;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.inmobiliaria.model.Propietario;
import com.example.inmobiliaria.request.ApiClient;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilViewModel extends AndroidViewModel {
    private Context context;
    private MutableLiveData<Propietario> propietarioMutableLiveData;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<Propietario> getPropietarioMutableLiveData(){
        if(propietarioMutableLiveData==null){
            propietarioMutableLiveData=new MutableLiveData<>();
        }
        return propietarioMutableLiveData;
    }

    public void leer(){
        SharedPreferences sp=context.getSharedPreferences("token",0);
        String accessToken=sp.getString("token","");
        Call<Propietario> propietarioCall= ApiClient.getMyApiClient().leer(accessToken);
        propietarioCall.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {

                if(response.isSuccessful()){
                    Propietario propietario=response.body();
                    propietarioMutableLiveData.postValue(propietario);

                }

            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {

                Toast.makeText(getApplication(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
public void actualizar(Propietario propietario){
            SharedPreferences sp=context.getSharedPreferences("token",0);
            String accessToken=sp.getString("token","");

        Call<Propietario> proActualizado=ApiClient.getMyApiClient().actualizar(accessToken,propietario.getIdPropietario(),propietario.getNombre(),propietario.getApellido(),propietario.getDni(),propietario.getCorreo(),propietario.getClave(),propietario.getEstadoPropietario(),propietario.getTelefono());
        proActualizado.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                Log.d("salida","por actualizar");
                if(response.isSuccessful()) {
                    Toast.makeText(getApplication(), "Propietario Actualizado", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {

            }
        });

}


}
