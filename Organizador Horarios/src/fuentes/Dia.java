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
    
    public static Dia getDia(int indice){
        switch(indice){
            case 0:
                return Dia.LUNES;
            case 1:
                return Dia.MARTES;
            case 2:
                return Dia.MIERCOLES;
            case 3:
                return Dia.JUEVES;
            case 4:
                return Dia.VIERNES;
            default:
                return null;
        }
    }
}
