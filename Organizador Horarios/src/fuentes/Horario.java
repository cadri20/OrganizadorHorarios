package fuentes;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class Horario {
    ArrayList<Materia> horario;
    public Horario(ArrayList<Materia> materias){
        horario = organizarHorario(materias);
    }
    
    private ArrayList<Materia> organizarHorario(ArrayList<Materia> materias){
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
        return listaOrganizada;
    }

    @Override
    public String toString() {
        return "Horario{" + "horario=" + horario + '}';
    }
    
    
}
