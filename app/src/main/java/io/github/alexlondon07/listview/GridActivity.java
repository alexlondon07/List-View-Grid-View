package io.github.alexlondon07.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
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

        registerForContextMenu(gridView);

    }


    //Inflamos el layout del menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    //Manejamos evento click en el menu opciones
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

    //Inflamos el layout del context menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        menu.setHeaderTitle(names.get(info.position));
        inflater.inflate(R.menu.context_menu, menu);
    }


    //Manejamos evento click en el context menu
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo() ;

        switch (item.getItemId()){

            case R.id.delete_item:
                //Borramos item clickeado
                this.names.remove(info.position);
                //Notificamos al adaptador que se actualice
                this.myadapter.notifyDataSetChanged();
                return true;

            default:
                return super.onContextItemSelected(item);
        }
    }
}
