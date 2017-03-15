package com.example.irving.empleadosrest.servicios;

import com.example.irving.empleadosrest.utilidades.Constantes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Irving on 13/03/2017.
 */
public class ClienteRetrofit
{


    private static Retrofit retrofit = null;

    public static Retrofit getClient()
    {
        if (retrofit == null)
        {

            retrofit = new Retrofit.Builder()
                    .baseUrl(Constantes.URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


}
