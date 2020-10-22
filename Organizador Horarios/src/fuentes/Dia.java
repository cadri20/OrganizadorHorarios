/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes;

import sun.net.www.content.image.gif;

/**
 *
 * @author David Arteaga, Ariel Pillajo, Adrian Coloma
 */
public enum Dia {
    
    LUNES(0),MARTES(1),MIERCOLES(2),JUEVES(3),VIERNES(4),SABADO(5);
    
    private final int numero;

    private Dia(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
    /**
     * 
     * @param indice El indice del dia a escoger
     * @return El dia escogido. Devuelve nulo si el indice es invalido
     */
    public static Dia getDia(int indice){
        for(Dia dia: Dia.values()){
            if(dia.getNumero() == indice)
                return dia;
        }
        return null;
    }
}
