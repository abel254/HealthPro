package com.example.healthpro.Exercise;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class DatabaseHelperExercise extends SQLiteOpenHelper {


    public DatabaseHelperExercise(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertData(String name, String description, String calories, int image){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO EXERCISE VALUES (NULL, ?, ?, ?, ?)";

        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, name);
        statement.bindString(2, description);
        statement.bindString(3, calories);
        statement.bindLong(4, image);
        statement.executeInsert();

    }

    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();

        return database.rawQuery(sql, null);
    }

    public void deleteAll(){
        SQLiteDatabase database = getWritableDatabase();
        database.delete("EXERCISE", null, null);
        database.execSQL("delete from EXERCISE");
        database.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
