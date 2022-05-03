

namespace sqlite_wrapper {
    
    public class SQLiteWrapper {

        public static readonly string DEBUG_NAME = "SQLITEWRAPPER_DEBUG";

        private Database mDatabase;


        public SQLiteWrapper( string name ) {
            mDatabase = new Database( name );
        }


        public string GetDatabaseName() {
            return mDatabase.Name;
        }


        public Database GetDatabase() {
            return mDatabase;
        }

    }

}
