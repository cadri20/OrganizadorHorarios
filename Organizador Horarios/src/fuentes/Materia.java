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
public class Materia {
    
    String nombreMateria;
    DiaDeLaSemana dia;

    public Materia(String nombreMateria, Dia dia, String horaInicio, String horaFinal) {
        this.nombreMateria = nombreMateria;
        this.dia = new DiaDeLaSemana(dia, horaInicio, horaFinal);
    }

    @Override
    public String toString() {
        return "Materia{" + "nombreMateria=" + nombreMateria + ", dia=" + dia + '}';
    }
}
