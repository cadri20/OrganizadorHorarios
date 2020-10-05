package fuentes;

/**
 *
 * @author Hp
 */
public class Horario {
    ListaMaterias listaOrganizada;
    public Horario(ListaMaterias materias){
        listaOrganizada = organizarHorario(materias);
    }
    
    private ListaMaterias organizarHorario(ListaMaterias materias){
        ListaMaterias listaDesorganizada = new ListaMaterias();
        for(Materia materia: materias){
            for(HorarioMateria horarioMateria: materia.dias){
                System.out.println(horarioMateria.dia);
            }
        }
        return listaDesorganizada;
    }
    
}
