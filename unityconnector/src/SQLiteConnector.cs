using System;
using System.Collections.Generic;
using UnityEngine;




namespace unityconnector {
    
    
    public class SQLiteConnector {

        public static readonly string DEBUG_NAME = "SQLITEWRAPPER_DEBUG";


        public SQLiteConnector() {
            Debug.Log( $"{ DEBUG_NAME }: Library (DLL) connected." );
        }



        public void testFunction() {
            Debug.Log( $"{ DEBUG_NAME }: test function..." );
        }



    
    
    }



}
