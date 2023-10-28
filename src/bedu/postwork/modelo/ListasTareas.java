package bedu.postwork.modelo;

import bedu.postwork.sesion1.ImpresionDeListas;
import bedu.postwork.sesion1.Lector;
import bedu.postwork.sesion1.clsAlertas;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListasTareas implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7387754458988873057L;
	private List<ListaTareas> lListasTareas;

    public List<ListaTareas> getListasTareas(){
        return lListasTareas;
    }

    {
        lListasTareas = new ArrayList<>();
    }
    

    public clsAlertas agregaListaTarea(){
        Lector.muestraMensaje("==CREANDO NUEVA LISTA==\nIngresa nombre de la nueva lista: ");
        ListaTareas lt = new ListaTareas(Lector.leeEntrada());
        if(verificaExistenciaListaTarea(lt))
            return new clsAlertas("La lista ingresada ya existe.", true, (byte)2);

        lListasTareas.add(lt);
        return new clsAlertas("Lista agregada correctamente.", false, (byte)1);
    }

    public clsAlertas eliminaListaTarea(short indice){
        clsAlertas clsAlertas = validaIndice(indice);
        if(clsAlertas.existeError())
            return clsAlertas;

        lListasTareas.remove(indice);
        return new clsAlertas("OK", false, (byte)1);
    }

    public ListaTareas obtieneListaEspecifica(short indice){
        clsAlertas clsAlertas = validaIndice(indice);
        if(clsAlertas.existeError()) {
            Lector.muestraMensaje(clsAlertas.getMensaje());
        	return null;
        }

        return lListasTareas.get(indice);
    }

    private clsAlertas validaIndice(short indice){
        if(indice < 0) return new clsAlertas("Ingrese un índice valido mayor o igual a 0.", true, (byte)2);
        if(lListasTareas.stream().count() < indice) return new clsAlertas("El índice ingresado es mayor a la cantidad de tareas existentes", true, (byte)2);
        return new clsAlertas("OK", false, (byte)1);
    }

    private boolean verificaExistenciaListaTarea(ListaTareas lt) {
    	for(ListaTareas miLT : lListasTareas) {
    		if(miLT.getNombre().equals(lt.getNombre()))
    			return true;
    	}
    	return false;
    }
    
    public boolean validaOpcionMenu4Tareas(short opcion, short indiceSeleccionado) {
    	boolean sigueMostrandoSubmenu = true;
    	clsAlertas clsAlertas;
    	ManejadorTareas mt = new ManejadorTareas(this.lListasTareas.get(indiceSeleccionado).getlTareas());
    	
    	switch(opcion) {
	    	case 1: // Agregar nueva tarea
	    		clsAlertas = mt.agregaNuevaTarea();
	    		Lector.muestraMensaje(clsAlertas.getMensaje());
	    		break;
	    	case 2: // Eliminar tarea
	    		ImpresionDeListas.printListConIndice(mt.getlTarea());
	    		Lector.muestraMensaje("Selecciona indice de tarea a eliminar: ");
	    		clsAlertas = mt.eliminaListaTarea((short)(Lector.leeEntradaShort() - 1));
	    		Lector.muestraMensaje(clsAlertas.getMensaje());
	    		break;
	    	case 3: // marcar como finalizada
	    		ImpresionDeListas.printListConIndice(mt.getlTarea());
	    		Lector.muestraMensaje("Selecciona indice de tarea a cambiar estado: ");
	    		clsAlertas = mt.cambiaEstadoTarea((short)(Lector.leeEntradaShort() - 1));
	    		Lector.muestraMensaje(clsAlertas.getMensaje());
	    		break;
	    	case 4:
	    		sigueMostrandoSubmenu = false;
	    		break;
    	}
    	return sigueMostrandoSubmenu;
    }
    
    public void guardaInstancia() {

        try (FileOutputStream fileOut = new FileOutputStream("ListasTareas.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(this);
            Lector.muestraMensaje("Listas de Tareas fueron almacenadas en el archivo ListasTareas.ser\nPresiona cualquier tecla para salir.");
            Lector.leeEntrada();
        } catch (IOException e) {
            //e.printStackTrace();
        }
        
    }
    
    public static ListasTareas cargarInstancia() {
    	ListasTareas lt = new ListasTareas();
    	try(FileInputStream fileInput = new FileInputStream("ListasTareas.ser");
    		ObjectInputStream objectIn = new ObjectInputStream(fileInput)) {
    		
    		if(objectIn != null){
    			lt = (ListasTareas) objectIn.readObject();
	            Lector.muestraMensaje("Listas de Tareas cargada correctamente.");
    		}
    		
            return lt;
       } catch (IOException | ClassNotFoundException e) {
           //e.printStackTrace();
           return new ListasTareas();
       }
    }
    

    @Override
    public int hashCode(){
        int hash = 0;
        hash = lListasTareas.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof ListasTareas)) return false;

        ListasTareas miObj = (ListasTareas) obj;
        return  lListasTareas.hashCode() == miObj.lListasTareas.hashCode();
    }

} // class
