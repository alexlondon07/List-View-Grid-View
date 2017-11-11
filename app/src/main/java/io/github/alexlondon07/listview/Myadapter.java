package io.github.alexlondon07.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Myadapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public Myadapter(Context context, int layout, List<String> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        //View Holder Pattern
        ViewHolder holder;

        if(convertView == null){
            /* La vista no está creada, así que la crea. Cuando vuelva a comprobar
            * si existe, reutilizará el objeto convertView para ahorrarse la creación de un nuevo objeto.*/

            //Inflamos la vista que nos ha llegado con nuestro layout personalizado
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            layoutInflater.inflate(R.layout.list_item, null);

            /* Creamos un objeto de la clase ViewHolder y hacemos que cada atributo referencie
            * a un elemento del layout. Esta referencia se mantiene y cuando reutilicemos la vista
            * convertView ya no tendrá que llamar al método findViewById()*/
            holder.nameTextView = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }


        //Nos traemos el valor actual dependiente de la posicion
        String currentName = names.get(position);


        //Referenciamos el evento a modificar y lo rellenamos
        holder.nameTextView.setText(currentName);

        return convertView;

    }

    static class ViewHolder{
        private TextView nameTextView;


    }
}
