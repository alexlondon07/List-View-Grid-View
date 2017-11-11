package io.github.alexlondon07.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView_item);

        //Datos a mostrar
        names = new ArrayList<>();
        names.add("Alexander");
        names.add("Emiliana");
        names.add("Estefany");
        names.add("Alejandro");
        names.add("Aracelly ");
        names.add("Jesus ");
        names.add("Daniela ");
        names.add("Isabel");

        //Adaptador, forma visual en que mostramos nuestros datos
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //Establecemos el adaptardor con nuestros Listview
        //listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivity.this, "Clicked " +names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        //Enlazamos con nuestros adaprtador personalizado
        Myadapter myadapter = new Myadapter(this, R.layout.list_item, names);
        listView.setAdapter(myadapter);

    }
}

