package com.szczypiorofix.sqlitewrapper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Locale;


public class DatabaseHandler extends SQLiteOpenHelper {

    private final String dbName;
    private final Context context;
    private final String createTableQuery;


    public DatabaseHandler( Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version, String createTableQuery ) {
        super( context, dbName, factory, version );
        this.context = context;
        this.dbName = dbName;
        this.createTableQuery = createTableQuery;
    }


    @Override
    public void onOpen( SQLiteDatabase db ) {
        super.onOpen(db);
    }

    @Override
    public void onCreate( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.setLocale( Locale.getDefault() );
        sqLiteDatabase.setVersion( 1 );

        try {
            sqLiteDatabase.execSQL( createTableQuery );
        } catch( SQLiteException sqlException ) {
            Log.e( context.getString( R.string.debug_name ), context.getString( R.string.plugin_name ) + " (onCreate) database error:" );
            Log.e( context.getString( R.string.debug_name ), context.getString( R.string.plugin_name ) + " " + sqlException.getMessage() );
        }

        Log.i( context.getString( R.string.debug_name ), context.getString( R.string.plugin_name ) + " (onCreate) Database path: " + sqLiteDatabase.getPath() + ", name: " + dbName + ", version:  " + sqLiteDatabase.getVersion() );

    }

    @Override
    public void onUpgrade( SQLiteDatabase sqLiteDatabase, int prevVer, int nextVer ) {

        Log.i( context.getString( R.string.debug_name ), context.getString( R.string.plugin_name ) + " (onUpgrade) Database " + dbName + " from version " + prevVer + " to version " + nextVer );

        // drop table?

        // onCreate( sqLiteDatabase );

    }


    public SQLiteDatabase getSQLiteDatabase() {
        return this.getWritableDatabase();
    }


    public Cursor selectQuery( String query ) {
        return this.getReadableDatabase().rawQuery( query, null );
    }


}
