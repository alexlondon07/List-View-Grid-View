package io.github.alexlondon07.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView_item);

        //Datos a mostrar
        List<String> names = new ArrayList<>();
        names.add("Alexander Londoño");
        names.add("Emiliana Londoño");
        names.add("Estefany Martinez");
        names.add("Alejandro Londoño");

        //Adaptador, forma visual en que mostramos nuestros datos
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);

        //Establecemos el adaptardor con nuestros Listview
        listView.setAdapter(adapter);
    }
}
