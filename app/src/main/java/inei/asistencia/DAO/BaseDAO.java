package inei.asistencia.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import inei.asistencia.database.DatabaseHelper;

/**
 * Created by Cr-Diego on 27/04/2015.
 */
public class BaseDAO {
    private static final String TAG = BaseDAO.class.getSimpleName();

    public DatabaseHelper databaseHelper;
    //public HttpPo httpPostAux;

    public Integer cod_sede_operativa, cod_local_sede;

    public String SQL;
    public String where;
    public String valueString;
    public Integer valueInteger;
    public Long valueLong;

    public JSONObject jsonObject;
    public JSONArray jsonArray;

    public Cursor cursor = null;
    public ContentValues contentValues = null;


    /*
    public synchronized void initHttPostAux() {

        httpPostAux = HttpPostAux.getInstance();

    }
    */
    public void initDBHelper(Context paramContext) {

        databaseHelper = DatabaseHelper.getUtilDb( paramContext );

    }

    public synchronized void openDBHelper() {

        try
        {
            databaseHelper.openDataBase();
            databaseHelper.beginTransaction();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e(TAG, "Database open : " + e.toString());
        }

    }

    public synchronized void closeDBHelper() {

        try
        {
            databaseHelper.endTransaction();
            databaseHelper.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            Log.e( TAG, "Database close : " + e.toString() );
        }

    }

}
