package com.example.appmenuentretenido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Vibrator;

import com.example.appmenuentretenido.operacionesmatematicas.OperacionesLogica;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;


public class OperacionesMatematicas extends AppCompatActivity {


    OperacionesLogica operacionesLogica = new OperacionesLogica();

    private TextView resultadoOculto;
    private EditText respuesta;
    private TextView respuestaOculta;
    private Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView numero1;
        TextView numero2;
        TextView operador;
        Button verificar;
        final Button reiniciar;
        Button volver;
        final ImageView imagenFeliz;
        final ImageView imagenTriste;


        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_operaciones_matematicas);





        numero1 = findViewById(R.id.lblNumero1);
        numero2 = findViewById(R.id.lblNumero2);
        resultadoOculto = findViewById(R.id.lblResultadoOculto);
        operador = findViewById(R.id.lblOperador);
        respuesta = findViewById(R.id.txtRespuesta);
        verificar = findViewById(R.id.btnVerificar);
        respuestaOculta = findViewById(R.id.lblRespuestaOculta);
        reiniciar = findViewById(R.id.btnReiniciar);
        volver = findViewById(R.id.btnVolverMenu);
        imagenFeliz = findViewById(R.id.imgFeliz);
        imagenTriste = findViewById(R.id.imgTriste);


        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        imagenFeliz.setVisibility(View.INVISIBLE);
        imagenTriste.setVisibility(View.INVISIBLE);
        reiniciar.setVisibility(View.INVISIBLE);
        respuestaOculta.setVisibility(View.INVISIBLE);
        resultadoOculto.setVisibility(View.INVISIBLE);


        String[] operadoresMatematicos = {"+", "-", "x", "/"};

        int operadorAleatorio = (int) Math.round(Math.random() * (4 - 1 + 1) + 1);
        double valorAleatorio = Math.floor(Math.random() * (50 - 1 + 1) + 1);
        double valorAleatorio2 = Math.floor(Math.random() * (50 - 1 + 1) + 1);

        numero1.setText(String.valueOf(valorAleatorio));
        operador.setText((operadoresMatematicos[operadorAleatorio]));
        numero2.setText((String.valueOf(valorAleatorio2)));

        operacionesLogica.setNumero1(Double.parseDouble(numero1.getText().toString()));
        operacionesLogica.setNumero2(Double.parseDouble(numero2.getText().toString()));
        operacionesLogica.setOperador((operador.getText().toString()));

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OperacionesMatematicas.this,MainActivity.class);
                startActivity(intent);
            }
        });

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormatSymbols simbolo = new DecimalFormatSymbols();
                simbolo.setDecimalSeparator('.');
                simbolo.setGroupingSeparator(',');

                DecimalFormat formateador = new DecimalFormat("##.##", simbolo);

                resultadoOculto.setText(String.valueOf(formateador.format(operacionesLogica.calculoDeOperaciones())));

                operacionesLogica.setRespuesta(Double.parseDouble(respuesta.getText().toString()));
                respuestaOculta.setText((String.valueOf(formateador.format(operacionesLogica.getRespuesta()))));

                if (respuestaOculta.getText().equals(resultadoOculto.getText())) {
                    Toast.makeText(getApplicationContext(), "Felicitaciones tu respuesta es correcta!", Toast.LENGTH_LONG).show();
                    reiniciar.setVisibility(view.VISIBLE);
                    imagenFeliz.setVisibility(View.VISIBLE);
                    imagenTriste.setVisibility(View.INVISIBLE);



                }else {
                    vibrator.vibrate(2000);
                    imagenFeliz.setVisibility(View.INVISIBLE);
                    imagenTriste.setVisibility(View.VISIBLE);
                    reiniciar.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "Tu respuesta es INCORRECTA!!!!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OperacionesMatematicas.this,OperacionesMatematicas.class);
                startActivity(intent);
            }
        });


    }
}
