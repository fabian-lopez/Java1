package bedu.postwork.modelo;

import java.util.List;

import bedu.postwork.sesion1.Lector;
import bedu.postwork.sesion1.clsAlertas;

public class ManejadorTareas {
	
	private List<Tarea> lTarea;

	public List<Tarea> getlTarea() {
		return lTarea;
	}
	
	public ManejadorTareas(List<Tarea> lt) {
		lTarea = lt;
	}
	
	public clsAlertas agregaNuevaTarea(){
        Lector.muestraMensaje("==AGREGA TAREA==\nIngresa nombre de la nueva tarea: ");
        Tarea t = new Tarea(Lector.leeEntrada());
        if(verificaExistenciaTarea(t))
            return new clsAlertas("La tarea ingresada ya existe.", true, (byte)2);

        lTarea.add(t);
        return new clsAlertas("Tarea agregada correctamente.", false, (byte)1);
    }

    public clsAlertas eliminaListaTarea(short indice){
        clsAlertas clsAlertas = validaIndice(indice);
        if(clsAlertas.existeError())
            return clsAlertas;

        lTarea.remove(indice);
        return new clsAlertas("Tarea eliminada correctamente.", false, (byte)1);
    }
    
    public clsAlertas cambiaEstadoTarea(short indice){
        clsAlertas clsAlertas = validaIndice(indice);
        if(clsAlertas.existeError())
            return clsAlertas;

        lTarea.get(indice).setRealizada();
        return new clsAlertas("Tarea actualizada correctamente.", false, (byte)1);
    }

    public clsAlertas obtieneTareaEspecifica(short indice){
        clsAlertas clsAlertas = validaIndice(indice);
        if(clsAlertas.existeError())
            return clsAlertas;

        return new clsAlertas(lTarea.get(indice).getNombre(), false, (byte)1);
    }

    private clsAlertas validaIndice(short indice){
        if(indice < 0) return new clsAlertas("Ingrese un índice valido mayor o igual a 0.", true, (byte)2);
        if(lTarea.stream().count() < indice) return new clsAlertas("El índice ingresado es mayor a la cantidad de tareas existentes", true, (byte)2);
        return new clsAlertas("OK", false, (byte)1);
    }

    private boolean verificaExistenciaTarea(Tarea t) {
    	for(Tarea miT : lTarea) {
    		if(miT.getNombre().equals(t.getNombre()))
    			return true;
    	}
    	return false;
    }
	
} // class
