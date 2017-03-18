package com.example.irving.empleadosrest.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.irving.empleadosrest.R;
import com.example.irving.empleadosrest.adaptadores.utilidades.OnClickItem;
import com.example.irving.empleadosrest.modelos.Empleado;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Irving on 14/03/2017.
 */
public class AdaptadorEmpleado extends RecyclerView.Adapter<AdaptadorEmpleado.ViewHolder> {
    private List<Empleado> dataset;
    private Context context;
    private OnClickItem onClickItem;

    public AdaptadorEmpleado(OnClickItem itemclick) {
        this.dataset = new ArrayList<>();
        this.onClickItem=itemclick;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_empleado, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Empleado empleado = dataset.get(position);
        holder.nombre.setText(empleado.getNombre());
        holder.apellido.setText(empleado.getApellido());
        holder.sueldo.setText(empleado.getSueldo());
        holder.fecha_nacimiento.setText(empleado.getFechaNacimiento());
        holder.fecha_registro.setText(empleado.getFechaRegistro());
        holder.email.setText(empleado.getCorreo());
        holder.setOnItemClickListener(empleado,onClickItem);

    }
    public void setDataset(ArrayList<Empleado> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nombre;
        public TextView apellido;
        public TextView sueldo;
        public TextView fecha_nacimiento;
        public TextView fecha_registro;
        public TextView email;

        public ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tv_nombre);
            apellido = (TextView) itemView.findViewById(R.id.text_apellido);
            sueldo = (TextView) itemView.findViewById(R.id.text_medical_center);
            fecha_nacimiento = (TextView) itemView.findViewById(R.id.text_fecha_registro);
            fecha_registro = (TextView) itemView.findViewById(R.id.tv_fechanacimiento);
            email = (TextView) itemView.findViewById(R.id.tv_email);
        }

        public void setOnItemClickListener(final Empleado r, final OnClickItem onItemClickListener)
        {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(r);
                }
            });
        }

    }
}
