package io.github.alexlondon07.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> names;
    private int counter = 0;
    private Myadapter myadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = findViewById(R.id.gridViewName);

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

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridActivity.this, "Clicked " +names.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        //Enlazamos con nuestros adaprtador personalizado
        myadapter = new Myadapter(this, R.layout.grid_item, names);
        gridView.setAdapter(myadapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item:
                //Añadimos nuevo nombre
                this.names.add("Add # " +(++counter));
                //Notificamos al adaptador que se actualice
                this.myadapter.notifyDataSetChanged();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
