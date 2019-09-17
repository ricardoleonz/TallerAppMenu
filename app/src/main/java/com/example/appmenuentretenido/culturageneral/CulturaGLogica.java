package com.example.appmenuentretenido.culturageneral;

public class CulturaGLogica extends CulturaG {

    public String validarRespuestasCG(){
        if(getPreguntaAL().equals("Cual es el lugar más frio de la tierra?")){
            return "La Antartida";
        }else if(getPreguntaAL().equals("Quién escribió la Odisea?")){
            return  "Homero";
        }else if(getPreguntaAL().equals("Como se llama la capital de Mongolia?")){
            return "Ulan Bator";
        }else if(getPreguntaAL().equals("Cual es el río más largo del mundo?")){
            return "Amazonas";
        }else if(getPreguntaAL().equals("En que continente está Ecuador?")) {
            return "America";
        }else if (getPreguntaAL().equals("Donde se originaron los juegos Olimpicos?")){
            return "Grecia";
        }else if (getPreguntaAL().equals("Que tipo de animal es la ballena?")){
            return "Mamifero";
        }
        return "";
    }

}
