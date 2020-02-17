package com.example.lanea07outlookcom.shoppingmallswizarddemo;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class crearUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_usuario);
        Button btn = (Button) findViewById(R.id.btnCreateAccount);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(crearUsuario.this,Demo.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Usuario creado correctamente",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
