package com.example.irving.empleadosrest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.irving.empleadosrest.adaptadores.AdaptadorEmpleado;
import com.example.irving.empleadosrest.modelos.Empleado;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdaptadorEmpleado adptador;
    private LinearLayoutManager linearLayout;
    private List<Empleado> empleados;
    private String TAG=MainActivity.this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView_empleados);
        linearLayout=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayout);
        empleados=new ArrayList<>();
        ServicioWeb();

    }

    private void ServicioWeb()
    {
        final RequestQueue queue = Volley.newRequestQueue(getApplicationContext());//Creamos instancia de RequestQueue con el contexto como parametro
        String url = "http://192.168.1.68/slim_app/public//empleados/getAll";
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try
                {

                    JSONArray conten=new JSONArray(response);



                    for (int i = 0; i < conten.length(); i++)
                    {
                        JSONObject object=conten.getJSONObject(i);
                        int id=object.getInt("id");
                        String nombre= object.getString("Nombre");
                        String apellido=object.getString("Apellido");
                        String email=object.getString("Correo");
                        String sueldo=object.getString("Sueldo");
                        String fecha_nacimiento=object.getString("FechaNacimiento");
                        String fecha_registro=object.getString("FechaRegistro");
                        String profesion=object.getString("Nombre_profesion");
                        int genero=object.getInt("Sexo");

                        Empleado emp=new Empleado(apellido,email,
                                fecha_nacimiento,fecha_registro,id,nombre,profesion,genero,sueldo);
                        emp.setNombre(nombre);
                        emp.setApellido(apellido);
                        emp.setSueldo(sueldo);
                        emp.setFechaNacimiento(fecha_nacimiento);
                        emp.setFechaRegistro(fecha_registro);
                        emp.setCorreo(email);
                        adptador=new AdaptadorEmpleado(empleados);
                        recyclerView.setAdapter(adptador);
                        empleados.add(emp);
                    }




                } catch (JSONException e)
                {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e(TAG,"OnError"+error.toString());
            }
        });
        queue.add(request);
    }//Termina metodo






}
