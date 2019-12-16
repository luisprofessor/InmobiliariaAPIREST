package com.example.inmobiliaria.request;

import android.util.Log;

import com.example.inmobiliaria.model.Huesped;
import com.example.inmobiliaria.model.Inventario;
import com.example.inmobiliaria.model.Reserva;
import com.example.inmobiliaria.model.TipoElemento;
import com.example.inmobiliaria.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class ApiClient {
    private static final String PATH="http://www.secsanluis.com.ar/servicios/varios/bungalows/model/";
    private static  MyApiInterface myApiInteface;
    private static String accessToken=null;


    public static MyApiInterface getMyApiClient(){


        Gson gson = new GsonBuilder().setLenient().create();
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .client(client.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        myApiInteface=retrofit.create(MyApiInterface.class);
        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInteface;
    }





    public interface MyApiInterface {

        @FormUrlEncoded
        @POST("ListenPostUsuario.php")
        Call<List<Usuario>> login(@Field("Usuariologuearapp") String paramLogi);

        @FormUrlEncoded
        @POST("ListenPostReservas.php")
        Call<List<Huesped>> listarHuespedTitular(@Field("Titularlistarapp") String paramLogi);

        @FormUrlEncoded
        @POST("ListenPostTipoElemento.php")
        Call<List<TipoElemento>> listarTipoElemento(@Field("TipoElementolistarapp") String paramLogi);

        @FormUrlEncoded
        @POST("ListenPostReservas.php")
        Call<List<Reserva>> listarReservasPorTitular(@Field("Reservasportitularapp") String paramLogi);

        @FormUrlEncoded
        @POST("ListenPostReservas.php")
        Call<String> registrarInventario(@Field("Inventarioregistrar") String paramLogi);

        @FormUrlEncoded
        @POST("ListenPostReservas.php")
        Call<String> cambiarEstado(@Field("Reservacambiarestado") String paramLogi);

        @FormUrlEncoded
        @POST("ListenPostReservas.php")
        Call<List<Inventario>> listarInventarioPorReserva(@Field("Inventariolistarinventarioporreserva") String paramLogi);

        @FormUrlEncoded
        @POST("ListenPostReservas.php")
        Call<List<Reserva>> listarReservasOcupadasPorTitular(@Field("Reservasocupadasportitularapp") String paramLogi);

        @FormUrlEncoded
        @POST("ListenPostReservas.php")
        Call<String> actualizarInventarioDeSalida(@Field("Inventarioactualizarsalida") String paramLogi);


        @FormUrlEncoded
        @POST("ListenPostReservas.php")
        Call<List<Reserva>> listarReservasPorFecha(@Field("Reservaslistarporfechaapp") String paramLogi);

        @FormUrlEncoded
        @POST("ListenPostReservas.php")
        Call<List<Huesped>> obtenerHuespedTitular(@Field("Titularobtenerhuespedapp") String paramLogi);


       // @GET("propietario")
        //Call<Propietario> leer(@Header("Authorization")String token);

       // @FormUrlEncoded
       // @PUT("propietario/{id}")
        //Call<Propietario> actualizar(@Header("Authorization")String token, @Path("id") int groupId, @Field("Nombre")String nombre,@Field("Apellido") String apellido,@Field("Dni") int dni,@Field("Correo")String correo,@Field("Clave")String clave,@Field("EstadoPropietario") int estado,@Field("Telefono")long telefono);
        // @GET("test")
        // Call<Data> leer();

        //listarClientes.php
        //@GET("listarClientes.php")
        //Call<List<Cliente>> getClientes();

        //@GET("insertarClientes.php")
        //Call<Cliente> createCliente(@Query("dni") int dni, @Query("apellido") String apellido, @Query("nombre") String nombre);
    }

}
