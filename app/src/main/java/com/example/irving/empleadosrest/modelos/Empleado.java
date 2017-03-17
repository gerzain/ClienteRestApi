package com.example.irving.empleadosrest.modelos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Irving on 13/03/2017.
 */
public class Empleado
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("Nombre")
    @Expose
    private String nombre;
    @SerializedName("Correo")
    @Expose
    private String correo;
    @SerializedName("Apellido")
    @Expose
    private String apellido;
    @SerializedName("Sexo")
    @Expose
    private int sexo;
    @SerializedName("Sueldo")
    @Expose
    private String sueldo;
    @SerializedName("FechaNacimiento")
    @Expose
    private String fechaNacimiento;

    public Empleado(String apellido, String correo, String fechaNacimiento, String fechaRegistro, int id, String nombre, String nombreProfesion, int sexo, String sueldo) {
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
        this.id = id;
        this.nombre = nombre;
        this.nombreProfesion = nombreProfesion;
        this.sexo = sexo;
        this.sueldo = sueldo;
    }

    @SerializedName("FechaRegistro")
    @Expose
    private String fechaRegistro;
    @SerializedName("Nombre_profesion")
    @Expose
    private String nombreProfesion;

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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

    public String getNombreProfesion() {
        return nombreProfesion;
    }

    public void setNombreProfesion(String nombreProfesion) {
        this.nombreProfesion = nombreProfesion;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getSueldo() {
        return sueldo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "apellido='" + apellido + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", sexo=" + sexo +
                ", sueldo='" + sueldo + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                ", nombreProfesion='" + nombreProfesion + '\'' +
                '}';
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

}
