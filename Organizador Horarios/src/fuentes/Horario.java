package fuentes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Hp
 */
public class Horario {
    Collection<Materia> horario;
    public Horario(ArrayList<Materia> materias){
        horario = organizarHorario(materias);
    }
    
    private Collection<Materia> organizarHorario(ArrayList<Materia> materias){
        Collections.shuffle(materias);
        ArrayList<Materia> listaOrganizada = new ArrayList<Materia>();
        for(Materia materia: materias){
            if(listaOrganizada.isEmpty()){
                listaOrganizada.add(materia);
            }else{
                boolean colisiona = false; 
                for(Materia materia2: listaOrganizada){
                    if(materia.hayConflicto(materia2)){
                        colisiona = true;
                        break;   
                    }
                }
                if(!colisiona)
                    listaOrganizada.add(materia);
            }
        }
        Set<Materia> listaSinRepetidos = new HashSet<>(listaOrganizada);
        return listaSinRepetidos;
    }

    @Override
    public String toString() {
        String horarioString = "";
        for(Materia materia: horario)
            horarioString+= materia;
        return horarioString ;
    }
    
    
}
