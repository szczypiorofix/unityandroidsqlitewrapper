package com.szczypiorofix.sqlitewrapper;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


@SuppressWarnings("unused")
public class SQLiteWrapper {


    private DatabaseHandler databaseHandler;
    private final Context context;
    private SQLiteDatabase db;


    /**
     * Default constructor of SQLiteWrapper class.
     * @param context (Context) - context of the Android application.
     */
    @SuppressWarnings("unused")
    public SQLiteWrapper( Context context ) throws Exception {
        this.context = context;
        if ( context == null ) {
            throw new Exception( "IPRO_DEBUG: (SQLiteWrapper) Context application cannot be null !!!" );
        }
    }


    /**
     * Open database connection.
     * @param dbName (String) database file name.
     * @param version (int) database version
     */
    @SuppressWarnings("unused")
    public void openDatabase( String dbName, int version ) {
        databaseHandler = new DatabaseHandler( context, dbName, null, version );
        db = databaseHandler.getSQLiteDatabase();
        Log.i( context.getString( R.string.debug_name ), context.getString( R.string.plugin_name ) + " ( openDatabase ): Database " + databaseHandler.getDatabaseName() + " opened." );
    }

    /**
     * Close database connection.
     */
    @SuppressWarnings("unused")
    public void closeDatabase() {
        if ( databaseHandler == null ) {
            Log.e( context.getString( R.string.debug_name ), context.getString( R.string.plugin_name ) + " ( closeDatabase ): Database handler is null !!!" );
            return;
        }
        databaseHandler.close();
        Log.i( context.getString( R.string.debug_name ), context.getString( R.string.plugin_name ) + " ( closeDatabase ): Database " + databaseHandler.getDatabaseName() + " closed." );
    }


}
