using UnityEngine;



namespace sqlite_wrapper {
    
    public class Database {


        private string mName;
        public string Name {
            get {
                return mName;
            }
            set {
                mName = value;
            }
        }


        private bool mOpened;
        public bool Opened {
            get {
                return mOpened;
            }
            set {
                mOpened = value;
            }
        }


        private readonly string SQLITE_PLUGIN_CLASS_NAME = "com.szczypiorofix.sqlitewrapper.SQLiteWrapper";
        private readonly AndroidJavaClass unityPlayerClass = null;
        private readonly AndroidJavaObject unityCurrentActivityObject = null;
        private readonly AndroidJavaObject sqliteWrapper = null;




        public Database( string name ) {

            mOpened = false;

            mName = name;

            try {
                unityPlayerClass = new AndroidJavaClass( "com.unity3d.player.UnityPlayer" );
            } catch( SqliteWrapperException upcE ) {
                Debug.LogError( $"{ SQLiteWrapper.DEBUG_NAME } (Database.constructor unityPlayerClass) Android sqlite wrapper error !" );
                Debug.LogError( $"{ SQLiteWrapper.DEBUG_NAME } (Database.constructor unityPlayerClass) { upcE }" );
            }

            if ( unityPlayerClass != null ) {

                try {
                    unityCurrentActivityObject = unityPlayerClass.GetStatic<AndroidJavaObject>( "currentActivity" );
                } catch ( SqliteWrapperException ucaoE ) {
                    Debug.LogError( $"{ SQLiteWrapper.DEBUG_NAME } (Database.constructor unityCurrentActivityObject) Android current activity error !" );
                    Debug.LogError( $"{ SQLiteWrapper.DEBUG_NAME } (Database.constructor unityCurrentActivityObject) { ucaoE }" );
                }

                if ( unityCurrentActivityObject != null ) {

                    try {
                        
                        sqliteWrapper = new AndroidJavaObject( SQLITE_PLUGIN_CLASS_NAME, unityCurrentActivityObject );

                        mOpened = true;

                    } catch ( SqliteWrapperException swE ) {
                        Debug.LogError( $"{ SQLiteWrapper.DEBUG_NAME } (Database.constructor sqliteWrapper) Android sqlite wrapper error !" );
                        Debug.LogError( $"{ SQLiteWrapper.DEBUG_NAME } (Database.constructor sqliteWrapper) { swE }" );
                        sqliteWrapper = null;
                    }

                }

            }

        }


        public void Open() {

            mOpened = true;

            Debug.Log( SQLiteWrapper.DEBUG_NAME + " (Database.Open) Database opened." );
        }


        public void Close() {

            mOpened = false;

            Debug.Log( SQLiteWrapper.DEBUG_NAME + " (Database.Close) Database closed." );
        }


    }

}
