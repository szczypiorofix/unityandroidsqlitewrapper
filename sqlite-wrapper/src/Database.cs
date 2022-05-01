using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace sqlite_wrapper {
    
    class Database {


        private string mName;
        public string Name {
            get {
                return mName;
            }
            set {
                mName = value;
            }
        }


        public Database( string name ) {
            mName = name;
        }

    }

}
