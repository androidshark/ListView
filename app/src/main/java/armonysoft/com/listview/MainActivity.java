package armonysoft.com.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

    //se definen vectores paralelos
    private String[] paises = {"Argentina","Chile","Paraguay","Bolivia","Peru","Ecuador","Brasil","Colombia","Venezuela","Uruguay"};
    private String[] habitantes = {"40000000", "17000000", "6500000","10000000", "30000000", "14000000", "183000000", "44000000","29000000", "3500000"};
    private TextView tv1;
    private ListView lv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //se asignan los objetos
    tv1 = (TextView)findViewById(R.id.tv1);
    lv1 = (ListView)findViewById(R.id.listView);
    //se crea un objeto de tipo arrayadapter
    ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,paises);
    lv1.setAdapter(adapter);


    lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView parent, View view, int position, long id) {
            tv1.setText("Poblacion de " + lv1.getItemAtPosition(position) + " es " + habitantes[position] );

        }
    });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
