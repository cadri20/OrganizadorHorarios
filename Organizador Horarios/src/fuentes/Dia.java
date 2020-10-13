/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuentes;

/**
 *
 * @author David Arteaga, Ariel Pillajo, Adrian Coloma
 */
public enum Dia {
    
    LUNES(0),MARTES(1),MIERCOLES(2),JUEVES(3),VIERNES(4);
    
    private final int numero;

    private Dia(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
    
}
