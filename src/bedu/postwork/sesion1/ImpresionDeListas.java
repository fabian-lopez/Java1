package bedu.postwork.sesion1;

import bedu.postwork.modelo.ListaTareas;
import bedu.postwork.modelo.Tarea;
import java.util.List;
import java.util.Date;

public class ImpresionDeListas {
    public static void printList(List<?> lista){
    	Date fecha = null;
    	short contador = 1;
    	
        if(lista == null) {
            Lector.muestraMensaje(".Lista vacía.");
            return;
        }

        if(lista.stream().count() == 0) {
            Lector.muestraMensaje("Lista vacía.");
            return;
        }

        if((lista.get(0) instanceof ListaTareas)){
            Lector.muestraMensaje("\n--- Listas de Tareas ---");
            for(Object lt : lista){
            	fecha = ((ListaTareas)lt).getFechaCreacion();
            	System.out.printf("%n%d.\t%tm.%td.%tY %tT %s", contador, fecha, fecha, fecha, fecha, (((ListaTareas)lt).getNombre()));
                //Lector.muestraMensaje("\n" + ((ListaTareas)lt).getFechaCreacion() + "\t" + (((ListaTareas)lt).getNombre()));
            	contador++;
            }
            System.out.printf("%n");
        }

        if((lista.get(0) instanceof Tarea)){
            Lector.muestraMensaje("\n--- TAREAS ---");
            String estado = "";            
            for(Object lt : lista){
            	estado = ((Tarea)lt).isRealizada() ? "[X]" : "[]";
            	fecha = ((Tarea)lt).getFechaCreacion();
                System.out.printf("%n%d.\t%s\t%tm.%td.%tY %tT %s", contador,  estado, fecha, fecha, fecha, fecha, (((Tarea)lt).getNombre()));
                //Lector.muestraMensaje("\n" + estado + "\t" + fecha + "]t" + (((Tarea)lt).getNombre()));
                contador++;
            }
            System.out.printf("%n");
        }
        
        Lector.muestraMensaje("Preciona cualquier tecla para regresar al menu principal:");
        Lector.leeEntrada();
    } //f:printList
    
    public static void printListConIndice(List<?> lista){
    	
    	short contador = 1;
    	Date fecha = null;

        if(lista == null) {
            Lector.muestraMensaje(".Lista vacía.");
            return;
        }

        if(lista.stream().count() == 0) {
            Lector.muestraMensaje("Lista vacía.");
            return;
        }

        if((lista.get(0) instanceof ListaTareas)){
            Lector.muestraMensaje("\n--- Listas de Tareas ---");
            for(Object lt : lista){
            	fecha = ((ListaTareas)lt).getFechaCreacion();
            	System.out.printf("%n%d.\t%tm.%td.%tY %tT %s", contador, fecha, fecha, fecha, fecha, (((ListaTareas)lt).getNombre()));
                //Lector.muestraMensaje("\n" + contador + ".\t" + ((ListaTareas)lt).getFechaCreacion() + "\t" + (((ListaTareas)lt).getNombre()));
                contador++;
            }
            System.out.printf("%n");
        }

        if((lista.get(0) instanceof Tarea)){
            Lector.muestraMensaje("\n--- TAREAS ---");
            String estado = "";            
            for(Object lt : lista){
            	estado = ((Tarea)lt).isRealizada() ? "[X]" : "[]";
            	fecha = ((Tarea)lt).getFechaCreacion();
                System.out.printf("%n%d.\t%s\t%tm.%td.%tY %tT %s", contador, estado, fecha, fecha, fecha, fecha, (((Tarea)lt).getNombre()));
                contador++;
            }
            System.out.printf("%n");
        }
    } //f:printList

} // class
