package com.example.appmenuentretenido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button porcentajes;
        Button promedio;
        Button volverMenu;


        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_notas);

        porcentajes = findViewById(R.id.btnPorcentajes);
        promedio = findViewById(R.id.btnPromedio);
        volverMenu = findViewById(R.id.btnVolverMenu);

        volverMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notas.this, MainActivity.class);
                startActivity(intent);
            }
        });

        promedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ventanaProm = new Intent(Notas.this, NPromedio.class);
                startActivity(ventanaProm);
            }
        });

        porcentajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Notas.this, NotasPorcentajes.class);
                startActivity(intent);
            }
        });
    }
}
