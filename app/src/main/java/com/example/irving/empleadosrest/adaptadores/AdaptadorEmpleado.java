package com.example.irving.empleadosrest.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.irving.empleadosrest.R;
import com.example.irving.empleadosrest.modelos.Empleado;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Irving on 14/03/2017.
 */
public class AdaptadorEmpleado extends RecyclerView.Adapter<AdaptadorEmpleado.ViewHolder>
{
    private List<Empleado> dataset;
    private Context context;

    public AdaptadorEmpleado(List<Empleado> dataset) {
        this.dataset = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_empleado, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Empleado empleado=dataset.get(position);
        holder.nombre.setText(empleado.getNombre());
        holder.apellido.setText(empleado.getApellido());
        holder.sueldo.setText("$"+String.valueOf(empleado.getSueldo()) );
        holder.fecha_nacimiento.setText(empleado.getDateAndTimeForList());
        holder.fecha_registro.setText(empleado.getDateAndTimeForList());
        holder.email.setText(empleado.getEmail());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView nombre;
        public  TextView apellido;
        public  TextView sueldo;
        public  TextView fecha_nacimiento;
        public TextView fecha_registro;
        public TextView email;
        public ViewHolder(View itemView)
        {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.tv_nombre);
            apellido=(TextView)itemView.findViewById(R.id.text_apellido);
            sueldo=(TextView)itemView.findViewById(R.id.text_medical_center);
            fecha_nacimiento=(TextView)itemView.findViewById(R.id.text_fecha_registro);
            fecha_registro=(TextView)itemView.findViewById(R.id.tv_fechanacimiento);
            email=(TextView)itemView.findViewById(R.id.tv_email);

        }
    }

}
