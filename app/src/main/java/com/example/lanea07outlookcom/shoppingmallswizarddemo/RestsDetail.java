package com.example.lanea07outlookcom.shoppingmallswizarddemo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RestsDetail extends AppCompatActivity
{
    String Tienda;
    int[] img;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rests_detail);

        //Recibir parámetro desde la llamada
        Intent intent = getIntent();
        this.img = intent.getIntArrayExtra("Logo");
        this.Tienda = intent.getStringExtra("Tienda");
        this.position = intent.getExtras().getInt("Position");

        //Se inicializa la clase.
        SQLiteDB basedatos = new SQLiteDB(this, "SMWDB", null, 1);

        //Clase que permite llamar a los métodos para crear, eliminar, leer y actualizar registros. Se establecen permisos de escritura.
        SQLiteDatabase sqlite = basedatos.getWritableDatabase();
        ContentValues content = new ContentValues();

        //Aquí reseteamos los valores de la tabla, si hay autoincrement este no se reinicia, tendría
        //que drop table

        sqlite.execSQL("DELETE FROM " + Estructura.TABLE_NAME);
        sqlite.execSQL("VACUUM");

        //Se añaden los valores introducidos de cada campo mediante clave(columna)/valor(valor introducido en el campo de texto)
        //Il Forno
        content.put(Estructura.COLUMN_NAME_ID, "T1");
        content.put(Estructura.COLUMN_NAME_NOMBRE, "Il Forno");
        content.put(Estructura.COLUMN_NAME_EMAIL, "ilforno@ilforno.com");
        content.put(Estructura.COLUMN_NAME_TELEFONO, "1234567");
        content.put(Estructura.COLUMN_NAME_SITIO, "www.ilforno.com");
        sqlite.insert(Estructura.TABLE_NAME, null, content);
        //Burger King
        content.put(Estructura.COLUMN_NAME_ID, "T2");
        content.put(Estructura.COLUMN_NAME_NOMBRE, "Burger King");
        content.put(Estructura.COLUMN_NAME_EMAIL, "burgerking@burgerking.com");
        content.put(Estructura.COLUMN_NAME_TELEFONO, "5896541");
        content.put(Estructura.COLUMN_NAME_SITIO, "www.burgerking.com");
        sqlite.insert(Estructura.TABLE_NAME, null, content);
        //Crepes & Waffles
        content.put(Estructura.COLUMN_NAME_ID, "T3");
        content.put(Estructura.COLUMN_NAME_NOMBRE, "Crepes & Waffles");
        content.put(Estructura.COLUMN_NAME_EMAIL, "crepesywaffles@crepesywaffles.com");
        content.put(Estructura.COLUMN_NAME_TELEFONO, "3564782");
        content.put(Estructura.COLUMN_NAME_SITIO, "www.crepesywaffles.com");
        sqlite.insert(Estructura.TABLE_NAME, null, content);
        //El Garaje
        content.put(Estructura.COLUMN_NAME_ID, "T4");
        content.put(Estructura.COLUMN_NAME_NOMBRE, "El Garaje");
        content.put(Estructura.COLUMN_NAME_EMAIL, "elgaraje@elgaraje.com");
        content.put(Estructura.COLUMN_NAME_TELEFONO, "4156512");
        content.put(Estructura.COLUMN_NAME_SITIO, "www.elgaraje.com");
        sqlite.insert(Estructura.TABLE_NAME, null, content);
        //Frisby
        content.put(Estructura.COLUMN_NAME_ID, "T5");
        content.put(Estructura.COLUMN_NAME_NOMBRE, "Frisby");
        content.put(Estructura.COLUMN_NAME_EMAIL, "frisby@frisby.com");
        content.put(Estructura.COLUMN_NAME_TELEFONO, "4896321");
        content.put(Estructura.COLUMN_NAME_SITIO, "www.frisby.com");
        sqlite.insert(Estructura.TABLE_NAME, null, content);
        //McDonalds
        content.put(Estructura.COLUMN_NAME_ID, "T6");
        content.put(Estructura.COLUMN_NAME_NOMBRE, "McDonalds");
        content.put(Estructura.COLUMN_NAME_EMAIL, "mcdonalds@mcdonalds.com");
        content.put(Estructura.COLUMN_NAME_TELEFONO, "4896321");
        content.put(Estructura.COLUMN_NAME_SITIO, "www.frisby.com");
        sqlite.insert(Estructura.TABLE_NAME, null, content);
        //Presto
        content.put(Estructura.COLUMN_NAME_ID, "T7");
        content.put(Estructura.COLUMN_NAME_NOMBRE, "Presto");
        content.put(Estructura.COLUMN_NAME_EMAIL, "presto@presto.com");
        content.put(Estructura.COLUMN_NAME_TELEFONO, "6853214");
        content.put(Estructura.COLUMN_NAME_SITIO, "www.presto.com");
        sqlite.insert(Estructura.TABLE_NAME, null, content);
        //Jeno's Pizza
        content.put(Estructura.COLUMN_NAME_ID, "T8");
        content.put(Estructura.COLUMN_NAME_NOMBRE, "Jenos Pizza");
        content.put(Estructura.COLUMN_NAME_EMAIL, "presto@presto.com");
        content.put(Estructura.COLUMN_NAME_TELEFONO, "6853214");
        content.put(Estructura.COLUMN_NAME_SITIO, "www.presto.com");
        sqlite.insert(Estructura.TABLE_NAME, null, content);

        //Se cierra la conexión abierta a la Base de Datos
        sqlite.close();
        buscarProducto(null);
    }

    //Evento On Click para guardar un producto en la tabla Ventas
    /*public void guardarProducto(View view)
    {
        //Se inicializa la clase.
        SQLiteDB basedatos = new SQLiteDB(this, "SMWDB", null, 1);

        //Clase que permite llamar a los métodos para crear, eliminar, leer y actualizar registros. Se establecen permisos de escritura.
        SQLiteDatabase sqlite = basedatos.getWritableDatabase();
        ContentValues content = new ContentValues();

        //Se añaden los valores introducidos de cada campo mediante clave(columna)/valor(valor introducido en el campo de texto)
        content.put(Estructura.COLUMN_NAME_ID, "'T1'");
        content.put(Estructura.COLUMN_NAME_NOMBRE, "'Il Forno'");
        content.put(Estructura.COLUMN_NAME_EMAIL, "'ilforno@ilforno.com'");
        content.put(Estructura.COLUMN_NAME_TELEFONO, "'1234567'");
        content.put(Estructura.COLUMN_NAME_SITIO, "'www.ilforno.com'");
        sqlite.insert(Estructura.TABLE_NAME, null, content);

        //Se cierra la conexión abierta a la Base de Datos
        sqlite.close();
    }*/

    public void buscarProducto(View view)
    {
        SQLiteDB basedatos = new SQLiteDB(this, "SMWDB", null, 1);
        //Se establecen permisos de lectura
        SQLiteDatabase sqlite = basedatos.getReadableDatabase();
        //Columnas que devolverá la consulta.
        String[] columnas = {
                Estructura.COLUMN_NAME_ID,
                Estructura.COLUMN_NAME_NOMBRE,
                Estructura.COLUMN_NAME_EMAIL,
                Estructura.COLUMN_NAME_TELEFONO,
                Estructura.COLUMN_NAME_SITIO
        };

        //Cláusula WHERE para buscar por producto
        //String tienda = Estructura.COLUMN_NAME_ID + " LIKE '" + edProducto.getText().toString() + "'";
        String tienda = Estructura.COLUMN_NAME_NOMBRE + " = '" + Tienda + "'";

        //Orden de los resultados devueltos por Producto, de forma Descendente alfabéticamente
        String ordenSalida = Estructura.COLUMN_NAME_ID + " DESC";

    //Ejecuta la sentencia devolviendo los resultados de los parámetros pasados de tabla, columnas, producto y orden de los resultados obtenidos.
        Cursor cursor = sqlite.query(Estructura.TABLE_NAME, columnas, tienda, null, null, null, ordenSalida);


        ImageView imgvw = (ImageView)findViewById(R.id.imvwLogo);
        if (cursor.moveToFirst()){
            while(!cursor.isAfterLast()){
                TextView txtName = (TextView) findViewById(R.id.txtName);
                TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
                TextView txtTelefono = (TextView) findViewById(R.id.txtTelefono);
                TextView txtSitio= (TextView) findViewById(R.id.txtSitio);
                txtName.setText(cursor.getString(1));
                txtEmail.setText(cursor.getString(2));
                txtTelefono.setText(cursor.getString(3));
                txtSitio.setText(cursor.getString(4));
                imgvw.setImageResource(img[position]);
                cursor.moveToNext();
            }
        }
        cursor.close();

    //Se cierra la conexión abierta a la Base de Datos
        sqlite.close();
    }
}
