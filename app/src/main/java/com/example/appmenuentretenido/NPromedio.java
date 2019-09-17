package com.example.appmenuentretenido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appmenuentretenido.notas.NotasPromClassLogica;

public class NPromedio extends AppCompatActivity {

    NotasPromClassLogica notasPromClassLogica = new NotasPromClassLogica();


    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EditText num1;
        EditText num2;
        EditText num3;
        Button volverProm;
        Button calcularProm;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_promedio);

        num1 = findViewById(R.id.txtNum1);
        num2 = findViewById(R.id.txtNum2);
        num3 = findViewById(R.id.txtNum3);
        resultado = findViewById(R.id.lblResultadoProm);
        resultado.setVisibility(View.INVISIBLE);
        calcularProm = findViewById(R.id.btnCalcularProm);
        volverProm = findViewById(R.id.btnVolverProm);

        notasPromClassLogica.setNumero1(Double.parseDouble(num1.getText().toString()));
        notasPromClassLogica.setNumero2(Double.parseDouble(num2.getText().toString()));
        notasPromClassLogica.setNumero3(Double.parseDouble(num3.getText().toString()));

        volverProm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NPromedio.this, Notas.class);
                startActivity(intent);
            }
        });


        calcularProm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultado.setText(String.valueOf(notasPromClassLogica.calcularPromedio()));
                resultado.setVisibility(View.VISIBLE);

            }
        });

    }
}
