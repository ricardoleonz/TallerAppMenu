package com.example.appmenuentretenido;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button salir;
        ImageButton opMate;
        ImageButton cultura;
        Button creditos;
        Button notas;

        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);

        notas = findViewById(R.id.btnNotas);
        creditos = findViewById(R.id.btnCreditos);
        salir=findViewById(R.id.btnSalir);
        opMate = findViewById(R.id.btnOperacionesMate);
        cultura = findViewById(R.id.btnCulturaGeneral);

        notas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Notas.class);
                startActivity(intent);
            }
        });

        creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Creditos.class);
                startActivity(intent);
            }
        });

        opMate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OperacionesMatematicas.class);
                startActivity(intent);
            }
        });

        cultura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CulturaGeneral.class);
                startActivity(intent);
            }
        });


        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            @SuppressLint("NewApi")
            public void onClick(View view) {

               finishAffinity();
            }
        });

    }

    @Override
    @SuppressLint("NewApi")
    public void onBackPressed() {
        super.onBackPressed();

        finishAffinity();
    }


}
