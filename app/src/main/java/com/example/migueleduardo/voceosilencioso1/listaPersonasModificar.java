package com.example.migueleduardo.voceosilencioso1;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by MiguelEduardo on 22/07/2017.
 */

public class listaPersonasModificar extends ArrayAdapter<InformacionAlta> {
    private Activity context;
    private List<InformacionAlta> listapersonas;
    public listaPersonasModificar(Activity context, List<InformacionAlta>listapersonas){
        super(context, R.layout.activity_modificar,listapersonas);
        this.context=context;
        this.listapersonas= listapersonas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_modificar,null,true);
        TextView textViewnombre = (TextView) listViewItem.findViewById(R.id.txtlista1);
        TextView textViewpadre = (TextView) listViewItem.findViewById(R.id.txtlista2);
        TextView textViewcelular = (TextView)listViewItem.findViewById(R.id.txtlistview3);
        TextView textViewmarca = (TextView) listViewItem.findViewById(R.id.txtlista4);
        TextView textViewmodelo = (TextView) listViewItem.findViewById(R.id.txtlista5);
        TextView textViewmatricula = (TextView) listViewItem.findViewById(R.id.txtlista6);
        TextView textViewcolor = (TextView) listViewItem.findViewById(R.id.txtlista7);
        TextView textViewBendicion = (TextView) listViewItem.findViewById(R.id.txtlista8);
        InformacionAlta modificar = listapersonas.get(position);
        textViewnombre.setText(modificar.nombre);
        textViewpadre.setText(modificar.apellidos);
        textViewcelular.setText(modificar.celular);
        textViewmarca.setText(modificar.marcaauto);
        textViewmodelo.setText(modificar.nombreauto);
        textViewmatricula.setText(modificar.matricula);
        textViewBendicion.setText(modificar.nombredelniño);
        textViewcolor.setText(modificar.color);




        return listViewItem;


    }
}
