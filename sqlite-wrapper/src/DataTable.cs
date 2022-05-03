
namespace sqlite_wrapper {


    class DataTable {


        private string mName;
        public string Name {
            get {
                return mName;
            }
            set {
                mName = value;
            }
        }

        private string mCreateTableQuery;
        public string CreateTableQuery {
            get {
                return mCreateTableQuery;
            }
            set {
                mCreateTableQuery = value;
            }
        }



        public DataTable( string name, string createTableQuety ) {
            mName = name;
            mCreateTableQuery = createTableQuety;
        }





    }

}
