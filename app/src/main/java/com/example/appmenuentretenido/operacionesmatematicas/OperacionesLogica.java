package com.example.appmenuentretenido.operacionesmatematicas;

public class OperacionesLogica extends Operaciones {

    public double calculoDeOperaciones() {

        String valor = getOperador();

        if (valor.equals("+")) {
            return this.getNumero1() + this.getNumero2();
        }else if (valor.equals("-")){
            return this.getNumero1()-this.getNumero2();
        }else if (valor.equals("x")){
            return this.getNumero1()*this.getNumero2();
        }else if (valor.equals("/")){
            return this.getNumero1()/this.getNumero2();
        }
        return 0;
    }

}
