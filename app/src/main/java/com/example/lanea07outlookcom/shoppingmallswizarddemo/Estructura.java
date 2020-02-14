package com.example.lanea07outlookcom.shoppingmallswizarddemo;

import android.provider.BaseColumns;

/*Una Clase Abstracta que implementa la interfaz BaseColumns, para establecer el nombre de la tabla,
 y los campos ‘producto’, ‘cantidad’ y ‘seccion’ definido como Constantes, ya que su valor no será modificado*/

public abstract class Estructura implements BaseColumns
{
    public static final String TABLE_NAME = "Tienda";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_NOMBRE = "nombre";
    public static final String COLUMN_NAME_EMAIL = "email";
    public static final String COLUMN_NAME_TELEFONO= "telefono";
    public static final String COLUMN_NAME_SITIO = "sitio_web";
}
