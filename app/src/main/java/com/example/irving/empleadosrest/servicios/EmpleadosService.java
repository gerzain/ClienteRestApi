package com.example.irving.empleadosrest.servicios;

import com.example.irving.empleadosrest.modelos.EmepleadosResponse;
import com.example.irving.empleadosrest.modelos.Empleado;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Irving on 13/03/2017.
 */
public interface EmpleadosService
{

    @GET("getAll")
    Call<EmepleadosResponse>getEmpleados();

    @GET("get/{id}")
    Call<Empleado>getEmpleado(@Path("id")int id);
}
