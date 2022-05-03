using System;
using UnityEngine;



namespace sqlite_wrapper {

    class SqliteWrapperException : Exception {

        public SqliteWrapperException( string message ) : base( message ) {
            Debug.LogError( SQLiteWrapper.DEBUG_NAME + message );
        }

    }


}
