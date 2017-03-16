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
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdaptadorEmpleado adptador;
    private LinearLayoutManager linearLayout;
    private List<Empleado> empleados;
    private Date date;
    private Date dia_nacimiento;
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
        String url = "http://192.168.1.68/slim_app/public/usuarios/getAll";
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                try
                {

                    JSONObject result = new JSONObject(response);
                     //  Log.d(">>>",result.toString());
                    JSONArray conten=result.getJSONArray("result");
                    //Log.d("Respuesta",conten.toString());


                    for (int i = 0; i < conten.length(); i++)
                    {
                        JSONObject object=conten.getJSONObject(i);
                        int id=object.getInt("id");
                        String nombre= object.getString("Nombre");
                        String apellido=object.getString("Apellido");
                        String email=object.getString("Correo");
                        double sueldo=object.getDouble("Sueldo");
                        String fecha_nacimiento=object.getString("FechaNacimiento");
                        String fecha_registro=object.getString("FechaRegistro");
                        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        try
                        {
                                 date= dateFormat.parse(fecha_nacimiento);
                                 dia_nacimiento=dateFormat.parse(fecha_registro);
                        } catch (ParseException e)
                        {
                            e.printStackTrace();
                        }

                        Gson gson=new Gson();
                        Empleado emp=gson.fromJson(response,Empleado.class);
                        emp.setNombre(nombre);
                        emp.setApellido(apellido);
                        emp.setSueldo(sueldo);
                        emp.setFecha_registro(date);
                        emp.setFecha_nacimineto(dia_nacimiento);
                        emp.setEmail(email);
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
