package inei.asistencia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import inei.asistencia.Library.UbigeoItem;


public class UbigeoActivity extends Activity {
    Button correct;
    Button incorrect;
    ListView listView;
    List items;
    String Sede, Usuario, NombreLocal, Direccion, jsonobject;
    Integer NAulas_t;
    private static final String TAG = UbigeoActivity.class.getSimpleName();
    public static final String JSONOBJECT = "jsonObject";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubigeo);
        Intent intent = getIntent();
        jsonobject = intent.getStringExtra(JSONOBJECT);

        setUbigeo();
        setList();

        listView = (ListView) findViewById(R.id.list_description);
        listView.setAdapter(new UbigeoItemAdapter(this, items));

        correct = (Button) findViewById(R.id.btn_correct);
        incorrect = (Button) findViewById(R.id.btn_incorrect);
        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), PadronActivity.class);
                startActivity(intent);
            }
        });
        incorrect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    private void setList() {
        items = new ArrayList();
        items.add(new UbigeoItem(R.mipmap.home, "Sede", Sede));
        items.add(new UbigeoItem(R.mipmap.person, "Usuario", Usuario));
        items.add(new UbigeoItem(R.mipmap.school, "Local de Capacitación", NombreLocal));
        items.add(new UbigeoItem(R.mipmap.place, "Dirección", Direccion));
        items.add(new UbigeoItem(R.mipmap.classroom, "Número Totales de Aulas", NAulas_t.toString()));
    }

    private void setUbigeo() {
        try{
            JSONObject jsonObject = new JSONObject(jsonobject);
            Log.e(TAG, jsonObject.toString());
            Sede = jsonObject.getString("sede_operativa");
            Usuario = jsonObject.getString("usuario");
            NombreLocal = jsonObject.getString("local");
            Direccion = jsonObject.getString("direccion");
            NAulas_t = jsonObject.getInt("aulas");
        } catch (JSONException e) {
            Log.e(TAG, Log.getStackTraceString(e));
        }
    }


    private class UbigeoItemAdapter extends BaseAdapter{
        private Context context;
        private List<UbigeoItem> items;

        public UbigeoItemAdapter(Context context, List<UbigeoItem> items) {
            this.context = context;
            this.items = items;
        }


        @Override
        public int getCount() {
            return this.items.size();
        }

        @Override
        public Object getItem(int position) {
            return this.items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (convertView == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = layoutInflater.inflate(R.layout.ubigeo_item, parent,false);
            }

            ImageView image = (ImageView) view.findViewById(R.id.imageView);
            TextView textViewTitle = (TextView) view.findViewById(R.id.txt_title);
            TextView textViewDescription = (TextView) view.findViewById(R.id.txt_description);

            UbigeoItem item = this.items.get(position);
            textViewTitle.setText(item.getTitle());
            textViewDescription.setText(item.getDescription());
            image.setImageResource(item.getImage());

            return view;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ( keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0 )
        {
            return true;
        }

        return super.onKeyDown( keyCode, event );
    }
}
