package cn.infohuc.infohubandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author  toctrash on 13/05/2017.
 */

class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "names.db";
    private static final int VERSION = 1;

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME , null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE NAMES(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLES IF EXISTS NAMES;");
        onCreate(db);
    }
}
