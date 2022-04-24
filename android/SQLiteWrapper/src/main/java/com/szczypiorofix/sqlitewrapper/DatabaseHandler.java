package com.szczypiorofix.sqlitewrapper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.Locale;


public class DatabaseHandler extends SQLiteOpenHelper {

    private final String dbName;
    private final Context context;



    public DatabaseHandler( Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version) {
        super( context, dbName, factory, version );
        this.context = context;
        this.dbName = dbName;
    }


    @Override
    public void onOpen( SQLiteDatabase db ) {
        super.onOpen(db);
        Log.i( context.getString( R.string.debug_name ), "Database opened." );
    }

    @Override
    public void onCreate( SQLiteDatabase sqLiteDatabase ) {
        sqLiteDatabase.setLocale( Locale.getDefault() );
        sqLiteDatabase.setVersion( 1 );

        // Create Settings data table:
//        try {
//            sqLiteDatabase.execSQL( Settings.CREATE_SETTINGS_TABLE );
//        } catch( SQLException sqlException ) {
//            Log.e( SQLiteWrapper.DEBUG_NAME, "onCreate Settings database error:" );
//            Log.e( SQLiteWrapper.DEBUG_NAME, sqlException.getMessage() );
//        }
//
//        // Create Downloaded apps data table:
//        try {
//            sqLiteDatabase.execSQL( DownloadedApps.CREATE_DOWNLOADED_APPS_TABLE );
//        } catch( SQLException sqlException ) {
//            Log.e( SQLiteWrapper.DEBUG_NAME, "onCreate Downloaded Apps database error:" );
//            Log.e( SQLiteWrapper.DEBUG_NAME, sqlException.getMessage() );
//        }
//
//        // Create Device Details data table:
//        try {
//            sqLiteDatabase.execSQL( DeviceDetails.getCreateDeviceDetailsTableQuery() );
//        } catch( SQLException sqlException ) {
//            Log.e( SQLiteWrapper.DEBUG_NAME, "onCreate Device Details database error:" );
//            Log.e( SQLiteWrapper.DEBUG_NAME, sqlException.getMessage() );
//        }

        Log.i( context.getString( R.string.debug_name ), "OnCreate: Database path: " + sqLiteDatabase.getPath() + ", name: " + dbName + ", version:  " + sqLiteDatabase.getVersion() );
    }

    @Override
    public void onUpgrade( SQLiteDatabase sqLiteDatabase, int prevVer, int nextVer ) {

        // drop Settings data table
//        try {
//            sqLiteDatabase.execSQL( Settings.DROP_SETTINGS_TABLE );
//        } catch( SQLException sqlException ) {
//            Log.e( SQLiteWrapper.DEBUG_NAME, "onUpgrade Settings database error:" );
//            Log.e( SQLiteWrapper.DEBUG_NAME, sqlException.getMessage() );
//        }
//
//        // drop Downloaded apps data table
//        try {
//            sqLiteDatabase.execSQL( DownloadedApps.DROP_DOWNLOADED_APPS_TABLE );
//        } catch( SQLException sqlException ) {
//            Log.e( SQLiteWrapper.DEBUG_NAME, "onUpgrade Downloaded apps database error:" );
//            Log.e( SQLiteWrapper.DEBUG_NAME, sqlException.getMessage() );
//        }
//
//        // drop Device Details data table
//        try {
//            sqLiteDatabase.execSQL( DeviceDetails.DROP_DEVICE_DETAILS_TABLE );
//        } catch( SQLException sqlException ) {
//            Log.e( SQLiteWrapper.DEBUG_NAME, "onUpgrade Device Details database error:" );
//            Log.e( SQLiteWrapper.DEBUG_NAME, sqlException.getMessage() );
//        }

        onCreate( sqLiteDatabase );
    }


    public SQLiteDatabase getSQLiteDatabase() {
        return this.getWritableDatabase();
    }


}
