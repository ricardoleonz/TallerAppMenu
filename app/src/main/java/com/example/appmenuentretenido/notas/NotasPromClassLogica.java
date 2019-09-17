package com.example.appmenuentretenido.notas;

public class NotasPromClassLogica extends NotasPromClass {

    public double calcularPromedio(){
        return ((this.getNumero1()+this.getNumero2()+this.getNumero3())/3);
    }
}
