package com.example.appmenuentretenido.operacionesmatematicas;

public class Operaciones {

    private double numero1;
    private double numero2;
    private double respuesta;
    private String operador;


    public Operaciones(){
        this.numero1 = 0;
        this.numero2 = 0;
        this.respuesta = 0;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getOperador() {
        return operador;
    }

    public double getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(double respuesta) {
        this.respuesta = respuesta;
    }

    public double getNumero1() {
        return numero1;
    }

    public double getNumero2() {
        return numero2;
    }

    public void setNumero1(double numero1) {
        this.numero1 = numero1;
    }

    public void setNumero2(double numero2) {
        this.numero2 = numero2;
    }
}
