package com.example.irving.empleadosrest.modelos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Irving on 13/03/2017.
 */
public class Empleado
{
    private  int id;
    private String nombre;
    private String apellido;
    private int Sexo;
    private double Sueldo;
    private String email;
    private Date Fecha_nacimineto;

    public Empleado(String apellido, Date fecha_nacimineto,
                    Date fecha_registro, int id, String nombre, int sexo, double sueldo ,String correo) {
        this.apellido = apellido;
        Fecha_nacimineto = fecha_nacimineto;
        Fecha_registro = fecha_registro;
        this.id = id;
        this.nombre = nombre;
        this.email=correo;
        Sexo = sexo;
        Sueldo = sueldo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Empleado()
    {

    }

    private Date Fecha_registro;


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nacimineto() {
        return Fecha_nacimineto;
    }

    public void setFecha_nacimineto(Date fecha_nacimineto) {
        Fecha_nacimineto = fecha_nacimineto;
    }

    public Date getFecha_registro() {
        return Fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        Fecha_registro = fecha_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSexo() {
        return Sexo;
    }

    public void setSexo(int sexo) {
        Sexo = sexo;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double sueldo) {
        Sueldo = sueldo;
    }
    public String getDateAndTimeForList() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
        return sdf.format(Fecha_nacimineto);
    }


}
