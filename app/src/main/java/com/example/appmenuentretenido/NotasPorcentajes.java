package com.example.appmenuentretenido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appmenuentretenido.notas.NotasPorClassLogica;

public class NotasPorcentajes extends AppCompatActivity {

    private TextView resultadoPorcentaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final NotasPorClassLogica notasPorClassLogica = new NotasPorClassLogica();

        EditText nota1;
        EditText nota2;
        EditText nota3;
        Button calcularPorcentaje;
        Button volver;


        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_notas_porcentajes);

        nota1 = findViewById(R.id.txtNota1);
        nota2 = findViewById(R.id.txtNota2);
        nota3 = findViewById(R.id.txtNota3);
        calcularPorcentaje = findViewById(R.id.btnCalcularPorcentaje);
        volver = findViewById(R.id.btnVolverPorcentaje);
        resultadoPorcentaje = findViewById(R.id.lblResultadoPor);

        notasPorClassLogica.setNota1(Double.parseDouble(nota1.getText().toString()));
        notasPorClassLogica.setNota2(Double.parseDouble(nota2.getText().toString()));
        notasPorClassLogica.setNota3(Double.parseDouble(nota3.getText().toString()));

        calcularPorcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultadoPorcentaje.setText(String.valueOf(notasPorClassLogica.calcularNotaPorcentaje()));
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NotasPorcentajes.this, Notas.class);
                startActivity(intent);
            }
        });
    }
}
