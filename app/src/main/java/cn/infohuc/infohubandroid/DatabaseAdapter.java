package cn.infohuc.infohubandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  toctrash 14/05/2017.
 */

class DatabaseAdapter {
    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;

    DatabaseAdapter(Context context) {
        dbHelper = new DatabaseHelper(context.getApplicationContext());
    }

    DatabaseAdapter open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    void close() {
        dbHelper.close();
    }

    private Cursor getAllEntries() {
        String[] colums = new String[1];
        colums[0] = "name";
        return database.query("names", colums, null, null, null, null, null);
    }

    List<String> getAllNames() {
        ArrayList<String> names = new ArrayList<>();
        Cursor cursor = getAllEntries();
        if (cursor.moveToFirst()) {
            do {
                names.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return names;
    }

    boolean exists(String name) {
        Cursor cursor = database.rawQuery("select name from names where name=?", new String[]{name});
        boolean result = cursor.getCount() >= 1;
        cursor.close();
        return result;
    }

    long insertName(String name) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        return database.insert("names", null, values);
    }

    int deleteName(String name) {
        String whereClause = "name=?";
        String[] whereArgs = new String[1];
        whereArgs[0] = name;
        return database.delete("names", whereClause, whereArgs);
    }

    int deleteAllNames() {
        return database.delete("names", null, null);
    }

    int updateName(String name) {
        String whereClause = "name=?";
        String[] whereArgs = new String[1];
        whereArgs[0] = name;
        ContentValues values = new ContentValues();
        values.put("name", name);
        return database.update("names", values, whereClause, whereArgs);
    }
}
