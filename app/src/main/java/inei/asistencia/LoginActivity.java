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

import com.android.volley.AuthFailureError;
import com.android.volley.NoConnectionError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import inei.asistencia.business.LoginBL;
import inei.asistencia.entity.UbigeoE;
import inei.asistencia.utils.ConstantsUtil;

public class LoginActivity extends Activity {
    Button btnLogin;
    EditText txtPassword;
    private String url = "https://enigmatic-meadow-6569.herokuapp.com/capacitacion/login";
    private String password;
    public static String TAG = LoginActivity.class.getSimpleName();
    private LoginBL loginBL;
    private UbigeoE ubigeoE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.btn_login);
        txtPassword = (EditText) findViewById(R.id.txt_pass);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = txtPassword.getText().toString().toUpperCase();
                login();
            }
        });
    }

    public String getPassword() {
        return password;
    }

    private void login() {

        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Espere un momento", "Validando contraseña");
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, ConstantsUtil.URL, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e(TAG, "Response json: " + response.toString());
                if (!response.isNull("")){
                    ubigeoE = loginBL.getUbigeoE(response.toString());
                    Intent intent = new Intent(LoginActivity.this.getApplicationContext(), UbigeoActivity.class);
                    intent.putExtra(UbigeoActivity.JSONOBJECT, response.toString());
                    startActivity(intent);
                } else {
                    Log.e(TAG, "Password incorrecto: " + getPassword());
                    Toast.makeText(getApplicationContext(), "La contraseña ingresada es incorrecta", Toast.LENGTH_LONG).show();
                }
                progressDialog.cancel();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.cancel();
                if (error instanceof NoConnectionError){
                    //add class without connection
                    Log.e(TAG, Log.getStackTraceString(error) + " password: " + getPassword());
                    Toast.makeText(getApplicationContext(), "No hay conexión a Internet", Toast.LENGTH_LONG).show();
                } else {
                    Log.e(TAG, Log.getStackTraceString(error) + " password: " + getPassword());
                    Toast.makeText(getApplicationContext(), "Error de conexión", Toast.LENGTH_LONG).show();
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("password", getPassword());
                return params;
            }
        };
        queue.add(request); }

}
