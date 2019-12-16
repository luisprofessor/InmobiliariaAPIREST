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
import com.example.inmobiliaria.model.Usuario;
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
    private MutableLiveData<Usuario> usuarioMutableLiveData;

    public PerfilViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<Usuario> getPropietarioMutableLiveData(){
        if(usuarioMutableLiveData==null){
            usuarioMutableLiveData=new MutableLiveData<>();
        }
        return usuarioMutableLiveData;
    }

    public void leer(){
        SharedPreferences sp=context.getSharedPreferences("usuario",0);
        String apellido=sp.getString("apellido","");
        String nombre=sp.getString("nombre","");
        String mail=sp.getString("mail","");
        String password=sp.getString("password","");
        Usuario usuario=new Usuario();
        usuario.setApellido(apellido);
        usuario.setNombre(nombre);
        usuario.setMail(mail);
        usuario.setPassword(password);

        usuarioMutableLiveData.setValue(usuario);
    }
public void actualizar(Usuario usuario){
            SharedPreferences sp=context.getSharedPreferences("token",0);
            String accessToken=sp.getString("token","");

       /* Call<Propietario> proActualizado=ApiClient.getMyApiClient().actualizar(accessToken,propietario.getIdPropietario(),propietario.getNombre(),propietario.getApellido(),propietario.getDni(),propietario.getCorreo(),propietario.getClave(),propietario.getEstadoPropietario(),propietario.getTelefono());
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
*/
}


}
