package inei.asistencia.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = DatabaseHelper.class.getSimpleName();

    private static DatabaseHelper databaseHelper;

    public static final String DATABASE_NAME = "asistencia.sqlite";
    public static final int DATABASE_VERSION = 1;
    private String DATABASE_PATH = null;
    private Context mContext;


    private DatabaseHelper( Context context )
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext = context;
        DATABASE_PATH = "data/data/" + mContext.getPackageName() + "/databases/";
        //DB_PATH = "storage/sdcard0/" + mContext.getPackageName();
    }

    public static DatabaseHelper getUtilDb( Context context )
    {
        databaseHelper = new DatabaseHelper(context);

        if (!databaseHelper.isDataBaseExist())
        {
            try
            {
                databaseHelper.createDataBase();
            }
            catch (IOException e){
            }
        }

        return databaseHelper;
    }

    public boolean isDataBaseExist()
    {
        File dbFile = new File(DATABASE_PATH + DATABASE_NAME);
        Log.d(TAG, "The database exist: " + String.valueOf(dbFile.exists()));
        return dbFile.exists();
    }

    public void createDataBase() throws IOException
    {
        boolean isExistDB = isDataBaseExist();
        if (!isExistDB)
        {
            this.getReadableDatabase();
            try
            {
                copyDataBase();
            }
            catch (Exception e)
            {
                throw new Error("Error copying database");
            }
        }
    }

    private void copyDataBase() throws IOException
    {
        String outFileName = DATABASE_PATH + DATABASE_NAME;
        InputStream inputStream = mContext.getAssets().open("databases/"+DATABASE_NAME);
        OutputStream outputStream = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;

        while ( (length = inputStream.read(buffer)) > 0 )
        {
            outputStream.write(buffer, 0, length);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();

    }

    private SQLiteDatabase database;

    public SQLiteDatabase getDatabase()
    {
        return  database;
    }

    public synchronized void openDataBase() throws SQLException
    {
        String myPath = DATABASE_PATH + DATABASE_NAME;
        database = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING & SQLiteDatabase.OPEN_READWRITE);
    }

    public void beginTransaction()
    {
        database.beginTransaction();
    }

    public void setTransactionSuccessful()
    {
        database.setTransactionSuccessful();
    }

    public void endTransaction()
    {
        database.endTransaction();
    }

    @Override
    public synchronized void close()
    {
        if (database != null) database.close();
        super.close();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }

}
