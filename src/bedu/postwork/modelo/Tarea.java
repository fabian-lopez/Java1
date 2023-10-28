package bedu.postwork.modelo;

import java.io.Serializable;
import java.util.Date;

public class Tarea implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -782574446669787806L;
	private String nombre;
    private final Date fechaCreacion;
    private Date fechaExpiracion;
    private boolean realizada;
    private Date fechaRealizada;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public boolean isRealizada() {
        return realizada;
    }    

    public void setRealizada() {
        this.realizada = !isRealizada();
    }

    public Date getFechaRealizada() {
        return fechaRealizada;
    }

    public void setFechaRealizada(Date fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
    }

    {
        fechaCreacion = new Date();
    }
    
    public Tarea(String nombre){
        this.nombre = nombre;
    }

    @Override
    public int hashCode(){
        int hash = 0;
        hash = nombre.hashCode();
        hash += fechaCreacion.hashCode();
        hash += fechaExpiracion.hashCode();
        hash += fechaRealizada.hashCode();
        hash += Boolean.hashCode(realizada);
        return hash;
    }


    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(!(obj instanceof Tarea)) return false;

        Tarea aTest= (Tarea) obj;
        return nombre.equalsIgnoreCase(aTest.nombre) &&
                fechaCreacion.equals(aTest.getFechaCreacion()) &&
                fechaExpiracion.equals(aTest.fechaExpiracion) &&
                realizada == aTest.realizada &&
                fechaRealizada.equals(aTest.fechaRealizada);
    }
} // class
