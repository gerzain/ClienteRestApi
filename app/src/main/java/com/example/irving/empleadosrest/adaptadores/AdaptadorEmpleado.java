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
    private SimpleDateFormat dateFormat;

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
        dateFormat=new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        holder.correo.setText(empleado.getApellido());
        holder.genero.setText(String.valueOf(empleado.getSueldo()) );
        holder.fecha_nacimiento.setText(dateFormat.format(empleado.getFecha_nacimineto()));
       // holder.fecha_registro.setText(dateFormat.format(empleado.getFecha_registro()));

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView nombre;
        public  TextView genero;
        public  TextView correo;
        public  TextView fecha_nacimiento;
        public TextView fecha_registro;
        public ViewHolder(View itemView)
        {
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.tv_sexo);
            genero=(TextView)itemView.findViewById(R.id.text_doctor_name);
            correo=(TextView)itemView.findViewById(R.id.text_medical_center);
            fecha_nacimiento=(TextView)itemView.findViewById(R.id.text_appointment_date);
            fecha_registro=(TextView)itemView.findViewById(R.id.tv_fechanacimiento);

        }
    }

}
