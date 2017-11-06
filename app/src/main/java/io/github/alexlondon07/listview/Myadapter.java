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

        //Copiamos la vista
        View view = convertView;

        //Inflamos la vista que nos ha llegado con nuestro layout personalizado
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.list_item, null);

        //Nos traemos el valor actual dependiente de la posicion
        String currentName = names.get(position);
        //currentName = (String) getItem(position);

        //Referenciamos el evento a modificar y lo rellenamos
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(currentName);


        return view;

    }
}
