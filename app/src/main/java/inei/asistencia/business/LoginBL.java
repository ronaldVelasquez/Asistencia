package inei.asistencia.business;

import android.util.Log;

import com.google.gson.Gson;
import inei.asistencia.entity.UbigeoE;

/**
 * Created by Cr-Diego on 27/04/2015.
 */
public class LoginBL {
    private UbigeoE ubigeoE = null;
    private static final String TAG = LoginBL.class.getSimpleName();

    public UbigeoE getUbigeoE(String jsonObjectString) {
        Log.e(TAG, "Datos de ubigeo: " + jsonObjectString);
        Gson gson = new Gson();
        ubigeoE = gson.fromJson(jsonObjectString, UbigeoE.class);
        return ubigeoE;
    }

}
