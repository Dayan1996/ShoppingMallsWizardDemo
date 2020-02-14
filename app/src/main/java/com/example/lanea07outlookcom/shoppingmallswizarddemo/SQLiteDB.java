package com.example.lanea07outlookcom.shoppingmallswizarddemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDB extends SQLiteOpenHelper
{
    //Se declaran e inicializan las variables encargadas de almacenar las consultas para crear la tabla 'Ventas',
    //y las consultas de eliminar/crear la Base de Datos 'Ferreteria.sqlite'.
        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + Estructura.TABLE_NAME + " (" +
                        Estructura.COLUMN_NAME_ID +  TEXT_TYPE + " PRIMARY KEY " + COMMA_SEP +
                        Estructura.COLUMN_NAME_NOMBRE + TEXT_TYPE + COMMA_SEP +
                        Estructura.COLUMN_NAME_EMAIL + TEXT_TYPE + COMMA_SEP +
                        Estructura.COLUMN_NAME_TELEFONO + TEXT_TYPE + COMMA_SEP +
                        Estructura.COLUMN_NAME_SITIO + TEXT_TYPE + " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + Estructura.TABLE_NAME;
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "Ferreteria.sqlite";

    public SQLiteDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }

    //Método para crear la Tabla que recibe la consulta Transact-SQL
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        //Método que elimina la tabla y vuelve a llamar al método que 	la crea
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int 	newVersion) {
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }
}
