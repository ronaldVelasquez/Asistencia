package inei.asistencia;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.btn_login);
        txtPassword = (EditText) findViewById(R.id.txt_password);

        //password = txtPassword.getText().toString();
        password = "ronald";
        url += password.toUpperCase();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Espere un momento", "Validando contraseña");
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Response json", response.toString());
                        progressDialog.cancel();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.cancel();
                        Log.e("Error: ", error.toString());
                    }
                });
                queue.add(request);
                Intent intent = new Intent(getApplicationContext(), UbigeoActivity.class);
                startActivity(intent);
            }
        });

    }

}
