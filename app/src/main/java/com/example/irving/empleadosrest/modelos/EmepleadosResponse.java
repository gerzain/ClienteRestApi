package com.example.irving.empleadosrest.modelos;

import java.util.ArrayList;

/**
 * Created by Irving on 13/03/2017.
 */
public class EmepleadosResponse
{
    private ArrayList<Empleado> empleados;

    public ArrayList<Empleado> getEmpleados()
    {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }


}
