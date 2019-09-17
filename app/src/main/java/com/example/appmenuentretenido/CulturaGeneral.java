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


import com.example.appmenuentretenido.culturageneral.CulturaGLogica;

public class CulturaGeneral extends AppCompatActivity {


    private Vibrator vibrator;
    private EditText respuesta;
    private ImageView correcta;
    private ImageView incorrecta;
    private Button reiniciarCultura;

    CulturaGLogica culturaGLogica = new CulturaGLogica();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView respuestaCultura;
        Button verificar;
        Button volver;
        TextView pregunta;



        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_cultura_general);

        verificar = findViewById(R.id.btnVerificarRespuesta);
        volver = findViewById(R.id.btnVolverCultura);
        pregunta = findViewById(R.id.lblPregunta);
        respuesta = findViewById(R.id.txtRespuestaPregunta);
        respuestaCultura = findViewById(R.id.lblRespuestaCultura);
        reiniciarCultura = findViewById(R.id.btnReiniciarCultura);
        correcta = findViewById(R.id.imagenCorrecta);
        incorrecta = findViewById(R.id.imagenIncorrecta);

        correcta.setVisibility(View.INVISIBLE);
        incorrecta.setVisibility(View.INVISIBLE);
        reiniciarCultura.setVisibility(View.INVISIBLE);
        respuestaCultura.setVisibility(View.INVISIBLE);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);


        String[] preguntasCultura = {"Cual es el lugar más frio de la tierra?", "Quién escribió la Odisea?", "Como se llama la capital de Mongolia?", "Cual es el río más largo del mundo?", "En que continente está Ecuador?", "Donde se originaron los juegos Olimpicos?", "Que tipo de animal es la ballena?"};
        int preguntaAleatorio = (int) Math.round(Math.random() * (7 - 1 + 1) + 1);
        pregunta.setText(preguntasCultura[preguntaAleatorio]);

        culturaGLogica.setPreguntaAL(pregunta.getText().toString());
        respuestaCultura.setText(culturaGLogica.validarRespuestasCG());

        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (culturaGLogica.validarRespuestasCG().equals(respuesta.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "TU RESPUESTA ES CORRECTA!!!!", Toast.LENGTH_SHORT).show();
                    reiniciarCultura.setVisibility(View.VISIBLE);
                    incorrecta.setVisibility(View.INVISIBLE);
                    correcta.setVisibility(View.VISIBLE);

                } else {

                    vibrator.vibrate(2000);
                    Toast.makeText(getApplicationContext(), "TU RESPUESTA ES INCORRECTA!!!!", Toast.LENGTH_SHORT).show();
                    correcta.setVisibility(View.INVISIBLE);
                    reiniciarCultura.setVisibility(View.INVISIBLE);
                    incorrecta.setVisibility(View.VISIBLE);
                }
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CulturaGeneral.this, MainActivity.class);
                startActivity(intent);
            }
        });

        reiniciarCultura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CulturaGeneral.this,CulturaGeneral.class);
                startActivity(intent);
            }
        });

    }
}
