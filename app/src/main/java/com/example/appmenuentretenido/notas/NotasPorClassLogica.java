package com.example.appmenuentretenido.notas;

public class NotasPorClassLogica extends NotasPorClass {

    public double calcularNotaPorcentaje(){
        return (this.getNota1()*0.3 + this.getNota2()*0.3+ this.getNota3()*0.4);
    }
}
