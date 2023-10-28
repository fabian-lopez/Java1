package bedu.postwork.modelo;

import bedu.postwork.sesion1.Lector;
import bedu.postwork.sesion1.clsAlertas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;

public class ListaTareas implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 142217232827601238L;
	private String nombre;
    private List<Tarea> lTareas;
    private final Date fechaCreacion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public List<Tarea> getlTareas() {
        return lTareas;
    }

    public void setlTareas(Tarea tarea) {
        this.lTareas.add(tarea);
    }

    public clsAlertas removelTareas(String tarea) {
        boolean resultado = this.lTareas.removeIf(obj -> obj.getNombre().equals(tarea));
        if(resultado) return new clsAlertas("Tarea elimnada correctamente", false, (byte)1);
        else return new clsAlertas("No se encontró la tarea ingresada", true, (byte)2);
    }

    public long getTareasCount(){
        return this.lTareas.stream().count();
    }

    public void printTareas(){
        Lector.muestraMensaje("** TAREAS DE LA LISTA: " + getNombre() + "\n");
        for(Tarea t : lTareas){
            Lector.muestraMensaje("\n\t" + t.getNombre());
        }
    }

    {
        fechaCreacion = new Date();
    }

    public ListaTareas(String nombreLista){
        nombre = nombreLista;
        lTareas = new ArrayList<>();
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash = nombre.hashCode();
        hash += fechaCreacion.hashCode();
        hash += lTareas.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof ListaTareas)) return false;

        ListaTareas miObj = (ListaTareas) obj;
        return nombre.equalsIgnoreCase(miObj.nombre) &&
                fechaCreacion.equals(miObj.getFechaCreacion()) &&
                lTareas.hashCode() == miObj.lTareas.hashCode();
    }

} // class
