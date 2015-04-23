package inei.asistencia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NoConnectionError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONObject;

public class LoginActivity extends Activity {
    Button btnLogin;
    EditText txtPassword;
    private String url = "https://enigmatic-meadow-6569.herokuapp.com/capacitacion/login?password=";
    private String password;
    public static String TAG = LoginActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.btn_login);
        txtPassword = (EditText) findViewById(R.id.txt_pass);
        callLogin();

    }

    private void callLogin() {

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = txtPassword.getText().toString().toUpperCase();
                final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Espere un momento", "Validando contraseña");
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                JsonObjectRequest request = new JsonObjectRequest(url + password, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Response json", response.toString());
                        progressDialog.cancel();
                        Intent intent = new Intent(LoginActivity.this.getApplicationContext(), UbigeoActivity.class);
                        intent.putExtra(UbigeoActivity.JSONOBJECT, response.toString());
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.cancel();
                        if (error instanceof NoConnectionError){
                            //add class without connection
                            Log.e(TAG, Log.getStackTraceString(error));
                            Toast.makeText(getApplicationContext(), "No hay conexión a Internet", Toast.LENGTH_LONG).show();
                        } else {
                            Log.e(TAG, Log.getStackTraceString(error) + " " + url + password);
                            Toast.makeText(getApplicationContext(), "Error de conexión", Toast.LENGTH_LONG).show();
                        }
                    }
                });
                queue.add(request); }
        });
    }
}
